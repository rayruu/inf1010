import java.util.Iterator;

public class DusteArrayList implements Iterable<String> {
	private String[] innhold;
	private int index;
	
	public DusteArrayList(int str) {
		innhold = new String[str];
		index = 0;
	}
	
	public void settInn(String element) {
		innhold[index] = element;
		index++;
	}
	
	public Iterator<String> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<String> {
		private int cursor;
		
		public ArrayIterator() {
			cursor = 0;
		}
		
		public boolean hasNext() {
			return innhold[cursor] != null;
		}
		
		public String next() {
			return innhold[cursor++];
		}
	}
	
	public String toString() {
		String resultat = "DusteArrayList:\n";
		
		for (String temp : this) {
			resultat += temp + ", ";
		}
		
		return resultat;
	}
	
}







