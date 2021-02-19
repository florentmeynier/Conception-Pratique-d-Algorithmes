package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StructuresTest 
{
	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = {"amazon","lj","orkut","friendster"};
	private static final int[] sizes = {925872,34681189,117185083,1806067135};
	
	private static ListOfEdges LoadGrapheList(final String parentPath, final String childPath)
	{
		Scanner sc = null;
		ListOfEdges g = new ListOfEdges();
		
		try
		{
			sc = new Scanner(new File(parentPath, childPath));
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			
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
	
	private static AdjMatrix LoadGrapheMatrix(final String parentPath, final String childPath, int size)
	{
		Scanner sc = null;
		AdjMatrix g = new AdjMatrix(size);
		
		try
		{
			sc = new Scanner(new File(parentPath, childPath));
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			
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
	
	private static AdjArray LoadGrapheArray(final String parentPath, final String childPath, int size)
	{
		Scanner sc = null;
		AdjArray g = new AdjArray(size);
		
		try
		{
			sc = new Scanner(new File(parentPath, childPath));
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			
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
	
	public static void main(String[] args) 
	{
		for(int i=0; i < files.length; i++)
		{	
			final String CHILD_PATH = PATTERN + files[i]+ ENDPATTERN + EXT;
			ListOfEdges g1 = LoadGrapheList(SAMPLES_PATH, CHILD_PATH);
			//AdjMatrix g2 = LoadGrapheMatrix(SAMPLES_PATH, CHILD_PATH, sizes[i]);
			AdjArray g3 = LoadGrapheArray(SAMPLES_PATH, CHILD_PATH, sizes[i]);
			System.out.println("-------------------------------");
	        System.out.println("File: " + CHILD_PATH);
	        System.out.println("g1: " + g1.size());
	       // System.out.println("g2: " + g2.size());
	        System.out.println("g3: " + g3.getGraphe()[1]);
	        System.out.println("-------------------------------");
			
		}
		

	}

}
