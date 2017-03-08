import java.util.Iterator;

public class StatiskTabell<T> implements Tabell<T> {
    private int lengden;
    private int antall;
    private T element;
    private T[] tabell;

    public StatiskTabell (int lengden) {
	this.lengden = lengden;
	this.antall = 0;
	tabell = (T[]) new Object[this.lengden];
    }

    public T hentFraPlass(int plass) {
	
	return this.element;
    }
   
    public void settInn(T element) {
	if (this.antall == this.lengden){
	    throw new FullTabellUntak(this.antall);
	}
	else {
	    this.tabell[antall] = element;
	    this.antall ++;
	}
    }
    
    
    public boolean erTom() {
	return lengden == 0;
    }

    public int storrelse() {
	return this.antall;
    }

    public Iterator<T> iterator() {
	return new TabellIterator();
    }
    
    private class TabellIterator implements Iterator<T> {
	private int peker;
	
	public TabellIterator() {
	    peker = 0;
	}
	
	public boolean hasNext() {
	    return tabell[peker] != null;
	}

	public T next() {
	    T temp = tabell[this.peker];
	    this.peker ++;
	    return temp;
	}
    }
} 

