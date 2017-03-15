import java.util.Iterator;

public class StatiskTabell<T> implements Tabell<T> {
  private int lengde;
  private T[] tabell;
  private int indeks;


  public StatiskTabell(int lengde) {
    tabell = (T[]) new Object[lengde];
    indeks = 0;
    this.lengde = lengde;
  }

  public int storrelse() {
    return indeks;
  }

  public boolean erTom() {
    boolean tom = true;
    if(indeks != 0){
      tom = false;
    }
    return tom;
  }

  public void settInn(T element) {
    if(indeks>(lengde-1)){
      throw new FullTabellUnntak(lengde);
    } else {
      tabell[indeks++] = element;
    }
  }

  public T hentFraPlass(int plass) {
    if(0 > plass || plass > (lengde-1)|| tabell[plass]==null){
      throw new UgyldigPlassUnntak(plass,lengde);
    }
    else{
      return tabell[plass];
    }
  }

    public Iterator<T> iterator() {
      return new TabellIterator();
    }

    private class TabellIterator implements Iterator<T> {
      private int peker;


      public TabellIterator() {
          peker = 0;
      }

      public boolean hasNext() {
        if(peker >= lengde){
          return false;
        } else{
          return tabell[peker] != null;
        }
      }

      public T next() {
        return tabell[peker++];
      }
    }
}
