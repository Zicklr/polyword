package wordgraphic;

public class Arete {
	 /** poids d'une arete */
    private int poids;

    /** sommet source */
    private Sommet origine;

    /** sommet destination */
    private Sommet destination;
    
    /** Liste des aretes entrantes du graphe */
    private ListeNode<Arete> areteListe;

    /** Liste des aretes entrantes d'origine du graphe*/
    private ListeNode<Arete> ListeEntranteSource;

    /** Liste des aretes sortantes d'origine du graphe */
    private ListeNode<Arete> ListeEntranteSortante;

    /**
     * Default Constructors
     */
    public Arete()
    {
        this(0, null, null, null, null, null);
    }

    /**
     * Full constructor
     */
	public Arete(int c, Sommet src, Sommet dest,
			 	ListeNode<Arete> ele, ListeNode<Arete> ileSource, ListeNode<Arete> ileDest)
	{
        setPoids(c);
        origine = src;
        destination = dest;
        areteListe = ele;
        ListeEntranteSource = ileSource;
        ListeEntranteSortante= ileDest;
    }



    /**
     * Return the cost of this edge
     */
    public int getPoids()
    {
        return poids;
    }

    /**
     * @pre -
     * @post If c >= 0 then the cost of the link is updated
     *       else the change is discarded
     */
    public void setPoids(int c)
    {
        if(c >= 0)
            poids = c;
    }

    /**
     * Return the source vertex for this edge
     * @return
     */
    public Sommet getSource()
    {
        return origine;
    }

    /**
     * Replace the source vertex of this edge
     */
    public void setSource(Sommet s)
    {
        origine = s;
    }

    /**
     * Return the destination vertex of this edge
     */
    public Sommet getDestination()
    {
        return destination;
    }

    /**
     * Replace the destination vertex of this edge
     */
    public void setDestination(Sommet s)
    {
        destination = s;
    }

   
    /**
     * Return the string representing this edge
     */
    public String toString()
    {
        return "Arete( source:"+origine+
               " dest:"+destination+" poids:"+poids+")";
    }

    /**
     * @Override default equals method
     */
    public boolean equals(Object o)
    {
        if(o == null || !(o instanceof Arete))
            return false;
       Arete e = (Arete)o;

        // router name are unique ... this should be enough to test equality
        return poids == e.getPoids() &&
               origine.equals(e.getSource()) &&
               destination.equals(e.getDestination());
    }

}
