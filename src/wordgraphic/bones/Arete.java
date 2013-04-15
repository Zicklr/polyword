package wordgraphic.bones;

public class Arete {
	private final int id;
    private final Sommet origineId;
    private final Sommet destinationId;
    private final int type;
    private final Double poids;

   
    
    /**
     * Full constructor
     */

    public Arete(int id, Sommet origineId,Sommet destinationId,int type, Double poids) {
    	this.id = id;
    	this.origineId = origineId;
		this.destinationId = destinationId;
		this.type = type;
		this.poids = poids;
	}



	/**
     * Return the cost of this edge
     */
    public Double getPoids()
    {
        return poids;
    }

    /**
     * Return the source vertex for this edge
     * @return
     */
    public Sommet getSource()
    {
        return origineId;
    }


    /**
     * Return the destination vertex of this edge
     */
    public Sommet getDestination()
    {
        return destinationId;
    }
    /**
     * Return the string representing this edge
     */
    public String toString()
    {
        return "Arete( source:"+origineId+
               " dest:"+destinationId+" poids:"+poids+")";
    }

    /**
     * @Override default equals method
     */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Arete o = (Arete) obj;
		return (id == o.id);
	}

	public int getId() {
		return id;
	}



	public int getType() {
		return type;
	}

}
