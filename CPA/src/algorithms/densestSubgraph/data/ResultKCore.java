package algorithms.densestSubgraph.data;

import java.util.List;

public class ResultKCore {

	private int dMax;
	private List<Integer> cores;
	private int core;
	private int avD;

	public ResultKCore(int dMax, List<Integer> cores, int avD) {
		this.dMax = dMax;
		this.cores = cores;
		int somme = 0;
		int cpt = 0;
		for(int z = 0; z < cores.size(); z++)
		{
			if(cores.get(z) > 0)  
			{
				somme += cores.get(z);
				cpt++;
			}
		}
		core = (int) Math.ceil(somme / (cpt * 1.0));
		this.avD = avD;
	}

	public int getDMax() {
		return dMax;
	}

	public List<Integer> getCores() {
		return cores;
	}

	public int getCore() {
		return core;
	}
	
	public int getAvD() {
		return avD;
	}
	
}
