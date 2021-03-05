package algorithms.densestSubgraph;

import java.util.ArrayList;
import java.util.List;

import algorithms.graphs.AdjArray;

public class KCoreDecomposition {
	
	private AdjArray g;
	
	public KCoreDecomposition(AdjArray g) {
		this.g = g;
	}
	
	@SuppressWarnings("unchecked")
	public int decompose() 
	{
		List<Integer> l = new ArrayList<Integer>();
		List<Integer> d = new ArrayList<Integer>();
		int max = 0;
		for(int i = 0; i < g.size(); i++)
		{
			if(g.getGraphe()[i] != null)
			{
				if(g.getGraphe()[i].size() > max)
				{
					max = g.getGraphe()[i].size();
				}
			}
		}
		List<Integer> []D = new ArrayList[max + 1];
		for(int i = 0; i < D.length; i++)
		{
			D[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < g.size(); i++)
		{
			if(g.getGraphe()[i] != null)
			{
				d.add(g.getGraphe()[i].size());
			} else {
				d.add(0);
			}
			D[d.get(i)].add(i);
			l.add(0);
		}
		int i = 0;
		for(int k = 0; k <= max; k++)
		{
			while(!D[k].isEmpty())
			{
				i = D[k].remove(0);
				l.set(i, k);
				if(g.getGraphe()[i] == null)
				{
					continue;
				}
				for(int v = 0; v < g.getGraphe()[i].size(); v++)
				{
					int j = g.getGraphe()[i].get(v);
					if(g.getGraphe()[j] == null)
					{
						continue;
					}
					if(g.getGraphe()[j].size() > k)
					{
						int dJ = g.getGraphe()[j].size();
						for(int u = 0; u < D[dJ].size(); u++)
						{
							if(D[dJ].get(u) == j)
							{
								D[dJ].remove(u);
								D[dJ - 1].add(j);
								d.set(j, d.get(j) - 1);
								break;
							}
						}
					}
				}
			}
		}
		int somme = 0;
		int cpt = 0;
		for(int z = 0; z < l.size(); z++)
		{
			if(l.get(z) > 0)  
			{
				somme += l.get(z);
				cpt++;
			}
		}
		
		int moy = somme / cpt;
		System.out.println(somme / (cpt * 1.0));
		System.out.println(max + " " + moy);
		
		return moy;
	}
	
	/*public int decompose()
	{
		int i = g.size();
		int c = 0;
		List<Integer> v = new ArrayList<>();
		for(int n = 1; n < g.size(); n++) {
			if(g.getGraphe()[n] != null)
			{
				v.add(n);
			}
		}
		while(!v.isEmpty())
		{
			System.out.println(v.size());
			int idMin = 0;
			int min = Integer.MAX_VALUE;
			for(int u = 1; u < g.size(); u++) 
			{
				if(g.getGraphe()[u] == null)
				{
					continue;
				}
				if(g.getGraphe()[u].size() < min)
				{
					idMin = u;
					min = g.getGraphe()[u].size();
				}
			}
			c = Math.max(c, g.getGraphe()[idMin].size());
			for(int n = 0; n < v.size(); n++)
			{
				if(v.get(n) == idMin)
				{
					v.remove(n);
				}
			}
			g.getGraphe()[idMin] = null;
			removeEdges(idMin);
			i--;
		}
		return c;
	}*/
	
	private void removeEdges(int v)
	{
		for(int i = 1; i < g.size(); i++)
		{
			if(g.getGraphe()[i] == null)
			{
				continue;
			}
			for(int j = 0; j < g.getGraphe()[i].size(); j++) {
				if(g.getGraphe()[i].get(j) == v)
				{
					g.getGraphe()[j].remove(j);
					break;
				}
			}
		}
	}

}
