package algorithms.tme1.test;

import java.util.Date;
import java.util.List;

import algorithms.files.CreateAdjArrayEdge;
import algorithms.graphs.AdjArrayEdge;
import algorithms.tme1.FindTriangles;
import algorithms.utils.Triangle;

public class FindTrianglesTest {

	private static final String SAMPLES_PATH = "Samples";
	private static final String PATTERN = "com-";
	private static final String ENDPATTERN = ".ungraph";
	private static final String EXT = ".txt";
	private static final String[] files = { "amazon" ,"lj" ,"orkut","friendster" };
	private static final int[] edges = {925872,34681189,117185083,1806067135};
	
	public static void main(String []args)
	{
		int i = 1;
		
		CreateAdjArrayEdge createG = new CreateAdjArrayEdge();
		AdjArrayEdge g = createG.create(SAMPLES_PATH, PATTERN + files[i] + ENDPATTERN + EXT, 4, false, edges[i]);
		
		FindTriangles t = new FindTriangles(g);
		
		long debut = new Date().getTime();
		List<Triangle> list = t.findTriangles();
		long fin = new Date().getTime();
		
		System.out.println("Find " + list.size() + " triangles in " + (fin - debut) + "ms");
	}
	
}
