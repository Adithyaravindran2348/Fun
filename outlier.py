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
import pydotplus
from scipy import misc 
import io

def main(script):
    df = pd.read_csv('C:\\Users\\adith\\Desktop\\work\\Goals.csv')
    #plt = df[df.Attendance == 'small'].sum_goals.plot(kind = 'scatter')
    l = df[df.Attendance == 'without fans']
    l.to_csv('without_fans.csv')


if __name__ == '__main__':
    import sys
    main(*sys.argv)
