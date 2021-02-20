package algorithms.tme1;

import java.util.ArrayList;
import java.util.List;

import algorithms.communityDetection.Triangle;
import algorithms.graphs.AdjArray;

public class FindTriangles {

	private AdjArray graph;
	
	public FindTriangles(AdjArray graph)
	{
		this.graph = graph;
	}
	
	public List<Triangle> findTriangles() 
	{
		List<Triangle> list = new ArrayList<Triangle>();
		
		for(int i=0; i<graph.getGraphe().length;i++)
		{
			if(graph.getGraphe()[i]==null)
				continue;
			int u = i;
			for(int j=0; j<graph.getGraphe()[u].size();j++)
			{
				int v = graph.getGraphe()[u].get(j);
				if(v <= u)
					continue;
				for(int k=0;k<graph.getGraphe()[v].size();k++)
				{
					int w = graph.getGraphe()[v].get(k);
					if(w <= v)
						continue;
					for(int h = 0;h<graph.getGraphe()[w].size();h++)
					{
						if(u == graph.getGraphe()[w].get(h))
						{
							list.add(new Triangle(u, v, w));
							break;
						}
					}
					
				}
			}
		}
		return list;
	}
	
}
