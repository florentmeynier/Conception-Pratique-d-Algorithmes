package algorithms.tme1;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Graphe de la question 1
 */
public class Graphe 
{
	
	/**
	 * Nombre d'arretes constituant le graphe
	 */
	private long edges;
	/**
	 * Liste des noeuds
	 */
	private Set<Long> nodes;

	public Graphe() 
	{
		this.edges = 0;
		this.nodes = new LinkedHashSet<Long>();
	}
	
	/**
	 * Ajout d'une arrete dans le graphe
	 * @param n1
	 * @param n2
	 */
	public void addEdge(long n1, long n2)
	{
		edges++;
		nodes.add(n1);
		nodes.add(n2);
	}

	/**
	 * 
	 * @return le nombre d'arretes du graphe
	 */
	public long getNbEdges()
	{
		return edges;
	}
	
	/**
	 * 
	 * @return le nombre de noeuds du graphe
	 */
	public int getNbNodes()
	{
		return nodes.size();
	}
}
