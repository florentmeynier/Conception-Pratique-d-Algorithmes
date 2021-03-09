package algorithms.graphs;

import java.util.LinkedList;

/**
 * Stockage d'un graphe en Adj-Array
 */
public class AdjArray {
	
	/**
	 * Graphe avec les voisins stockes de chaque noeud
	 */
	private LinkedList<Integer> [] graphe;
	/**
	 * Noeud d'indice maximum du graphe
	 */
	private int max = Integer.MIN_VALUE;
	/**
	 * Si le graphe est oriente ou non
	 */
	private final boolean isOriented;
	/**
	 * Nombre d'arretes du graphes
	 */
	private int nbEdges;

	@SuppressWarnings("unchecked")
	public AdjArray(boolean isOriented, int size) 
	{
		graphe = new LinkedList[size + 1];
		for(int i = 0; i < size + 1; i++) 
		{
			graphe[i] = new LinkedList<>();
		}
		this.isOriented = isOriented;
		nbEdges = 0;
		max = size;
	}
	
	/**
	 * Ajout d'une arrete dans le graphe
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to)
	{
        graphe[from].add(to);
        if(!isOriented) 
        {
        	graphe[to].add(from);
        }
        nbEdges++;
    }
	
	/**
	 * 
	 * @return le noeud d'indice maximum du graphe
	 */
	public int getMax() {
		return max;
	}

	/**
	 * 
	 * @return la taille du graphe
	 */
	public int size()
	{
		return graphe.length;
	}

	/**
	 * 
	 * @return le graphe
	 */
	public LinkedList<Integer>[] getGraphe() {
		return graphe;
	}
	
	/**
	 * 
	 * @return si le graphe est oriente ou non
	 */
	public boolean isOriented()
	{
		return isOriented;
	}
	
	/**
	 * 
	 * @return le nombre d'arretes composant le graphe
	 */
	public int getNbEdges()
	{
		return nbEdges;
	}
}
