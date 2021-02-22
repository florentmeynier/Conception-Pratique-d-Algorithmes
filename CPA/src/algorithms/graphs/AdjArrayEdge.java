package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjArrayEdge extends AdjArray {

	private List<Edge> edges;
	
	public AdjArrayEdge(boolean isOriented, int size) {
		super(isOriented, size);
		edges = new ArrayList<Edge>();
	}
	
	@Override
	public void addEdge(int from, int to) {
		super.addEdge(from, to);
		
		edges.add(new Edge(from, to));
	}
	
	public List<Edge> getEdges()
	{
		return this.edges;
	}

}
