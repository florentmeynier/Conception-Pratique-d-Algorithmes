package algorithms;

public class AdjMatrix 
{
	private boolean [][] graphe;
	
	public AdjMatrix(int size) 
	{
		// TODO Auto-generated constructor stub
		
		graphe = new boolean [size][size];
	}
	
	public void addEdge(int from,int to)
	{
        graphe[from][to] = true;
    }
	
	public int size()
	{
		return graphe.length;
	}

}
