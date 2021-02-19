package algorithms.communityDetection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomGraph {

	private final String RESULTS_PATH = "Results";
	private final String RESULTS_BENCHMARK = "benchmark";
	private final String EXT = ".txt";
	
	private StringBuilder benchmark(StringBuilder sbBenchmark, final int size, final int clusterSize, double p, double q) 
	{
		double proba;
		
		for(int i = 1; i < size; i++)
		{
			for(int j = i + 1; j <= size; j++)
			{
				if(i / clusterSize == j / clusterSize)
				{
					proba = p;
				}else
				{
					proba = q;
				}
				if((new Random()).nextDouble() < proba)
				{
					sbBenchmark.append(Integer.toString(i)+"\t"+Integer.toString(j)+"\n");
				}
				
			}
		}
		return sbBenchmark;
	}
	
	public void makeBenchmark(final int size, final int clusterSize) throws IOException
	{
		File resultBenchmark = new File(RESULTS_PATH , RESULTS_BENCHMARK + "_" + 1 + "_" + 1+EXT);
		BufferedWriter benchWriter = new BufferedWriter(new FileWriter(resultBenchmark));
		StringBuilder sbBenchmark =  new StringBuilder();
		double p = 0.2;
		double q = 0.001;
		sbBenchmark = benchmark(sbBenchmark, size, clusterSize, p, q);
		benchWriter.write(sbBenchmark.toString());
		benchWriter.close();
	}
	
	public static void main(String[] args) 
	{		
		GenerateRandomGraph sb = new GenerateRandomGraph();
		
		try {
			sb.makeBenchmark(400, 100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("done.");

	}
	
}
