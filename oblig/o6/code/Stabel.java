/**
 * Subklasse av lenkelsite som benytter FIFO
 * @author Stein Raymond Rudshagen
 * @version 1.0 11. mars 2017
 */
import java.util.Iterator;

public class Stabel<T> extends Lenkeliste<T> implements Liste<T> {
    private int antall;

    public Stabel() {
	this.antall = 0;
    }

    /**
     * Setter inn et element i foran i listen.
     * Hvis listen er tom, settes det opp ny lenkeliste
     * @parame element
     */
   public void settInn(T data) {
       super.settInnForan(data);
       antall ++;
    }

    /**
     * Fjerner et element fra listen. Hvis listen er tom returneres null
     * @return elementet
     */
    public T fjern() {
	antall --;
	return super.fjernForan();
    }

    /**
     * Sjekker om listen er tom.
     * @preturn true/false
     */   
    public boolean erTom() {
	return this.antall == 0;
    }

    /**
     * Beregner antall elemeter i listen
     * @return antall
     */
    public int storrelse() {
	return this.antall;
    }

    /* ########## iterator ########## */

    public Iterator<T> iterator() {
	return new ListeIterator();
    }
    
    /**
     * Initialiserer iterasjonen
     */    
    public void initIterasjon () {
	super.settNesteNode();
    }

    /**
     * Sjekker om elementet er knyttet til et annet element
     * @return true/false
     */    
    public boolean harNeste() {
	return super.harNeste();
    }
    
    /**
     * Henter elementet sin data og gaar til neste element.
     * @return data
     */    
    public T neste() {
	return super.neste();
    }
         
    /**
     * Klasse for aa iterere igjennom lenkelisten
     */
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
