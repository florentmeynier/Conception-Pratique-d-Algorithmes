package algorithms.communityDetection.test;

import java.io.IOException;

import algorithms.communityDetection.TrianglePropagation;
import algorithms.files.CreateAdjArrayEdge;
import algorithms.graphs.AdjArrayEdge;

/**
 * Programme de test de la propagation sur triangles
 */
public class TrianglePropagationTest {
	
	private static final String SAMPLES_PATH = "Results";
	private static final String PATTERN = "benchmark_1_1";
	private static final String EXT = ".txt";
	
	public static void main(String []args)
	{
		CreateAdjArrayEdge createG = new CreateAdjArrayEdge();
		AdjArrayEdge g = createG.create(SAMPLES_PATH, PATTERN + EXT, 0, false);
		
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
