import math
import numpy as np
import pandas as pd
import matplotlib
import matplotlib.pyplot as pt
pt.style.use('ggplot')
import os
import sklearn
from sklearn.tree import DecisionTreeRegressor
from sklearn.tree import export_graphviz
from sklearn.model_selection import train_test_split
from sklearn.metrics import  mean_squared_error
import graphviz
import pydotplus as pydot
from scipy import misc 
import io
from sklearn.externals.six import StringIO

os.environ["PATH"] += os.pathsep + 'D:/Program Files (x86)/Graphviz2.38/bin/'


def quartile_study(df):
    
    q1 = df.quantile(0.25)
    q3 = df.quantile(0.75)
    IQR = q3 - q1

    lower = q1 - 1.5 * IQR
    upper = q3 + 1.5 * IQR

    return lower, upper
    

def main(script):

    df = pd.read_csv('C:\\Users\\adith\\Desktop\\work\\Goals.csv')
    counted = pd.read_csv('C:\\Users\\adith\\Desktop\\work\\unique_count.csv')
    
    #print(df.isnull().any())
    #there is no numll value

    check = counted[counted.check_unique <= 10]
    #check = counted[counted.check_unique < 100]
    #print(check)
    #plt = check['check_unique'].plot(kind = 'hist')

    #plt = df['L1'].plot(kind = 'hist')
    #pt.title('Histogram of goals expected to be scored by team 1')
    #pt.xlabel('L1 value')
    #pt.show()

    lower_l1,upper_l1 = quartile_study(df['L1'])
    lower_l2,upper_l2 = quartile_study(df['L2'])
    
    outlier_check = df[(df.L1 < lower_l1 ) | (df.L1 > upper_l1) | (df.L2 < lower_l2) | (df.L2 > upper_l2)]
    
    #explode = (0, 0, 0, 0.1, 0.2, 0.3, 0.4, 0,  0.1, 0.2, 0.3, 0.4,0.0,0.0,0.0,0.1, 0.1, 0.2, 0.3, 0.4, 0.3, 0.2)
    #plt = df.groupby('Weather').sum_goals.agg('count').plot(kind = 'pie',labels=['','','','','','','','','','','','','','','','','','','','','',''], explode=explode,  autopct='%1.0f%%', pctdistance=1.1)# 'mean','std' 'min','max'
    #plt.legend(df.groupby('Weather').sum_goals.agg('count').index,loc="best")
    #pt.title('Count of goals scored wrt Weather')
    #pt.show()

    plt = df.groupby('PitchCondition').sum_goals.agg('count').plot(kind = 'pie',labels=['','','','','','','','','','','',''], autopct='%1.0f%%', pctdistance=1.1,labeldistance=1.5)
    plt.legend(df.groupby('PitchCondition').sum_goals.agg('count').index,loc="best")
    pt.title('summary statistic of goals scored wrt PitchCondition')
    pt.show()
    
    
    #print(outlier_check['sum_goals'].describe())
    #plt = outlier_check['sum_goals'].plot(kind = 'hist')
    #legend()
    #pt.title('Histogram of total goals')
    #pt.xlabel('Outlier Goals')
    #pt.show()

    #plt = df['competitionIdx'].value_counts().plot(kind = 'bar')
    #pt.title('count of each competition')
    #pt.show()
    #hp = df['competitionIdx'].value_counts() == 1
    #print(counted[counted.check_unique <100].describe())

    x = pd.read_csv('C:\\Users\\adith\\Desktop\\work\\initial_model\\x_num.csv')
    y = pd.read_csv('C:\\Users\\adith\\Desktop\\work\\initial_model\\initial_y.csv')
    msk = np.random.rand(len(df)) < 0.8
    x_train = x[msk]
    y_train = y[msk]
    
    x_test = x[~msk]
    y_test = y[~msk]
    #x_train.to_csv('x_train.csv' ,  index = False)
    #y_train.to_csv('y_train.csv' ,  index = False)
    x_test.to_csv('x_test.csv' ,  index = False)
    y_test.to_csv('y_test.csv' ,  index = False)
    

    
    #x['A'] = x['Attendance'].replace(['small','full','medium','not defined','without fans'], [1, 2, 3, 4, 5])
    #x['B'] = x['Weather'].replace(['windy','good','Hot','rainy','Cold','Mild','Light rain','Heavy rain','Sun','Fog',
    #                     'Light Wind','stormy','Cloudy','High Wind','Thunderstorm','Indoor Stadium','snowy',
    #                     'not defined','very hot','Light snow','Heavy snow','Sleet/Hail'], [1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22])
    #x['C'] = x['PitchCondition'].replace(['good','Excellent','Wet and Fast','Slow due to water','Regular',
    #                            'Arthificial turf','Uneven & Cutting up','not defined','wet',
    #                            'Goalmouths affected' ,'snowy','Hard or Frozen'], [1, 2, 3, 4, 5, 6,7,8,9,10,11,12])
    #x.to_csv('x_num.csv')
    
    #regr_1 = DecisionTreeRegressor(max_depth=3)
    #regr_2 = DecisionTreeRegressor(max_depth=5)
    #y_2 = regr_2.predict(X_test)

    
    #regr_1.fit(x_train, y_train)
    #y_1 = regr_1.predict(x_test)
    #y_test['predict'] = y_1
    #print(y_test)
    #print((y_test.head()))

    #print(np.sqrt(mean_squared_error(y_test['output'],y_test['predict'])))
    #dot_data = StringIO()
    #print(np.sqrt(((y_test['predict'] - y_test['output']) ** 2).mean()))
    #dotfile = open("C:\\Users\\adith\\Desktop\\work\\initial_model\\dtree2.dot", 'w')
    #dotfile = export_graphviz(regr_1, out_file='tree.dot', feature_names = x_train.columns)
    #dotfile.close()
    #system(dot -Tpng 'tree.dot' -o tree.png )
    #graph = pydot.graph_from_dot_file('tree.dot')
    #graph.write_png('somefile.png')
    
    #graph = pydotplus.graph_from_dot_data(dot_data.getvalue())  
    #graph.write_pdf('tree.pdf')
    #graph.create_png()
    #regr_1.plot()
    #pt.show()
    #dot -Tps tree.dot -o tree.ps
    
    
    #graph = graphviz.Source(dotfile)  
    #graph.render('dtree_render',view=True)
    #system("dot -Tpng D:.dot -o C:\\Users\\adith\\Desktop\\work\\initial_model\\dtree2.png")
    
    #regr_2.fit(x_test, y_test)
   

    
    

    
if __name__ == '__main__':
    import sys
    main(*sys.argv)
