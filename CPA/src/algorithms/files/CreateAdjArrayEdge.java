package algorithms.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algorithms.graphs.AdjArrayEdge;

/**
 * Initialisation d'un graphe Adj-Array avec le stockage de ses arretes
 */
public class CreateAdjArrayEdge {

	/**
	 * 
	 * @param parentPath
	 * @param childPath
	 * @param nbJumps
	 * @param isOriented
	 * @param size
	 * @return le graphe initialise
	 */
	public AdjArrayEdge create(final String parentPath, final String childPath, int nbJumps, boolean isOriented) {
		Scanner sc = null;
		
		List<Integer> from = new ArrayList<>();
		List<Integer> to = new ArrayList<>();
		
		int max = 0;
		
		int f, t;
		
		try {
			sc = new Scanner(new File(parentPath, childPath));
			for(int i = 0; i < nbJumps; i++)
			{
				sc.nextLine();
			}
			
			while(sc.hasNextInt())
			{
				f = sc.nextInt();
				t = sc.nextInt();
				from.add(f);
				to.add(t);
				if(f > max)
				{
					max = f;
				}
				if(t > max)
				{
					max = t;
				}
			}
			
		}catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			sc.close();
		}
		AdjArrayEdge g = new AdjArrayEdge(isOriented, max);
		
		for(int i = 0; i < from.size(); i++)
		{
			g.addEdge(from.get(i), to.get(i));
		}
		
		return g;		
	}
}
