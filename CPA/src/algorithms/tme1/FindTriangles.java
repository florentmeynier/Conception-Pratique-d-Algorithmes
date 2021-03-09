package algorithms.tme1;

import java.util.ArrayList;
import java.util.List;

import algorithms.graphs.AdjArrayEdge;
import algorithms.graphs.Edge;
import algorithms.utils.Triangle;

/**
 * Recherche des triangles d'un graphe
 */
public class FindTriangles {

	/**
	 * Graphe
	 */
	private AdjArrayEdge graph;
	
	public FindTriangles(AdjArrayEdge graph)
	{
		this.graph = graph;
	}
	
	/**
	 * Algorithme de recherche des triangles
	 * @return la liste des triangles
	 */
	public List<Triangle> findTriangles()
	{
		List<Triangle> res = new ArrayList<Triangle>();
		
		for(Edge e : graph.getEdges())
		{
			int u = e.getFrom();
			int v = e.getTo();
			int i = 0, j = 0;
			List<Integer> vu = graph.getGraphe()[u];
			List<Integer> vv = graph.getGraphe()[v];
			while(i < vu.size() && vu.get(i)  <= v)
			{
				i++;
			}
			while(j < vv.size() && vv.get(j) <= u)
			{
				j++;
			}
			while(i < vu.size() && j < vv.size())
			{
				if(vu.get(i) < vv.get(j))
				{
					i++;
				} else if(vu.get(i) > vv.get(j))
				{
					j++;
				} else 
				{
					res.add(new Triangle(u, v, vu.get(i)));
					i++;
					j++;
				}
			}
		}
		return res;
	}	
}
