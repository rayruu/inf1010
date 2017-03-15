import java.util.NoSuchElementException;

public abstract class Lenkeliste<T> {
    // Paramtetre
    private Node start = null;
    private Node stopp = null;
    private Node nesteNode = null;

    private class Node {
	Node neste;
	T data;
	
	Node(T data) {
	    this.data = data;
	}
    }
    
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

    public void settInnBak(T data) {
	if (this.stopp == null) {
	    this.stopp = new Node(data);
	    this.start = this.stopp;
	}
	else {
	    Node nyNode = new Node(data);
	    this.stopp.neste = nyNode;
	    this.stopp = nyNode;
	}
    }

    public T fjernForan() {
	Node fjern = this.start;
	this.start = this.start.neste;
	return fjern.data;
    }

    public void settNesteNode() {
	this.nesteNode = this.start;
    }

    public boolean harNeste() {
	return nesteNode.neste != null;
    }

    public T neste() throws NoSuchElementException {
	if (harNeste()) {
	    T data = this.nesteNode.data;
	    this.nesteNode = nesteNode.neste;
	    return data;
	}
	else {
	    throw new NoSuchElementException();
	}
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
