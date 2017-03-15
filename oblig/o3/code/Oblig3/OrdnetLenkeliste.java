import java.util.Iterator;

public class OrdnetLenkeliste<T extends Comparable<T>> implements Liste<T> {
  private Node<T> hode;
  private Node<T> denne;
  private Node<T> tidligere;
  private int lengde;

  public OrdnetLenkeliste() {
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
              System.out.println("null");
    } else{
      Node<T> temp = new Node<T>(element);
      denne = hode;
      tidligere = null;
      boolean stopp = false;
      while(denne!=null && stopp == false){
        System.out.println("while");
        if((temp.hentInnhold()).compareTo(denne.hentInnhold()) <=0){
          if(tidligere == null){
                    System.out.println("Sett inn ved Start");
            temp.settNeste(hode);
            hode = temp;
            stopp = true;
          }else{
                    System.out.println("Sett inn ved midten");
            temp.settNeste(denne);
            tidligere.settNeste(temp);
            stopp = true;
          }
        }else if(denne.hentNeste() == null){
                  System.out.println("sett inn ved slutten");
          denne.settNeste(temp);
          stopp = true;
        }
        tidligere = denne;
        denne = denne.hentNeste();
      }
    }
    lengde++;
    System.out.println("antall " + lengde);
  }

  //Fjerner et element fra starten av listen
  public T fjern(){
    T ut = hode.hentInnhold();
    hode = hode.hentNeste();
    lengde--;
    return ut;
  }


  public Iterator<T> iterator() {
    return new OrdnetLenkelisteIterator();
  }

  private class OrdnetLenkelisteIterator implements Iterator<T> {
    private Node<T> nesteElement;
    private Node<T> sistReturnert;
    private int peker;


    public OrdnetLenkelisteIterator() {
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
