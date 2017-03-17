import java.util.Iterator;

/**
 * Lager lenkeliste som er stoerrelsesorden der forste elementet er minst og siste er stoerst.
 */
public class OrdnetLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> implements Liste<T> {
    private int antall;

    public OrdnetLenkeliste() {
	this.antall = 0;
    }

    /**
     * Setter inn et element i listen.
     * Ved hjelp av compareTo bestemmer om elementet
     * skal fora, mellom eller bak andre elementer.
     * Hvi listen er tom, sett opp ny lenkeliste.3
     * @param   element
     */
   public void settInn(T data) {
       
       System.out.println("data " + data);
       if (erTom()) {
	   settInnForan(data);
	   System.out.println("Setter inn i tom liste");
       }
       else if((erTom() != true)) {
	   //initIterasjon();
	   boolean settInn = true;
	   
	   for (T node : this) {
	       System.out.println("settinn " + settInn);
	       System.out.println(data.compareTo(node));
   
	       if ((data.compareTo(node) < 0) && (settInn == true)) {
		   
		   System.out.println(" sjekker ved start: " + vedStart());
		   if (vedStart() == true) {
		       System.out.println("Setter inn foran");
		       settInnForan(data);
		       settInn = false;
		   }
		   else {
		       System.out.println("Setter inn mellom");
		       settInnMellom(data);
		       settInn = false;
		   }

	       }
	       else if ((data.compareTo(node) > 0) && (settInn == true) && (harNeste() == false)) {
		   System.out.println("Setter inn bak");
		   settInnBak(data);
		   settInn = false;
	       }   
	   }
       }
       
       this.antall ++;
   }
		   
    /*	   			   if (harForrige() == false) {	   }
		   else {
		       settInnMellom(data);
		       System.out.println("Setter inn mellom");
		   }
		   settInn = false;
	   
	   while ((harNeste() == true) && (settInn == true)) {
	       System.out.println(data.compareTo(hentData()));
	       
	       if (data.compareTo(hentData()) <= 0) {
		   
		   if (harForrige() == false) {
		       System.out.println("Setter in foran");
		       settInnForan(data);
		   }
		   else {
		       settInnMellom(data);
		       System.out.println("Setterin mellom");
		       System.out.println(data);
		   }

		   settInn = false;
		   
	       }
	       else if (harNeste() != true) {
		   settInnBak(data);
		   System.out.println("Setter in bak");
		   settInn = false;
		   
	       }
	       
	       neste();
	   }
	   } */

    /**
     * Fjerner et element fra listen. Hvis listen er tom,
     * returneres null.
     * @return elementet
     */
    public T fjern() {
	antall --;
	return super.fjernForan();
    }
    
    /**
     * Sjekker om listen er tom
     * @return true/false
     */
    public boolean erTom() {
	return this.antall == 0;
    }

    /**
     * Beregner antall elementer i listen
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
