import java.util.Iterator;

public class Stabel<T> extends Lenkeliste<T> implements Liste<T> {
    private int antall;

    public Stabel() {
	this.antall = 0;
    }

   public void settInn(T data) {
       super.settInnForan(data);
       antall ++;
    }

    public T fjern() {
	antall --;
	return super.fjernForan();
    }

    public boolean erTom() {
	return this.antall == 0;
    }
    
    public int storrelse() {
	return this.antall;
    }

    public Iterator<T> iterator() {
	return new ListeIterator();
    }

    public void initIterasjon () {
	super.settNesteNode();
    }

    public boolean harNeste() {
	return super.harNeste();
    }

    public T neste() {
	return super.neste();
    }
   

    private class ListeIterator implements Iterator<T> {
	// Konstruktoer
	public ListeIterator() {
	    initIterasjon();
	}
	
	public boolean hasNext() {
	    return harNeste();
	}
	
	public T next() {
	    return neste();
	}
    }
}
