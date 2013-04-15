package wordgraphic.bones;
import java.util.HashSet;

/***
 * Impl�mente un noeud ou sommet du graphe pond�r� 
 * @author Zicklr
 * @version 2013-03-21
 *
 */
public class Sommet {
	/** Les mots sont stock�s dans les sommets */
    private final String mot;
    private final int poids;
    private final int id; 
    private final int numtype;
    private HashSet<Arete> areteIncidentes;
	
    public Sommet(int id,String mot,int numtype, int poids) {
		super();
		this.mot = mot;
		this.poids = poids;
		this.id = id;
		this.numtype = numtype;
		areteIncidentes = new HashSet<>(50);;

	}


	public int getId() {
		return id;
	}

	public HashSet<Arete> getAreteIncidentes() {
		return areteIncidentes;
	}

	public void setAreteIncidentes(HashSet<Arete> areteIncidentes) {
		this.areteIncidentes = areteIncidentes;
	}
	public void addAdjacency(Arete q) {
		if(q.getSource().equals(this)||q.getDestination().equals(this)){
			areteIncidentes.add(q);
		}
	}
	public String getMot() {
		return mot;
	}

	public int getPoids() {
		return poids;
	}

	public int getNumtype() {
		return numtype;
	}

	void addAreteIncidente(Arete a1) {
		 areteIncidentes.add(a1);
	}
	/**
	 * V�rifie l'�galit� de deux sommets
	 * @see id
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Sommet s = (Sommet) obj;
		return (id == s.id);
	}


}
