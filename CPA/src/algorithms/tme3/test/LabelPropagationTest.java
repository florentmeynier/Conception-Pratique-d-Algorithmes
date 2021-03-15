package algorithms.tme3.test;

import java.io.IOException;

import algorithms.files.CreateAdjArray;
import algorithms.graphs.AdjArray;
import algorithms.tme3.LabelPropagation;

/**
 * Programme de test de l'algorithme de propagation
 */
public class LabelPropagationTest {

	private static final String SAMPLES_PATH = "Results";
	private static final String PATTERN = "benchmark_1_1";
	private static final String EXT = ".txt";
	
	public static void main(String []args)
	{
		CreateAdjArray createG = new CreateAdjArray();
		AdjArray g = createG.create(SAMPLES_PATH, PATTERN + EXT, 0, true);
		
		LabelPropagation lp = new LabelPropagation(g);
		
		lp.propagate();
		lp.afficheLabels();
		try {
			lp.exportToFile(SAMPLES_PATH, "propagate_1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
