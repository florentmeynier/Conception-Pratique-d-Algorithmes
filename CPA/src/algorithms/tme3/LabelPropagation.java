package algorithms.tme3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import algorithms.graphs.AdjArray;

/**
 * Label propagation
 */
public class LabelPropagation 
{
	
	/**
	 * Graphe
	 */
	private AdjArray graph;
	/**
	 * Liste des noeuds dans un ordre aleatoire
	 */
	private List<Integer> liste;
	/**
	 * Liste des labels attribues aux noeuds
	 */
	private List<Integer> labels;
	
	
	public LabelPropagation(AdjArray graph)
	{
		this.graph = graph;
		liste = new ArrayList<>();
		labels = new ArrayList<>();
	}
	
	/**
	 * Algorithme de propagation
	 */
	public void propagate()
	{
		liste = new ArrayList<>();
		labels = new ArrayList<>();
		boolean swap = false;
		
		for(int i = 0; i < graph.size(); i++)
		{
			liste.add(i);
			labels.add(i);
		}
		do
		{
			swap = false;
			Collections.shuffle(liste);
			
			for(Integer u : liste)
			{
				if(u == 0)
				{
					break;
				}
				int max = 0;
				int idMax = 0;
				Map<Integer,Integer> m = new HashMap<>();

				for(Integer v : graph.getGraphe()[u])
				{
					int lv = labels.get(v);
					if(m.containsKey(lv))
					{
						int nbV = m.get(lv)+1;
						m.put(lv, nbV);
						if(nbV>max)
						{
							max = nbV;
							idMax = lv;
						}
					}else
					{
						m.put(lv, 1);
						if(idMax == 0)
						{
							idMax = lv;
							max = 1;
						}
					}
				}
				if(idMax == 0)
				{
					continue;
				}
				if(labels.get(u) != idMax)
				{
					labels.set(u, idMax);
					swap = true;
				}
			}
		}while(swap);
	}
	
	
	/**
	 * Affichage des noeuds avec leurs labels
	 */
	public void afficheLabels()
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				System.out.print(labels.get((i * 100) + j) + "\t");
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
				builder.append(labels.get(u) + "\t" + labels.get(v) + "\n");
			}
		}
		writer.write(builder.toString());
		writer.close();
	}
}

