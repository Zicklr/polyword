package wordgraphic;

import java.util.List;
/***
 * Implémente un noeud ou sommet du graphe pondéré 
 * @author Zicklr
 * @version 2013-03-21
 *
 */
public class Sommet {
	
	public Sommet(String mot, ListeNode<Sommet> sommetListePrec,
			List<Arete> aretePrec, List<Arete> areteSuiv) {
		super();
		this.mot = mot;
		SommetListePrec = sommetListePrec;
		this.aretePrec = aretePrec;
		this.areteSuiv = areteSuiv;
	}

	/** Les mots sont stockés dans les sommets */
    private String mot;
    private int eval_pol;
    private int eid; 
    
    public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getEval_pol() {
		return eval_pol;
	}

	public void setEval_pol(int eval_pol) {
		this.eval_pol = eval_pol;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public ListeNode<Sommet> getSommetListePrec() {
		return SommetListePrec;
	}

	public void setSommetListePrec(ListeNode<Sommet> sommetListePrec) {
		SommetListePrec = sommetListePrec;
	}

	public List<Arete> getAretePrec() {
		return aretePrec;
	}

	public void setAretePrec(List<Arete> aretePrec) {
		this.aretePrec = aretePrec;
	}

	public List<Arete> getAreteSuiv() {
		return areteSuiv;
	}

	public void setAreteSuiv(List<Arete> areteSuiv) {
		this.areteSuiv = areteSuiv;
	}

	/** Liste des sommets precedants le sommet courant */
    private ListeNode<Sommet> SommetListePrec;
    
    /** Liste des aretes entrantes */
    private List<Arete> aretePrec;
    
    /** list of outgoing edgdes */
    private List<Arete> areteSuiv;
}
