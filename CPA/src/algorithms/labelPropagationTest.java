package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class labelPropagationTest 
{

	
	private static final String SAMPLES_PATH = "Results";
	private static final String PATTERN = "benchmark_1_1";
	private static final String EXT = ".txt";
	
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
		// TODO Auto-generated method stub
		
		LabelPropagation lp = new LabelPropagation();
		
		AdjArray g = LoadGrapheArray(SAMPLES_PATH,PATTERN+EXT,400);
		
		lp.labelPropa(g);
		lp.afficheLabels();

	}

}
