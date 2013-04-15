package wordgraphic.bones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


/***
 * 
 * @author Zicklr
 * @version 2013-03-16
 */
public class Graphe {
	
	// liste de tous les sommets de notre graphe
	private ArrayList<Sommet> noeuds;
	private int poids_max;
	public Graphe(int size) {
		noeuds = new ArrayList<>(size);
		List<? extends Sommet> tempList = Collections.nCopies(size, new Sommet(0,"",0,0));
		noeuds.addAll(tempList);
		poids_max = 0;
	}

	public int getPoidsMax() {
		return poids_max;
	}

	public void setPoidsMax(int poids_max) {
		this.poids_max = poids_max;
	}
	
	
	
    public Graphe(){
    	noeuds =  new ArrayList<Sommet>(500000);
    	List<? extends Sommet> tmp = Collections.nCopies(500000, new Sommet(0,null,0,0));
    	noeuds.addAll(tmp);
    	
    }
	/**
	 * Créée le graphe depuis un autre graphe existant
	 * @param 	graph	Le graphe est une clone du graphe précédent
	 * @author	Zicklr
	 */
	public Graphe(Graphe g) {
		noeuds = g.noeuds;
	}
	
	/**
	 * @param	arete	
	 * @throws	NullPointerException	
	 * @author	Zicklr
	 * @see		Arete
	 */
	public void addArete(Arete t) throws NullPointerException {
		Objects.requireNonNull(t);
		t.getSource().addAdjacency(t);
	}
	
	public void addSommet(Sommet newSom) {
		if(newSom!=null)
			noeuds.set(newSom.getId(), newSom);
	}
	public List<Sommet> getSommets() {
		return noeuds;
	}
	public Sommet selectById(int id) {
		return noeuds.get(id);
	}
	public void locateNeighbour(int num){
		Sommet x = selectById(num);
		
		/****
		 * On ajoute toutes les aretes incidentes du sommet x à partir de la liste du graphe
		 */
		 Iterator<Arete> it = x.getAreteIncidentes().iterator();
		    while(it.hasNext())
		      System.out.println(it.next());
		  
		    System.out.println("\nParcours avec un tableau d'objet");
		    System.out.println("-----------------------------------");
		                 
		    Object[] obj = x.getAreteIncidentes().toArray();
		    for(Object o : obj)
		      System.out.println(o);    
		 
		
	}



}
