
import java.util.Iterator;

public class Stabel<T> extends Lenkeliste<T> implements Liste<T> {


   public void settInn(T data) {
       super.settInn(data);
    }

    public T fjern() {
	return super.fjern();
    }

    /**
     * Sjekker om listen er tom, true = tom, false = ikke tom
     * @return true/false 
     */
    public boolean erTom() {
	return super.erTom();
    }
    
    /**
     * Beregner antall elementer i listen
     * @return antall
     */
    public int storrelse() {
	return super.storrelse();
    }

   /**
     * returnerer type T element ved aa iterere.
     * @return T-element
     */
    public Iterator<T> iterator() {
	return new ListelIterator();
    }
    
    /**
     * Privat klasse som itererer over tabell av type T
     */
    private class ListeIterator implements Iterator<T> {
	// Parametre
	private int peker;
	
	// Konstruktoer
	public ListeIterator() {
	    this.peker = 0;
	}
	
	/**
	 * Returnerer true hvis det eksisterer flere elementer
	 * @return true/false
	 */
	public boolean hasNext() {
	    return this.p < antall;
	}
	
	/**
	 * Returnerer neste elementet i tabellen
	 * @return neste
	 */
	public T next() {
	    T neste = tabell[this.peker];
	    this.peker ++;
	    return neste;
	}
    }
}
