import matplotlib.pyplot as pp 
import numpy as np 
import pandas as pd
import networkx as nx 
import sys

def visualise_graph(f) :
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

    df = pd.DataFrame({'from': X,'to':Y})
    G = nx.from_pandas_edgelist(df,source='from',target='to')
    color_map = []
    for node in G:
        if node < 100:
            color_map.append('blue')
        elif node < 200 : 
            color_map.append('green')
        elif node < 300 :
            color_map.append('red')
        else :
            color_map.append('yellow')

    nx.draw(G,node_color = color_map,with_labels = True)

    pp.show()

visualise_graph(sys.argv[1])



