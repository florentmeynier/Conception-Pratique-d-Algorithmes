package algorithms.densestSubgraph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algorithms.densestSubgraph.data.ResultKCore;
import algorithms.graphs.AdjArray;

/**
 * Core decomposition
 */
public class KCoreDecomposition {
	
	/**
	 * Graphe
	 */
	private AdjArray g;
	
	public KCoreDecomposition(AdjArray g) {
		this.g = g;
	}
	
	/**
	 * Algorithme de core decomposition d'un graphe
	 * @return le resultat de l'algorithme stocke dans la classe ResultKCore
	 */
	public ResultKCore decompose() 
	{
		List<Integer> l = new ArrayList<Integer>();
		List<Integer> d = new ArrayList<Integer>();
		int dMax = 0;
		for(int i = 0; i < g.size(); i++) // Get maximum degree
		{
			if(g.getGraphe()[i].size() > dMax)
			{
				dMax = g.getGraphe()[i].size();
			}
		}
		List<List<Integer>> D = new ArrayList<>();
		for(int i = 0; i < dMax + 1; i++) // Generate our list of list of degree
		{
			D.add(new ArrayList<Integer>());
		}
		int sommeD = 0;
		int nbNodes = 0;
		for(int i = 0; i < g.getMax(); i++)
		{
			d.add(g.getGraphe()[i].size());
			D.get(d.get(i)).add(i);
			l.add(0);
			sommeD += g.getGraphe()[i].size();
			nbNodes++;
		}
		int i = 0;
		for(int k = 0; k <= dMax; k++)
		{
			while(!D.get(k).isEmpty())
			{
				i = D.get(k).remove(0);
				l.set(i, k);
				for(int v = 0; v < g.getGraphe()[i].size(); v++)
				{
					int j = g.getGraphe()[i].get(v);
					if(g.getGraphe()[j].size() > k)
					{
						int dJ = g.getGraphe()[j].size();
						for(int u = 0; u < D.get(dJ).size(); u++)
						{
							if(D.get(dJ).get(u) == j)
							{
								D.get(dJ).remove(u);
								D.get(dJ - 1).add(j);
								d.set(j, d.get(j) - 1);
								break;
							}
						}
					}
				}
			}
		}
		
		return new ResultKCore(dMax, l, (sommeD / nbNodes));
	}
	
	
	/**
	 * Exportation du resultat dans un fichier
	 * @param path
	 * @param fileName
	 * @param result
	 * @throws IOException
	 */
	public void exportToFile(final String path, final String fileName, ResultKCore result) throws IOException {
		File export = new File(path, fileName + ".txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(export));
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < result.getCores().size(); i++) {
			if(result.getCores().get(i) == 0 || g.getGraphe()[i].isEmpty())
			{
				continue;
			}
			builder.append(result.getCores().get(i) + "\t" + g.getGraphe()[i].size() + "\n");
		}
			
		writer.write(builder.toString());
		writer.close();
	}
	
}
