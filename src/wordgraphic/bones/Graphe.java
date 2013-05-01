package wordgraphic.bones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


/***
 * A graph is a set of edge and vertex , one vertex had some link with other
 * we retrieve an arrayList  of nodes , 
 * that's it to define our relations between a vertex and almost of vertex
 * @author Zicklr
 * @version 1.0
 * @see {@link Sommet} , {@link Arete} 
 */
public class Graphe {
	
	private ArrayList<Sommet> noeuds;
	private int poids_max;
	/**
	 * Constructor  Graphe
	 * <p>We initialize our graph with a list of size copy of elements Vertex</p>
	 * @param size
	 * 		number of vertex which can be allocated  by our program  
	 */
	public Graphe(int size) {
		noeuds = new ArrayList<>(size);
		List<? extends Sommet> tempList = Collections.nCopies(size, new Sommet(0,"",0,0));
		noeuds.addAll(tempList);
		poids_max = 0;
	}
	/**
	 * It obtains high value weight we can get in our graph 
	 * @return poids_max
	 */
	public int getPoidsMax() {
		return poids_max;
	}
	/**
	 * Modify an high value weight by passed parameter value
	 * 
	 */
	public void setPoidsMax(int poids_max) {
		this.poids_max = poids_max;
	}
	
	
	/**
	 * Constructor Summary
	 * <p>Another one constructor method which initializes 500000 copies of structure Vertex
	 * for our arraylist</p>
	 */
    public Graphe(){
    	noeuds =  new ArrayList<Sommet>(500000);
    	List<? extends Sommet> tmp = Collections.nCopies(500000, new Sommet(0,null,0,0));
    	noeuds.addAll(tmp);
    	
    }
	/** 
	 * Constructor Summary<br /><br />
	 * Creates a new graph based on an old graph
	 * @param 	g	graph is similar to graph passed by parameter
	 * @author	Zicklr
	 */
	public Graphe(Graphe g) {
		noeuds = g.noeuds;
	}
	
	/**
	 * this method adds an edge to adjencied edge of both list of vertex contained
	 * @param	arete	
	 * @throws	NullPointerException	
	 * @author	Zicklr
	 * @see		Arete
	 */
	public void addArete(Arete t) throws NullPointerException {
		Objects.requireNonNull(t);
		t.getSource().addAdjacency(t);
	}
	
	/**
	 * That method adds a vertex whether our graph as an element of arraylist vertex linked inside our graph
	 * @param newSom
	 */
	public void addSommet(Sommet newSom) {
		if(newSom!=null)
			noeuds.set(newSom.getId(), newSom);
	}
	/**
	 * Retrieves our arraylist of vertex , and then we load graph  
	 * @param newSom 
	 		a vertex we want to load on that list 
	 * @return List<Sommet> of vertex passed by loading of our graph item
	 * @see {@link Sommet}
	 * @see {@link List}
	 */
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
		  
		    System.out.println("Parcours avec un tableau d'aretes incidentes du sommet");
		    System.out.println("------------------------------------------------------");
		                 
		    Object[] obj = x.getAreteIncidentes().toArray();
		    for(Object o : obj)
		      System.out.println(o);    
		 
		
	}



}
