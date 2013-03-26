package wordgraphic;

import java.util.Iterator;

public class ListeIterator<V> implements Iterator<V> {
	private ListeNode<V> tmp;

    public ListeIterator(ListeNode<V> ln)
    {
        tmp = ln;
    }

    public boolean hasNext()
    {
        return tmp != null;
    }

    public V next()
    {
    	V src = tmp.getElement();
        tmp = tmp.getNext();
        return src;
    }

    public void remove()
    {
        throw new UnsupportedOperationException("");
    }

}
