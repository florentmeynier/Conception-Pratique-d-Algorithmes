package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BFS 
{
	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = {"amazon","lj","orkut","friendster"};
	private static final int[] edges = {925872,34681189,117185083,1806067135};
	
	public static int algoBFS(int s, int nodes, AdjArray g) 
	{

		boolean visited[] = new boolean[nodes];
		int distances [] = new int[nodes];
		Arrays.fill(distances, 0);
		
		int d = 0;

		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			if(d==0 || queue.isEmpty())
				System.out.print(s + " ");
			
			Iterator<Integer> i = (g.getGraphe())[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					distances[n] = distances[s]+1;
					queue.add(n);
				}
				d=s;
			} 
		}
		System.out.println();
		System.out.println(distances[d]);
		return d;
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
			do
			{
				s = new Random().nextInt(g1.getMax()+1);
				
			}while(g1.getGraphe()[s] == null);
			
			System.out.println("-------------------------------");
	        System.out.println("File: " + CHILD_PATH);
	        System.out.println("g1: " + g1.size());
	        long startTime = System.nanoTime();
	        for(int j=0;j<10;j++)
	        {
	        	s = algoBFS(s,g1.getMax()+1,g1);
	        }
	        long endTime = System.nanoTime();
	        long duration = (endTime - startTime)/1000000; 
	        long reste = (endTime - startTime)%1000000;
	        System.out.println("time elapsed " + duration + " ms "+ reste + " ns");
	        System.out.println("-------------------------------");
			
		}
	}
}
