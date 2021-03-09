package algorithms.utils;

/**
 * Stockage d'un triangle
 */
public class Triangle {

	/**
	 * Sommet numero 1 
	 */
	private int n1;
	/**
	 * Sommet numero 2
	 */
	private int n2;
	/**
	 * Sommet numero 3
	 */
	private int n3;
	
	public Triangle(int n1, int n2, int n3)
	{
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}
	
	/**
	 * 
	 * @return le sommet numero 1
	 */
	public int getN1() 
	{
		return n1;
	}
	
	/**
	 * 
	 * @return le sommet numero 2
	 */
	public int getN2() 
	{
		return n2;
	}
	
	/**
	 * 
	 * @return le sommet numero 3
	 */
	public int getN3() 
	{
		return n3;
	}
	
}
