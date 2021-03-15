package algorithms.tme2;

import java.util.ArrayList;
import java.util.List;

import algorithms.graphs.AdjArrayEdge;
import algorithms.graphs.Edge;
import algorithms.tme2.data.Value;

public class PageRank {
	
	private AdjArrayEdge graph;
	private final int nbNodes;
	
	public PageRank(AdjArrayEdge graph) {
		this.graph = graph;
		int cpt = 0;
		for(int i = 0; i < graph.size(); i++)
		{
			if(!graph.getGraphe()[i].isEmpty())
			{
				cpt++;
			}
		}
		nbNodes = cpt;
	}
	
	public Double[] powerIteration(double alpha, int t) 
	{
		int []entry = new int[graph.size()];
		List<Value> []matrix = transition();
		Double P[] = new Double[graph.size()];
		
		double unN = 1.0 / nbNodes;
		for(int i = 0; i < graph.size(); i++)
		{
			entry[i] = getNbEntry(i);
			//P[i] = unN * entry[i];
			P[i] = unN;
		}
		display(P);
		for(int i = 0; i < t; i++)
		{
			P = matVectProd(matrix, P);
			display(P);
			double norme = 0.0;
			for(int p = 0; p < P.length; p++)
			{
				//P[p] = (1 - alpha) * P[p] + alpha * entry[p];
				P[p] = (1 - alpha) * P[p] + alpha * unN;
				norme += (P[p] * P[p]);
			}
			norme = Math.sqrt(norme);
			//display(P);
			System.out.println("norme " + norme);
			for(int p = 0; p < P.length; p++)
			{
				P[p] += ((1 - norme) / nbNodes);
			}
			display(P);
			System.out.println("\n-----------------------\n");
		}
		return P;
	}

	private Double[] matVectProd(List<Value>[] matrix, Double[] A)
	{
		Double []B = new Double[A.length];
		for(int i = 0; i < B.length; i++)
		{
			B[i] = 0.0;
		}
		for(Edge e : graph.getEdges())
		{
			Value v = getValueFromMatrix(matrix, e.getFrom(), e.getTo());
			if(v == null)
			{
				continue;
			}
			B[e.getFrom()] += v.getDegree() * A[e.getTo()];
		}
		return B;
	}
	
	@SuppressWarnings("unchecked")
	private List<Value>[] transition()
	{
		List<Value> []matrix = new ArrayList[graph.size() + 1];
		for(int i = 0; i < graph.size() + 1; i++)
		{
			matrix[i] = new ArrayList<Value>();
		}
		for(Edge e : graph.getEdges())
		{
			matrix[e.getFrom()].add(new Value(e.getTo(), graph.getGraphe()[e.getTo()].size()));
		}
		return matrix;
	}
	
	private int getNbEntry(int node) 
	{
		int nbEntry = 0;
		for(int i = 0; i < graph.size(); i++)
		{
			for(int j = 0; j < graph.getGraphe()[i].size(); j++)
			{
				if(node == graph.getGraphe()[i].get(j))
				{
					nbEntry++;
				}
			}
		}
		return nbEntry;
	}
	
	private Value getValueFromMatrix(List<Value>[] matrix, int i, int j)
	{
		for(int to = 0; to < matrix[i].size(); to++)
		{
			if(matrix[i].get(to).getNode() == j)
			{
				return matrix[i].get(to);
			}
		}
		return null;
	}
	
	private void display(Double[] P) 
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				System.out.print(P[(i * 100) + j] + "\t");
			}
			System.out.println();
		}
		System.out.println("");
	}
	
}
