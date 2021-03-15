package algorithms.tme1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe de chargement d'un graphe
 */
public class NodesAndEdgesNumbers 
{
	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = {"amazon","lj","orkut","friendster"};
	
	/**
	 *
	 * @param parentPath
	 * @param childPath
	 * @return le graphe genere
	 */
	private static Graphe LoadGraphe(final String parentPath, final String childPath)
	{
		Scanner sc = null;
		Graphe g = new Graphe();
		
		try
		{
			sc = new Scanner(new File(parentPath, childPath));
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			
			while(sc.hasNextLong())
			{
				g.addEdge(sc.nextLong(),sc.nextLong());
			}
			
		}catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			sc.close();
		}
		
		return g;
		
	}
	
	public static void main (String[] args)
	{
		for(int i=0; i < files.length; i++)
		{	
			final String CHILD_PATH = PATTERN + files[i]+ ENDPATTERN + EXT;
			Graphe g  = LoadGraphe(SAMPLES_PATH, CHILD_PATH);
			System.out.println("-------------------------------");
	        System.out.println("File: " + CHILD_PATH);
	        System.out.println("Nodes count: " + g.getNbNodes());
	        System.out.println("Edge count: " + g.getNbEdges());
	        System.out.println("-------------------------------");
			
		}
	}
}
