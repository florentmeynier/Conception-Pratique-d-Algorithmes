package algorithms.communityDetection.test;

import java.io.IOException;

import algorithms.communityDetection.Louvain;
import algorithms.files.CreateAdjArray;
import algorithms.graphs.AdjArray;

/**
 * Programme de test de l'algorithme de Louvain
 */
public class LouvainTest {

	private static final String SAMPLES_PATH = "Results";
	private static final String PATTERN = "benchmark_1_1";
	private static final String EXT = ".txt";
	
	public static void main(String []args)
	{
		CreateAdjArray createG = new CreateAdjArray();
		AdjArray g = createG.create(SAMPLES_PATH, PATTERN + EXT, 0, true);
		
		Louvain l = new Louvain(g);
		
		l.propagate();
		try {
			l.exportToFile(SAMPLES_PATH, "propagate_louvain");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
