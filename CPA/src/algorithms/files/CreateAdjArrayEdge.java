package algorithms.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithms.graphs.AdjArrayEdge;

public class CreateAdjArrayEdge {

	public AdjArrayEdge create(final String parentPath, final String childPath, int nbJumps, boolean isOriented,int size) {
		Scanner sc = null;
		AdjArrayEdge g = new AdjArrayEdge(isOriented, size);
		
		try {
			sc = new Scanner(new File(parentPath, childPath));
			for(int i = 0; i < nbJumps; i++)
			{
				sc.nextLine();
			}
			
			while(sc.hasNextInt())
			{
				g.addEdge(sc.nextInt(),sc.nextInt());
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
}