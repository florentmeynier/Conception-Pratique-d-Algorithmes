package algorithms.graphs;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Stockage d'un graphe avec seulement ses arrêtes
 */
public class EdgeArray 
{
	
	/**
	 * Liste des arrêtes
	 */
	private Set<Edge> edges;

	public EdgeArray() 
	{
		this.edges = new LinkedHashSet<Edge>();
	}
	
	/**
	 * Ajout d'une arrête dans le graphe
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to)
	{
		edges.add(new Edge(from,to));
	}
	
	/**
	 * 
	 * @return la liste des arrêtes
	 */
	public Set<Edge> getEdges()
	{
		return edges;
	}
	
	/**
	 * 
	 * @return le nombre d'arrêtes du graphe
	 */
	public int size() 
	{
		return edges.size();
	}
}
