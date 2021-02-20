package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Triangles 
{
	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = {"amazon","lj","orkut","friendster"};
	private static final int[] edges = {925872,34681189,117185083,1806067135};
	
	public static int NBtriangles(AdjArray g) 
	{
		int nbt=0;
		
		for(int i=0; i<g.getGraphe().length;i++)
		{
			if(g.getGraphe()[i]==null)
				break;
			int u = i;
			for(int j=0; j<g.getGraphe()[u].size();j++)
			{
				int v = g.getGraphe()[u].get(j);
				if(v <= u)
					continue;
				for(int k=0;k<g.getGraphe()[v].size();k++)
				{
					int w = g.getGraphe()[v].get(k);
					if(w <= v)
						continue;
					for(int h = 0;h<g.getGraphe()[w].size();h++)
					{
						if(u==g.getGraphe()[w].get(h))
						{
							nbt++;
							break;
						}
					}
					
				}
			}
		}
		
		return nbt;
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
	
	public static void main(String args[]) {
		for(int i=0; i < files.length; i++)
		{	
			final String CHILD_PATH = PATTERN + files[i]+ ENDPATTERN + EXT;
			AdjArray g1 = LoadGrapheArray(SAMPLES_PATH, CHILD_PATH, edges[i]);
			int s = 0;
			System.out.println("-------------------------------");
	        System.out.println("File: " + CHILD_PATH);
	        System.out.println("g1: " + g1.size());
	        long startTime = System.nanoTime();
	        s = NBtriangles(g1);
	        System.out.println("Nb triangles : " + s);
	        long endTime = System.nanoTime();
	        long duration = (endTime - startTime)/1000000; 
	        long reste = (endTime - startTime)%1000000;
	        System.out.println("time elapsed " + duration + " ms "+ reste + " ns");
	        System.out.println("-------------------------------");
			
		}
	}
}

