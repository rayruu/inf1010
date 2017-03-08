import java.util.Iterator;

/**
 * Statisk tabell med array som underliggende datastruktur
 * @param lengden lengden paa arrayet
 */
public class StatiskTabell<T> implements Tabell<T> {
    // Parametre
    private int lengden;
    private int antall;
    private T element;
    private T[] tabell;
    
    // konstruktoer
    public StatiskTabell (int lengden) {
	this.lengden = lengden;
	this.antall = 0;
	tabell = (T[]) new Object[this.lengden];
    }
    
    /**
     * Henter ett element fra tabellen
     * @param  plass    plassen i tabellen som det hentes fra
     * @return element  elementet paa plassen
     * @throws  UgyldigPlassUnntak  hvis plassen ikke er en gyldig
                                    indeks i arrayet eller plassen
                                    ikke inneholder noe element
     */
    public T hentFraPlass(int plass) {
	if ((plass > antall) || (plass < 0)){
	    throw new UgyldigPlassUnntak(plass, this.antall);
	} 
	else {
	    this.element = tabell[plass];
	}
	return this.element;
    }
   
    /**
     * Setter inn ett element i tabellen
     * @param   element             elementet som settes inn
     * @throws  FullTabellUnntak    hvis tabellen allerede er full
     */
    public void settInn(T element) {
	if (this.antall == this.lengden){
	    throw new FullTabellUnntak(this.antall);
	} 
	else {
	    this.tabell[antall] = element;
	    this.antall ++;
	}
    }
    
    /**
     * Sjekker om tabellen er tom, true = tom, false = ikke tom
     * @return true/false 
     */
    public boolean erTom() {
	return antall == 0;
    }
    
    /**
     * Beregner antall elementer i tabellen
     * @return antall
     */
    public int storrelse() {
	return this.antall;
    }
    
    /**
     * returnerer type T element ved aa iterere.
     * @return T-element
     */
    public Iterator<T> iterator() {
	return new TabellIterator();
    }
    
    /**
     * Privat klasse som itererer over tabell av type T
     */
    private class TabellIterator implements Iterator<T> {
	// Parametre
	private int peker;
	
	// Konstruktoer
	public TabellIterator() {
	    this.peker = 0;
	}
	
	/**
	 * Returnerer true hvis det eksisterer flere elementer
	 * @return true/false
	 */
	public boolean hasNext() {
	    return this.peker < antall;
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

