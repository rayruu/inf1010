
public class Node<T> {
	private Node<T> neste;
	private Node<T> forrige;
	private T innhold;
	
	
	public Node(T innhold) {
		this.innhold = innhold;
	}
	
	public void settNeste(Node<T> neste) {
		this.neste = neste;
	}
	
	public void settForrige(Node<T> forrige) {
		this.forrige = forrige;
	}
	
	public Node<T> hentForrige() {
		return forrige;
	}
	
	public Node<T> hentNeste() {
		return neste;
	}
	
	public T hentInnhold() {
		return innhold;
	}
	
	public void nyttInnhold(T innhold) {
		this.innhold = innhold;
	}
	
	public void settInnMellom(Node<T> venstre, Node<T> hoyre) {
		if (venstre != null) {
			venstre.settNeste(this);
			this.settForrige(venstre); // alt: forrige = venstre;
		}
		
		if (hoyre != null) {
			hoyre.settForrige(this);
			this.settNeste(hoyre);
		}
	}
	
	public void kobleUt() {
		if (neste == null && forrige == null) {
			// eneste element
		} else if (neste == null) {
			// slutten av lista
			forrige.settNeste(null);
			forrige = null;
		} else if (forrige == null) {
			// starten av lista
			neste.settForrige(null);
			neste = null;
		} else {
			forrige.settNeste(neste);
			neste.settForrige(forrige);
			neste = null;
			forrige = null;
		}
	}
	
	public String toString() {
		return innhold.toString();
	}
	
}







