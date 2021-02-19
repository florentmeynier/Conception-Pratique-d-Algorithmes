package algorithms;

import java.util.LinkedList;

public class AdjArray {
	
	private LinkedList<Integer> [] graphe;
	private int max = Integer.MIN_VALUE;

	@SuppressWarnings("unchecked")
	public AdjArray(int size) 
	{
		// TODO Auto-generated constructor stub
		graphe = new LinkedList[size];
		for(int i = 0; i<size;i++)
			graphe[i] = new LinkedList<>();
	}
	
	public void addEdge(int from, int to)
	{
        graphe[from].add(to);
       // graphe[to].add(from);
        
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
