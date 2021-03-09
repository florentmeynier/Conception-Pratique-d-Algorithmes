package algorithms.tme1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import algorithms.graphs.AdjArray;

/**
 * Algorithme de BFS
 */
public class BFS {

	/**
	 * Graphe a etudier
	 */
	private AdjArray graphe;
	
	public BFS(AdjArray graphe)
	{
		this.graphe = graphe;
	}
	
	/**
	 * Algorithme
	 * @param s noeud de depart
	 * @return le noeud d'arrive et la distance parcouru
	 */
	public int execute(int s)
	{
		boolean visited[] = new boolean[graphe.size()];
		int distances [] = new int[graphe.size()];
		Arrays.fill(distances, 0);
		
		int d = 0;

		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			if(d==0 || queue.isEmpty())
				System.out.print(s + " ");
			
			Iterator<Integer> i = (graphe.getGraphe())[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					distances[n] = distances[s]+1;
					queue.add(n);
				}
				d=s;
			} 
		}
		System.out.println();
		System.out.println(distances[d]);
		return d;
	}
	
}
