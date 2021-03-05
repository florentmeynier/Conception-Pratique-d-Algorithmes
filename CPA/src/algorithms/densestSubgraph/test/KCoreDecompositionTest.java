package algorithms.densestSubgraph.test;

import java.io.IOException;

import algorithms.densestSubgraph.KCoreDecomposition;
import algorithms.densestSubgraph.data.ResultKCore;
import algorithms.files.CreateAdjArray;
import algorithms.graphs.AdjArray;

public class KCoreDecompositionTest {

	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = { "amazon","lj" /*,"orkut","friendster"*/ };
	private static final int[] edges = {925872,34681189,117185083,1806067135};
	
	public static void main(String args[]) 
	{
		CreateAdjArray createG = new CreateAdjArray();
		/*for(int i = 0; i < files.length; i++)
		{
			final String CHILD_PATH = PATTERN + files[i] + ENDPATTERN + EXT;
			AdjArray g = createG.create(SAMPLES_PATH, CHILD_PATH, 4, false, edges[i]);
			AdjArray g = createG.create("Results", "benchmark_1_1.txt", 0, false, 4052);
			KCoreDecomposition kcore = new KCoreDecomposition(g);
	        long startTime = System.nanoTime();
	        System.out.println(kcore.decompose());
	        long endTime = System.nanoTime();
	        long duration = (endTime - startTime)/1000000; 
	        long reste = (endTime - startTime)%1000000;
	        System.out.println("time elapsed " + duration + " ms "+ reste + " ns");
	        System.out.println("-------------------------------");
		}*/
		
		/*AdjArray g = createG.create("Results", "benchmark_1_1.txt", 0, false, 4052);
		KCoreDecomposition kcore = new KCoreDecomposition(g);
		System.out.println(kcore.decompose());*/
		
		//AdjArray g = createG.create("Samples", "net.txt", 0, true);
		AdjArray g = createG.create("Samples", "com-lj.ungraph.txt", 4, false);
		System.out.println("START");
		KCoreDecomposition kcore = new KCoreDecomposition(g);
		
		ResultKCore c = kcore.decompose();
		/*try {
			kcore.exportToFile("Results", "kcore_1", c);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("c : " + c.getCore());
		System.out.println("Average degree density : " + c.getAvD());
		System.out.println("Edge density : " + (g.getNbEdges() / c.getDMax()));
	}
}
