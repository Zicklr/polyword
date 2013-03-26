package wordgraphic;
/***
 * 
 * @author Zicklr
 *@version 2013-03-16
 */
public class GrapheOrientePondere {
	
	// liste de tous les sommets de notre graphe
    private Liste<Sommet> sommets;
    // liste de toutes les aretes de notre graphe
    private Liste<Arete> aretes;
    
    public GrapheOrientePondere(){
    	sommets =  new Liste<Sommet>();
    	aretes = new Liste<Arete>();
    }

	public Liste<Sommet> getSommets() {
		return sommets;
	}

	public void setSommets(Liste<Sommet> sommets) {
		this.sommets = sommets;
	}

	public Liste<Arete> getAretes() {
		return aretes;
	}

	public void setAretes(Liste<Arete> aretes) {
		this.aretes = aretes;
	}
	/***
	 * Méthode de lecture du fichiers et de constructions des listes L1 et L2
	 * 
	 */
	public static Liste<Sommet> loadListeMotsPolysemiques(String filename){
		Liste<Sommet> a = null;
		return a;
	}
	public static Liste<Sommet> loadListeMotsNonPolysemiques(String filename){
		Liste<Sommet> a = null;
		return a;
	}

}
