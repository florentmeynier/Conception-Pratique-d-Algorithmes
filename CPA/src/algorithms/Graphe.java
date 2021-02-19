package algorithms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Graphe 
{
	private long edges;
	private Set<Long> nodes;

	public Graphe() 
	{
		// TODO Auto-generated constructor stub
		this.edges = 0;
		this.nodes = new LinkedHashSet<Long>();
	}
	
	public void addEdge(long n1, long n2)
	{
		edges++;
		nodes.add(n1);
		nodes.add(n2);
	}

	public long getNbEdges()
	{
		return edges;
	}
	
	public int getNbNodes()
	{
		return nodes.size();
	}
}
