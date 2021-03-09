package algorithms.graphs;

/**
 * Arrete d'un graphe
 */
public class Edge 
{
	/**
	 * Noeud de depart
	 */
	private int from;
	/**
	 * Noeud d'arrive
	 */
	private int to;

	public Edge(int from, int to) 
	{
		this.from = from;
		this.to = to;
	}

	/**
	 * 
	 * @return le noeud de depart
	 */
	public int getFrom() 
	{
		return from;
	}

	/**
	 * 
	 * @return le noeud d'arrive
	 */
	public int getTo() 
	{
		return to;
	}

}
