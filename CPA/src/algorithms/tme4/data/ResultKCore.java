package algorithms.tme4.data;

import java.util.List;

/**
 * Class de resultat de l'algorithme core decomposition
 */
public class ResultKCore {

	/**
	 * Degres max du graphe
	 */
	private int dMax;
	/**
	 * Liste des cores correspondant à chaque noeud
	 */
	private List<Integer> cores;
	/**
	 * Core moyen detecte
	 */
	private int core;
	/*
	 * Degres moyen du graphe
	 */
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

	/**
	 * 
	 * @return le degres max
	 */
	public int getDMax() {
		return dMax;
	}

	/**
	 * 
	 * @return la liste des cores correspondant a chaque noeud
	 */
	public List<Integer> getCores() {
		return cores;
	}

	/**
	 * 
	 * @return le core moyen du graphe
	 */
	public int getCore() {
		return core;
	}
	
	/**
	 * 
	 * @return le degres moyen du graphe
	 */
	public int getAvD() {
		return avD;
	}
	
}
