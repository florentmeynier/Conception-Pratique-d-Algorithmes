package algorithms.graphs;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Stockage d'un graphe avec seulement ses arr�tes
 */
public class EdgeArray 
{
	
	/**
	 * Liste des arr�tes
	 */
	private Set<Edge> edges;

	public EdgeArray() 
	{
		this.edges = new LinkedHashSet<Edge>();
	}
	
	/**
	 * Ajout d'une arr�te dans le graphe
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to)
	{
		edges.add(new Edge(from,to));
	}
	
	/**
	 * 
	 * @return la liste des arr�tes
	 */
	public Set<Edge> getEdges()
	{
		return edges;
	}
	
	/**
	 * 
	 * @return le nombre d'arr�tes du graphe
	 */
	public int size() 
	{
		return edges.size();
	}
}
