package algorithms.tme3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import algorithms.graphs.AdjArrayEdge;
import algorithms.tme1.FindTriangles;
import algorithms.utils.Triangle;

/**
 * Implementation de notre propre algorithme de recherche de communaute fonctionnant avec les triangles
 */
public class TrianglePropagation {

	/**
	 * Graphe
	 */
	private AdjArrayEdge graph;
	/**
	 * Liste des labels de chaque noeud
	 */
	private List<Integer> labels;
	
	public TrianglePropagation(AdjArrayEdge graph)
	{
		this.graph = graph;
	}
	
	/**
	 * Algorithme de propagation et de recherche de clusters
	 */
	public void propagate() 
	{
		List<Triangle> list = new FindTriangles(graph).findTriangles();
		labels = new ArrayList<Integer>();
		boolean swap;
		
		for(int i = 0; i < graph.size(); i++)
		{
			labels.add(i);
		}
		List<Triangle> traite = new ArrayList<Triangle>();
		do
		{
			swap = false;
			
			for(Triangle t : list)
			{
				if(labels.get(t.getN1()) == labels.get(t.getN2()) && labels.get(t.getN1()) != labels.get(t.getN3()))
				{
					if(traite.contains(t))
					{
						continue;
					}
					traite.add(t);
					swap = true;
					labels.set(t.getN3(), labels.get(t.getN1()));
				} else if (labels.get(t.getN2()) == labels.get(t.getN3()) && labels.get(t.getN2()) != labels.get(t.getN1()))
				{
					if(traite.contains(t))
					{
						continue;
					}
					traite.add(t);
					swap = true;
					labels.set(t.getN1(), labels.get(t.getN2()));
					
				} else if(labels.get(t.getN1()) == labels.get(t.getN3()) && labels.get(t.getN1()) != labels.get(t.getN2()))
				{
					if(traite.contains(t))
					{
						continue;
					}
					traite.add(t);
					swap = true;
					labels.set(t.getN2(), labels.get(t.getN1()));
				} else {
					int rand = new Random().nextInt(3);
					switch(rand) 
					{
					case 0:
						labels.set(t.getN1(), labels.get(t.getN2()));
						break;
					case 1:
						labels.set(t.getN2(), labels.get(t.getN3()));
						break;
					case 2:
						labels.set(t.getN3(), labels.get(t.getN1()));
						break;
					default:
						break;
					}
				}
			}			
		} while(swap);
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
			u++;
			if(u == graph.size())
			{
				break;
			}
			for(Integer v : l)
			{
				builder.append(labels.get(u) + "\t" + labels.get(v) + "\n");
			}
		}
		writer.write(builder.toString());
		writer.close();
	}
	
}
