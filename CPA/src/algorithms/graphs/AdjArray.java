package algorithms.graphs;

import java.util.LinkedList;

public class AdjArray {
	
	private LinkedList<Integer> [] graphe;
	private int max = Integer.MIN_VALUE;
	private final boolean isOriented;

	@SuppressWarnings("unchecked")
	public AdjArray(boolean isOriented, int size) 
	{
		graphe = new LinkedList[size];
		for(int i = 0; i < size; i++) 
		{
			graphe[i] = new LinkedList<>();
		}
		this.isOriented = isOriented;
	}
	
	public void addEdge(int from, int to)
	{
        graphe[from].add(to);
        if(!isOriented) 
        {
        	graphe[to].add(from);
        }
        
        if(max<from)
        {
        	max = from;
        }
        if(max < to)
        {
        	max = to;
        }
    }
	
	public int getMax() {
		return max;
	}

	public int size()
	{
		return graphe.length;
	}

	public LinkedList<Integer>[] getGraphe() {
		return graphe;
	}
	
	

}
