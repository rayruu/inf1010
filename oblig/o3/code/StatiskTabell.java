//import java.util.Iterator;

public class StatiskTabell<T> implements Tabell<T> {
    private int lengden;
    private int antall = 0;
    private T[] tabell;

    StatiskTabell (int lengden) {
	this.lengden = lengden;
	tabell = (T[]) new Object[this.lengden];
    }
    
    /**
     * Beregner antall elementer i tabellen
     * @return      antall elementer i tabellen
     */
    public int storrelse(){
    	return this.antall;
    }

    /**
     * Sjekker om tabellen er tom
     * @return      om tabellen er tom
     */
    public boolean erTom(){
	boolean tom = true;
	if (antall != 0){
	    tom = false;
	}
	return tom;
    }

    /**
     * Setter inn et element i tabellen
     * @param   element             elementet som settes inn
     * @throws  FullTabellUnntak    hvis tabellen allerede er full
     */
    public void settInn(T element){
	if (this.antall == this.lengden) {
	    throw new FullTabellUnntak(this.antall);
	    }
	else {
	    this.tabell[antall] = element;
	    this.antall ++;
	}
    }

    /**
     * Henter (uten aa fjerne) et element fra tabellen
     * @param  plass    plassen i tabellen som det hentes fra
     * @return          elementet paa plassen
     * @throws  UgyldigPlassUnntak  hvis plassen ikke er en gyldig
                                    indeks i arrayet eller plassen
                                    ikke inneholder noe element
     */
    public T hentFraPlass(int plass){
	T element = null;
	if (plass > antall){
	    throw new UgyldigPlassUnntak(plass, this.antall);
	} else {
	    element = tabell[plass-1];
	}
	return element;
    }
} 
