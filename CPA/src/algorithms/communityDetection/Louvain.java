package algorithms.communityDetection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import algorithms.graphs.AdjArray;

public class Louvain {

	private AdjArray graph;	
	private List<Integer> comm;
	
	public Louvain(AdjArray graph)
	{
		this.graph = graph;
	}
	
	public void propagate()
	{
		comm = new ArrayList<Integer>();
		boolean swap = false;
		List<List<Integer>> module = new ArrayList<List<Integer>>();
		for(int i = 0; i < graph.size(); i++)
		{
			comm.add(i);
			module.add(new ArrayList<Integer>());
			module.get(i).add(i);
		}
		double q = Double.MIN_VALUE;
		double maxQ = Double.MIN_VALUE;
		do {
			//afficheLabels();
			swap = false;
			for(int u = 1; u < graph.size(); u++)
			{
				if(graph.getGraphe()[u] == null)
				{
					continue;
				}
				for(int i = 0; i < module.get(comm.get(u)).size(); i++)
				{
					if(module.get(comm.get(u)).get(i) == u) {
						module.get(comm.get(u)).remove(i);
					}
				}
				int idMax = -1;
				
				for(Integer v : graph.getGraphe()[u]/*graph.getGraphe()[u]*/)
				{
					//System.out.println(s + " " + module.get(comm.get(s)).size());
					module.get(comm.get(v)).add(u);
					double tmpQ = modularity(module);
					if(tmpQ > maxQ)
					{
						maxQ = tmpQ;
						idMax = v;
					}
					for(int i = 0; i < module.get(comm.get(v)).size(); i++)
					{
						if(module.get(comm.get(v)).get(i) == u) {
							module.get(comm.get(v)).remove(i);
						}
					}
				}
				//System.out.println("a" + u);
				if(idMax != -1)
				{
					if(comm.get(u) != comm.get(idMax)) {
						comm.set(u, comm.get(idMax));
						module.get(comm.get(idMax)).add(u);
						swap = true;
						//System.out.println(u + " " + idMax);
					} else {
						module.get(comm.get(u)).add(u);
					}
				} else {
					module.get(comm.get(u)).add(u);
				}
				q = maxQ;
			}
			afficheLabels();
		}while(swap);
		afficheLabels();
	}
	
	private double modularity(List<List<Integer>> module)
	{
		double somme = 0;
		for(int i = 1; i < graph.size(); i++)
		{
			for(int j = i + 1; j < graph.size(); j++)
			{
				if(graph.getGraphe()[i].contains(j)) 
				{
					if(module.get(comm.get(i)).contains(j))
					{
						somme += 1 - (graph.getGraphe()[i].size() * graph.getGraphe()[j].size()) / (2 * graph.getNbEdges()) * 1;
					} else {
						somme += 1 - (graph.getGraphe()[i].size() * graph.getGraphe()[j].size()) / (2 * graph.getNbEdges()) * 0;
					}
				} else {
					if(graph.getGraphe()[i].contains(j)) {
						somme += 0 - (graph.getGraphe()[i].size() * graph.getGraphe()[j].size()) / (2 * graph.getNbEdges()) * 1;
					} else {
						somme += 0 - (graph.getGraphe()[i].size() * graph.getGraphe()[j].size()) / (2 * graph.getNbEdges()) * 0;
					}
				}
			}
		}
			
		/*for(List<Integer> v : module)
		{
			//somme += v.size() - (Math.pow(v.size(), 2) / (4 * g.getNbEdges()));
		}*/
		return somme / graph.getNbEdges();
	}
	
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
