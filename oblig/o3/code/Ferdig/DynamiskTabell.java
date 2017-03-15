import java.util.Iterator;

public class DynamiskTabell<T> extends StatiskTabell<T> {
    private T[] utvidTabell;
    private int teller;
    
    public DynamiskTabell (int lengden) {
	super(lengden);
    }

    public DynamiskTabell() {
	super(100);
    }

    /**
     * Setter inn ett element i tabellen
     * @param   element             elementet som settes inn
     * @throws  FullTabellUnntak    hvis tabellen allerede er full
     */
    @Override
    public void settInn(T element) {
	if (this.antall == this.lengden){
	    utvidTabell();

	    this.tabell[antall] = element;
	    this.antall ++;
	} 
	else {
	    this.tabell[antall] = element;
	    this.antall ++;
	}
    }

    /**
     * Henter ett element fra tabellen
     * @param  plass    plassen i tabellen som det hentes fra
     * @return element  elementet paa plassen
     * @throws  UgyldigPlassUnntak  hvis plassen ikke er en gyldig
                                    indeks i arrayet eller plassen
                                    ikke inneholder noe element
     */
    @Override
    public T hentFraPlass(int plass) {
	if ((plass > this.antall) || (plass < 0) || (erTom()) || (plass > (this.lengden-1))){
	    throw new UgyldigPlassUnntak(plass, this.antall);
	} 
	else {
	    this.element = tabell[plass];
	}
	return this.element;
    }

    /**
     * Utvider tabellen hvis antallet i tabellen blir lik tabellens lengde.
     */
    public void utvidTabell() {
	this.lengden = this.lengden + 100;
	this.utvidTabell = (T[]) new Object[this.lengden];

	teller = 0;
	for(T element : this.tabell) {
	    this.utvidTabell[teller] = element;
	    teller ++;
	}

	this.tabell = this.utvidTabell;
    }	
}
