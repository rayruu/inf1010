public class Node<T> {
  private Node<T> neste;
  private T innhold;

  public Node(T innhold){
    this.innhold = innhold;
  }

  public void settNeste(Node<T> neste) {
    this.neste = neste;
  }

  public Node<T> hentNeste() {
    return neste;
  }

  public T hentInnhold() {
    return innhold;
  }

}
