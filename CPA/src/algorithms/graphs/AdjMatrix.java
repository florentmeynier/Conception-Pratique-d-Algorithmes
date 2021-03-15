package algorithms.graphs;

/**
 * Stockage d'un graphe dans une matrice
 */
public class AdjMatrix 
{
	
	/**
	 * Matrice du graphge
	 */
	private boolean [][] graphe;
	
	public AdjMatrix(int size) 
	{
		graphe = new boolean [size][size];
	}
	
	/**
	 * Ajout d'une arrête dans le graphe
	 * @param from
	 * @param to
	 */
	public void addEdge(int from,int to)
	{
        graphe[from][to] = true;
    }
	
	/**
	 *
	 * @return la taille du graphe
	 */
	public int size()
	{
		return graphe.length;
	}

}
