package algorithms.tme2.test;

import algorithms.files.CreateAdjArrayEdge;
import algorithms.graphs.AdjArrayEdge;
import algorithms.tme2.PageRank;

public class PageRankTest {

	private static final String SAMPLES_PATH = "Results";
	private static final String PATTERN = "benchmark_1_1";
	private static final String EXT = ".txt";
	
	public static void main(String []args) {
		AdjArrayEdge g = new CreateAdjArrayEdge().create(SAMPLES_PATH, PATTERN + EXT, 0, true);
		
		PageRank pr = new PageRank(g);
		
		Double []P = pr.powerIteration(0.15, 3);
	}
	
}
