package wordgraphic;
import java.util.Iterator;

public class Liste<V> implements Iterable<V> {
    private ListeNode<V> tete;
    private ListeNode<V> queue;
    private int t;
    public Liste()
    {
       tete = null;
       queue = null;
       t = 0;
    }
    
    /**
     * cette méthode ajoute le noeud e à la liste et retourne l'entrée de la liste qui le contient
     */
    public synchronized ListeNode<V> add(V e)
    {
        ListeNode<V> ln;

        if(tete == null) 
        {
            ln = new ListeNode<V>(e, null, null);
            tete = ln;
            queue = tete;
        }
        else
        {
            ListeNode<V> oldqueue = queue;
            ln = new ListeNode<V>(e, oldqueue, null);
            queue = ln;
            queue.setNext(ln);
        }
        t++;
        return ln;
    }


    @Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
