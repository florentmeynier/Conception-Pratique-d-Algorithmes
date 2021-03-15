package algorithms.tme2.data;

public class Value {

	private final int node;
	private double degree;
	
	public Value(int node)
	{
		this(node, 0.0);
	}
	
	public Value(int node, double degree)
	{
		this.node = node;
		this.degree = degree;
	}
	
	public void setDegree(double degree)
	{
		this.degree = degree;
	}
	
	public int getNode() 
	{
		return this.node;
	}
	
	public double getDegree()
	{
		return this.degree;
	}
	
}
