public abstract class Lenkeliste<T> {
    private Node foran = null;

    private class Node {
	Node neste;
	T data;
	
	Node(T data) {
	    this.data = data;
	}
    }

    public void settInn(T data) {
	Node nyNode = new Node(data);
	nyNode.neste = this.foran;
	this.foran = nyNode;
    }

    public Node fjern() {
	Node fjern = this.foran;
	this.foran = this.foran.neste;
	return fjern;
    }

    /**
     * Sjekker om listen er tom, true = tom, false = ikke tom
     * @return true/false 
     */
    public boolean erTom() {
	return foran == null;
    }
    
    /**
     * Beregner antall elementer i listen
     * @return antall
     */
    public int storrelse() {
	int antall = 0;
	Node tellerNode = this.foran;
	while(tellerNo != null) {
	    antall ++;
	    tellerNode = tellerNode.neste;
	}
	return antall;
    }
}

/*
metode: settinn
Stabel: sette inn elementet på starten av listen (A)
Kø:	sette inn elementet på slutten av listen
ordnet: ordne stigende element

metode: fjern
Stabel: skal ta ut elementet fra starten av listen (A)
Kø:	skal ta ut elementet fra starten av listen (A)
Ordnet: skal ta ut det minste elementet

metode: erTom
lik for alle sammen (A)

metode: storrelse
lik for alle sammen (A)
 */
