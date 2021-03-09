package algorithms.tme1.test;

import java.util.Random;

import algorithms.files.CreateAdjArray;
import algorithms.graphs.AdjArray;
import algorithms.tme1.BFS;

/**
 * Programme de test de l'algorithme BFS
 */
public class BFSTest {

	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = { "amazon","lj" /*,"orkut","friendster"*/ };
	private static final int[] edges = {925872,34681189,117185083,1806067135};
	
	public static void main(String args[]) 
	{
		CreateAdjArray createG = new CreateAdjArray();
		for(int i = 0; i < files.length; i++)
		{
			final String CHILD_PATH = PATTERN + files[i] + ENDPATTERN + EXT;
			AdjArray g = createG.create(SAMPLES_PATH, CHILD_PATH, 4, false);
			BFS bfs = new BFS(g);
			int s = 0;
			do
			{
				s = new Random().nextInt(g.getMax() + 1);
			} while(g.getGraphe()[s] == null);
			
			System.out.println("-------------------------------");
	        System.out.println("File: " + CHILD_PATH);
	        System.out.println("g1: " + g.size());
	        long startTime = System.nanoTime();
	        for(int j=0;j<10;j++)
	        {
	        	s = bfs.execute(s);
	        }
	        long endTime = System.nanoTime();
	        long duration = (endTime - startTime)/1000000; 
	        long reste = (endTime - startTime)%1000000;
	        System.out.println("time elapsed " + duration + " ms "+ reste + " ns");
	        System.out.println("-------------------------------");
		}
	}
	
}
