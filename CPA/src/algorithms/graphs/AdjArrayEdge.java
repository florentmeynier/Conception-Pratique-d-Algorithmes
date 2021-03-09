package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

/** 
 * Stockage d'un graphe en Adj-Array avec ses arretes
 */
public class AdjArrayEdge extends AdjArray {

	/**
	 * Liste des arretes
	 */
	private List<Edge> edges;
	
	public AdjArrayEdge(boolean isOriented, int size) {
		super(isOriented, size);
		edges = new ArrayList<Edge>();
	}
	
	/**
	 * Ajout d'une arrete dans le graphe
	 */
	@Override
	public void addEdge(int from, int to) {
		super.addEdge(from, to);
		
		edges.add(new Edge(from, to));
	}
	
	/**
	 * 
	 * @return la liste des arretes
	 */
	public List<Edge> getEdges()
	{
		return this.edges;
	}

}
