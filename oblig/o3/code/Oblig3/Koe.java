import java.util.Iterator;

public class Koe<T> implements Liste<T> {
  private Node<T> hode;
  private Node<T> hale;
  private int lengde;

  public Koe() {
    lengde = 0;
  }

  //Sjekker storrelsen på arrayet
  public int storrelse(){
    return lengde;
  }

  //Sjekker om listen er tom
  public boolean erTom(){
    return lengde == 0;
  }

  //Sett inn i slutten av listen
  public void settInn(T element){
    if(erTom()){
      hode = new Node<T>(element);
      hale = hode;
    } else{
      Node<T> temp = new Node<T>(element);
      hale.settNeste(temp);
      hale = temp;

    }
    lengde++;
  }

  //Fjerner et element fra starten av listen
  public T fjern(){
    T ut = hode.hentInnhold();
    hode = hode.hentNeste();
    lengde--;
    return ut;
  }


  public Iterator<T> iterator() {
    return new KoeIterator();
  }

  private class KoeIterator implements Iterator<T> {
    private Node<T> nesteElement;
    private Node<T> sistReturnert;
    private int peker;


    public KoeIterator() {
      nesteElement = hode;
      peker = 0;
    }

    public boolean hasNext() {
      return nesteElement != null;
    }

    public T next() {
			if (hasNext()) {
				T temp = nesteElement.hentInnhold();
				sistReturnert = nesteElement;
				nesteElement = nesteElement.hentNeste();
				peker++;
				return temp;
			}
      return null;
		}
  }

}
