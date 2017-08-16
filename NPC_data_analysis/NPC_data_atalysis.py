
from __future__ import print_function

import math
import numpy as np

#import nsfg
import thinkstats2
import thinkplot
import matplotlib.pyplot as pt

import datetime
d = datetime.date.today()

import pandas as pd


#retruns the Irregular, regular, Average User of the product

def makeuser(df):
    
    y = df.groupby('User_id').NPS_score.count()

    irregular = y.index.values[y <=5]
    average = y.index.values[(y>5) & (y <= 10)]
    regular = y.index.values[y > 10]

    iregular_stats = df.loc[df.User_id.isin(irregular),:]
    average_stats = df.loc[df.User_id.isin(average),:]
    regular_stats = df.loc[df.User_id.isin(regular),:]

    return iregular_stats,average_stats,regular_stats



#determines the variables which are monotonically increasing    
def monotonic(x):
    
    return pd.all(pd.diff(x) > 0)


#computes the customer retention rate
def crr(x,y,z):
    return ((x-y)/z)

#returns the customer retention rate value for the each customer over the whole peiod.

def customer_retention_rate_var(df):

    first = df.loc[df.Time.dt.year == 2016,:]
    second = df.loc[df.Time.dt.year == 2017,:]

    variable = []

    for i in range (1,13):

            if(i == 1):
                retention = 1
                variable.append(retention)
                
            else:
                
                n = first.loc[first.Time.dt.month == i-1 , 'User_id']
                j = first.loc[first.Time.dt.month == i , 'User_id']
                p = set(j.unique()) - set(n.unique())
                final = len(j.unique())
                initial = len(n.unique())
                new = len(p)
                retention = crr(final,new,initial)
                variable.append(retention)


    for i in range (1,6):
        if(i == 1):
            
            n = first.loc[first.Time.dt.month == 12 , 'User_id']
            j = second.loc[second.Time.dt.month == 1 , 'User_id']
        
        else:
            n = second.loc[second.Time.dt.month == i-1 , 'User_id']
            j = second.loc[second.Time.dt.month == i , 'User_id']
            p = set(j.unique()) - set(n.unique())
            final = len(j.unique())
            initial = len(n.unique())
            new = len(p)
            retention = crr(final,new,initial)
            variable.append(retention)

    return variable
    
    
#returns the datafarame's with interquartile range  >= 2 , >= 6
def inter_quartile_range(df):


    y = df.groupby('User_id').NPS_score.count()

    regular = y.index.values[y > 10]
    regular_stats = df.loc[df.User_id.isin(regular), : ]
    
    index = range(0,len(regular))
    columns = ['Userid','iqr']
    df_ = pd.DataFrame(index=index, columns=columns)
    df_['Userid'] = regular
    
    variable = []

    for i in range (0,len(regular)):

        userid = regular[i]
        npsscore = regular_stats.loc[regular_stats.User_id == userid, 'NPS_score']
        iqr = npsscore.quantile(0.75) - npsscore.quantile(0.25)
        variable.append(iqr)

        
    df_['iqr'] = variable
    fading = df_.loc[df_.iqr <= 2 ,'Userid']
    varied = df_.loc[df_.iqr >= 6 ,'Userid']

    return fading,varied


 
    
    
    






def main(script):

    #loads the data_set
    df = pd.read_csv('...../Fun/npc_data_set.csv')

    #preprocessing of each column

    df.columns = df.columns.str.replace(' ','_')

    df['Time'] = pd.to_datetime(df.Time)

    #Histogram of NPS Score
    pt.figure()

    plt = df.groupby('NPS_score').User_id.count().plot(kind = 'bar',title = 'Histogram')
    
    pt.show()

    #calculating and plotting customer retention rate

    cmrr = customer_retention_rate_var(df)

    print(cmrr)
    
    xs = np.arange(len(cmrr)) 
    width = 1
    
    pt.figure()
    LABELS = ["1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"]
    
    plt = pt.bar(xs,cmrr, align='center')
    pt.xticks(xs, LABELS)
    
    pt.title('Customer retention rate for the whole period')
    pt.xlabel('Months')
    pt.ylabel('Customer reterntion rate')
    
    pt.show()

    #divides the dataset into regular, iregular, average customers

    irregular,average,regular = makeuser(df)


    #plotting the mean and standard deviation of the each category
    pt.figure()

    plt = regular.groupby('User_id').NPS_score.agg(['mean','std']).plot(kind = 'line')
    plt = average.groupby('User_id').NPS_score.agg(['mean','std']).plot(kind = 'line')
    plt = irregular.groupby('User_id').NPS_score.agg(['mean','std']).plot(kind = 'line')
    
    #plt = average.groupby('User_id').NPS_score.agg(['min','max']).plot(kind = 'line')
    #plt = irregular.groupby('User_id').NPS_score.agg(['min','max']).plot(kind = 'line')
    #plt = regular.groupby('User_id').NPS_score.agg(['min','max']).plot(kind = 'line')
    

    pt.show()

    #data analysis of regular customers with interquartile range <= 2 and >= 6

    fading,varied = inter_quartile_range(regular)

    iqr_less = df.loc[df.User_id.isin(fading), : ]
    iqr_greater = df.loc[df.User_id.isin(varied), : ]


    pt.figure()
    plt = iqr_less.groupby('User_id').NPS_score.agg(['mean','std']).plot(kind = 'bar',title = 'Median for customers with interquartile range <= 2')

    plt = iqr_greater.groupby('User_id').NPS_score.agg(['mean','std']).plot(kind = 'bar',title = 'Median for customers with interquartile range >= 6')
    pt.show()

    
    
     

   

    


if __name__ == '__main__':
    import sys
    main(*sys.argv)




