package algorithms.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithms.graphs.AdjArray;

public class CreateAdjArray {

	public AdjArray create(final String parentPath, final String childPath, int nbJumps, boolean isOriented,int size) {
		Scanner sc = null;
		AdjArray g = new AdjArray(isOriented, size);
		
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
