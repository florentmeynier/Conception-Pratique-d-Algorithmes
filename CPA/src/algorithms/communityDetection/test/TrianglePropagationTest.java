package algorithms.communityDetection.test;

import java.io.IOException;

import algorithms.communityDetection.TrianglePropagation;
import algorithms.files.CreateAdjArray;
import algorithms.graphs.AdjArray;

public class TrianglePropagationTest {
	
	private static final String SAMPLES_PATH = "Results";
	private static final String PATTERN = "benchmark_1_1";
	private static final String EXT = ".txt";
	
	public static void main(String []args)
	{
		CreateAdjArray createG = new CreateAdjArray();
		AdjArray g = createG.create(SAMPLES_PATH, PATTERN + EXT, 0, false, 400);
		
		TrianglePropagation tp = new TrianglePropagation(g);
				
		tp.propagate();
		tp.afficheLabels();
		
		try {
			tp.exportToFile(SAMPLES_PATH, "propagate_2");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
