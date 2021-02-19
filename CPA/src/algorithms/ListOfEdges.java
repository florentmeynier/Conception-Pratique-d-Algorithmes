package algorithms;

import java.util.LinkedHashSet;
import java.util.Set;

public class ListOfEdges 
{
	private Set<Edge> edges;

	public ListOfEdges() 
	{
		// TODO Auto-generated constructor stub
		this.edges = new LinkedHashSet<Edge>();
	}
	
	public void addEdge(int from, int to)
	{
		edges.add(new Edge(from,to));
	}
	
	 public int size() 
	 {
		 return edges.size();
	 }
}
