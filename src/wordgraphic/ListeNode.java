package wordgraphic;

public class ListeNode<V> {
	// objet stocké dans le noeud courant
    private V element;
    
    // l'élément précédent dans notre liste , null par défaut
    private ListeNode<V> prev;
    
    // élément suivant, null par défaut
    private ListeNode<V> next;

    /**
     * Constructeur de la liste chainée des noeuds
     */
    public ListeNode(V e, ListeNode<V> p, ListeNode<V> n)
    {
        element = e;
        prev = p;
        next = n;
    }

    /**
     * méthode qui retourne le mot courant stocké dans la liste
     */
    public V getElement()
    {
        return element;
    }

    /**
     * méthode qui retourne le mot précédent dans la liste
     */
    public ListeNode<V> getPrevious()
    {
        return prev;
    }

    /**
     * méthode pour remplacer  le mot precédent dans la liste
     * @param ln
     */
    public void setPrevious(ListeNode<V> ln)
    {
        prev = ln;
    }

    /**
     * méthode qui renvoie le mot suivant dans la liste
     */
    public ListeNode<V> getNext()
    {
        return next;
    }

    /**
     * méthode pour remplacer le mot suivant dans la liste
     */
    public void setNext(ListeNode<V> ln)
    {
        next = ln;
    }

}
