import matplotlib.pyplot as pp 
import numpy as np 
import pandas as pd
import networkx as nx 
import sys

pp.rcParams['agg.path.chunksize'] = 10000

def generate(f):
    fname = str(f)
    data = np.loadtxt(fname = fname, delimiter = '\t')
    X = []
    Y = []
    for i in range(len(data)) :
        for j in range(2):
            if j == 0 :
                X.append(data[i][j])
            else :
                Y.append(data[i][j])
                    
    pp.scatter(x = X, y = Y, c = Y)
    pp.colorbar(orientation = "vertical")
    pp.show()

filename = sys.argv[1]
generate(filename)
pp.savefig(filename[:len(filename) - 3] + "png")
pp.show()
