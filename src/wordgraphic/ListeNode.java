package wordgraphic;

public class ListeNode<V> {
	// objet stock� dans le noeud courant
    private V element;
    
    // l'�l�ment pr�c�dent dans notre liste , null par d�faut
    private ListeNode<V> prev;
    
    // �l�ment suivant, null par d�faut
    private ListeNode<V> next;

    /**
     * Constructeur de la liste chain�e des noeuds
     */
    public ListeNode(V e, ListeNode<V> p, ListeNode<V> n)
    {
        element = e;
        prev = p;
        next = n;
    }

    /**
     * m�thode qui retourne le mot courant stock� dans la liste
     */
    public V getElement()
    {
        return element;
    }

    /**
     * m�thode qui retourne le mot pr�c�dent dans la liste
     */
    public ListeNode<V> getPrevious()
    {
        return prev;
    }

    /**
     * m�thode pour remplacer  le mot prec�dent dans la liste
     * @param ln
     */
    public void setPrevious(ListeNode<V> ln)
    {
        prev = ln;
    }

    /**
     * m�thode qui renvoie le mot suivant dans la liste
     */
    public ListeNode<V> getNext()
    {
        return next;
    }

    /**
     * m�thode pour remplacer le mot suivant dans la liste
     */
    public void setNext(ListeNode<V> ln)
    {
        next = ln;
    }

}
