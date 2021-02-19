package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelPropagation 
{
	
	private List<Integer> liste;
	private List<Integer> labels;
	
	
	public LabelPropagation()
	{
		liste = new ArrayList<>();
		labels = new ArrayList<>();
	}
	
	public void labelPropa (AdjArray graph)
	{
		liste = new ArrayList<>();
		labels = new ArrayList<>();
		boolean swap = false;
		int cpt = 0; 
		
		for(int i = 0; i < graph.size(); i++)
		{
			liste.add(i);
			labels.add(i);
			
		}
		
		do
		{
			swap = false;
			Collections.shuffle(liste);
			
			for(int i = 0; i < liste.size(); i++)
			{
				int u = liste.get(i);
				if(u == 0)
				{
					break;
				}
				int max = 0;
				int idMax = 0;
				Map<Integer,Integer> m = new HashMap<>();
				System.out.println(graph.getGraphe()[u]);

				for(Integer v : graph.getGraphe()[u])
				{
					int lv = labels.get(v);
					System.out.println(v+" "+lv);
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
							idMax =lv;
							max = 1;
						}
					}
					
				}
				if(idMax == 0)
				{
					continue;
				}
				
				if(labels.get(u)!=idMax)
				{
					labels.set(u, idMax);

					swap = true;
				}
			}
			System.out.println(cpt++);
		}while(swap);
	}
	
	public void afficheLabels()
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				System.out.print(labels.get((i*100)+j)+"\t");
			}
			System.out.println();
		}
	}
}
