import java.util.NoSuchElementException;


/**
 * Lenkeliste som lenker sammen data ved hjelp av noder
 * Tre variasjoner av lenkelister er mulig:
 * - Ordnet lenkeliste
 * - LIFO lenkeliste
 * - FIFO lenleliste
 */
public abstract class Lenkeliste<T> {
    private Node start   = null;
    private Node stopp   = null;
    private Node neste   = null;
    private Node forrige = null;
    
    /**
     * Privat klasse som brukes til aa holde styr paa lenkelisten
     */
    private class Node {
	Node neste;
	T data;
	
	Node(T data) {
	    this.data = data;
	}
    }

    /*
      ############ Sett inn metoder ################
     */
    
    /**
     * Setter inn ny node med data foran start - noden hvis start node eksisterer.
     * ellers setter den opp ny start node.
     *
     * @input data knytter data opp mot noden.
     */
    public void settInnForan(T data) {
	if (this.start == null) {
	    this.start = new Node(data);
	    this.stopp = this.start;
	}
	
	else {
	    Node nyNode = new Node(data);
	    nyNode.neste = this.start;
	    this.start = nyNode;
	}
    }

    /**
     * Setter inn ny node med data bak stopp - noden, hvis stopp node eksisterer.
     * ellers setter den oppny start node.
     *
     * @input data knytter data opp mot noden.
     */
    public void settInnBak(T data) {
	if (this.start == null) {
	    this.start = new Node(data);
	    this.stopp = this.start;
	}
	else {
	    Node nyNode = new Node(data);
	    this.stopp.neste = nyNode;
	    this.stopp = nyNode;
	}
    }
    
    /**
     * Setter inn ny node mellom neste node og forrige node.
     *
     * @input data knytter data opp mot noden.
     */
    public void settInnMellom(T data) {
	Node nyNode = new Node(data);
	nyNode.neste = neste;
	forrige.neste = nyNode;
    }

    /*
      ############ fjern metoder ########################
    */

    /**
     * Fjerner foerste node i lenkelisten. Returnerer data for feedback
     * Feedback kan brukes til for eksempel aa teste at lenkelisten blir riktig implementert
     *
     * @return data noden som fjernes sin data.
     */
    public T fjernForan() {
	Node fjern = this.start;
	this.start = this.start.neste;
	return fjern.data;
    }

    /*
      ############ Metoder til OrdnetLenkeliste  #########
    */

    /**
     * Henter neste node sin data.
     *
     * @return data 
     */
    public T hentData() {
	return this.neste.data;
    }

    /**
     * Sjekker om forrige node brukes.
     * false = forrige node er tom
     * true = forrige node ligger etter neste node.
     *
     * @return true/false
     */
    public boolean harForrige() {
	return this.forrige != null;
    }

    /*
      ############ Metoder til Iterasjon  #################
    */

    /**
     * Setter neste node naar den blir kalt paa.
     *
     */
    public void settNesteNode() {
	this.forrige = null;
	this.neste = this.start;
    }
    
    /**
     * Sjekker om det eksisterer en neste node.
     * false = er ved slutten av lenkelisten.
     * true = det eksisterern en neste node.
     *
     * @return true/false
     */
    public boolean harNeste() {
	return this.neste != null;
    }
    
    /**
     * Setter neste node til forrige node og setter neste sin neste til neste node.
     *
     * @return data returnerer neste sin data foer den gaar til neste sin neste node.
     */
    public T neste() throws NoSuchElementException {
	T data = this.neste.data;
	this.forrige = this.neste;
	this.neste = this.neste.neste;
	return data;
    }
}

