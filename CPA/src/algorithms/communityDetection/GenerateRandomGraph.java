package algorithms.communityDetection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Class de génération de graphe avec cluster
 */
public class GenerateRandomGraph {

	/**
	 * Nom du fichier de resultat
	 */
	private final String RESULTS_PATH = "Results";
	/**
	 * Reportoire du fichier de resultat
	 */
	private final String RESULTS_BENCHMARK = "benchmark";
	/**
	 * Extension du fichier de resultat
	 */
	private final String EXT = ".txt";
	
	/**
	 *
	 * @param sbBenchmark
	 * @param size
	 * @param clusterSize
	 * @param p
	 * @param q
	 * @return chaine de caractere correspondant au graphe genere
	 */
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
	
	/**
	 * Creation du graphe
	 * @param size
	 * @param clusterSize
	 * @throws IOException
	 */
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
	
	/**
	 * Entree du programme
	 * @param args
	 */
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
