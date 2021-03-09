package algorithms.communityDetection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import algorithms.graphs.AdjArray;

/**
 * Algorithme de Louvain
 */
public class Louvain {

	/**
	 * Graphe
	 */
	private AdjArray graph;	
	/**
	 * Liste des communautes de chaque noeud
	 */
	private List<Integer> comm;
	/**
	 * Modularite de chaque communaute
	 */
	private int[] modC;
	
	public Louvain(AdjArray graph)
	{
		this.graph = graph;
	}
	
	/**
	 * Louvain algorithme, cherche les communautes
	 */
	public void propagate()
	{
		comm = new ArrayList<Integer>();
		modC = new int[graph.size()];
		
		boolean swap = false;
		for(int i = 0; i < graph.size(); i++)
		{
			comm.add(i);
			modC[i] = graph.getGraphe()[i].size();
		}
		double q = Double.MIN_VALUE;
		do {
			swap = false;
			for(int i = 1; i < graph.size(); i++)
			{
				int commI = comm.get(i);
				modC[comm.get(i)] -=  graph.getGraphe()[i].size();
				
				double maxQ = Double.MIN_VALUE;
				int bestComm = commI;
				for(Integer j : graph.getGraphe()[i])
				{
					q = modularity(i, j);
					if(q >= maxQ)
					{
						maxQ = q;
						bestComm = comm.get(j);
						//comm.set(i, comm.get(j));
					}
				}
				modC[bestComm] += graph.getGraphe()[i].size();
				if(commI != bestComm)
				{
					swap = true;
					comm.set(i, bestComm);
				}
			}
		}while(swap);
		afficheLabels();
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return la modularite si i est dans la communaute j
	 */
	private double modularity(int i, int j)
	{
		return (graph.getGraphe()[i].size() - modC[comm.get(j)] * graph.getGraphe()[i].size() / graph.getNbEdges() * 1.0);
	}
	
	/**
	 * Affichage des noeuds avec leurs communautes
	 */
	public void afficheLabels()
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				System.out.print(comm.get((i * 100) + j) + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Exportation des noeuds avec leurs communautes dans un fichier
	 * @param path
	 * @param fileName
	 * @throws IOException
	 */
	public void exportToFile(final String path, final String fileName) throws IOException {
		File export = new File(path, fileName + ".txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(export));
		StringBuilder builder = new StringBuilder();
		
		int u = 0;
		for(LinkedList<Integer> l : graph.getGraphe()) {
			if(u == graph.size())
			{
				break;
			}
			u++;
			for(Integer v : l)
			{
				builder.append(comm.get(u) + "\t" + comm.get(v) + "\n");
			}
		}
		writer.write(builder.toString());
		writer.close();
	}
	
}
