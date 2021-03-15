package algorithms.tme4.test;

import java.io.IOException;

import algorithms.files.CreateAdjArray;
import algorithms.graphs.AdjArray;
import algorithms.tme4.KCoreDecomposition;
import algorithms.tme4.data.ResultKCore;

public class KCoreDecompositionTest {
	
	public static void main(String args[]) 
	{
		CreateAdjArray createG = new CreateAdjArray();		
		
		AdjArray g = createG.create("Samples", "net.txt", 0, true);
		KCoreDecomposition kcore = new KCoreDecomposition(g);
		
		ResultKCore c = kcore.decompose();
		try {
			kcore.exportToFile("Results", "kcore_1", c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fichier net.txt : ");
		System.out.println("c : " + c.getCore());
		System.out.println("Average degree density : " + c.getAvD());
		System.out.println("Edge density : " + (334863 / (g.getNbEdges() * 1.0)));
		
		g = createG.create("Samples", "com-amazon.ungraph.txt", 4, false);
		kcore = new KCoreDecomposition(g);
		
		c = kcore.decompose();
		try {
			kcore.exportToFile("Results", "kcore_2", c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fichier amazon : ");
		System.out.println("c : " + c.getCore());
		System.out.println("Average degree density : " + c.getAvD());
		System.out.println("Edge density : " + (334863 / (g.getNbEdges() * 1.0)));
	}
}
