import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class Lenkeliste<T> implements Iterable<T> {
	
	private Node<T> hode;
	private Node<T> hale;
	
	private int lengde;
	
	public Lenkeliste() {
		lengde = 0;
	}
	
	public boolean tom() {
		return lengde == 0;
	}
	
	public int hentLengde() {
		return lengde;
	}
	
	public void settInnForan(T element) {
		if (hode == null) {
			// tom liste
			hode = new Node<T>(element);
			hale = hode;
		} else {
			Node<T> ny = new Node<T>(element);
			
			ny.settInnMellom(null, hode);
			hode = ny;
		}
		
		lengde++;
	}
	
	public void settInnBak(T element) {
		if (hale == null) {
			// tom liste
			hale = new Node<T>(element);
			hode = hale;
		} else {
			Node<T> ny = new Node<T>(element);
			
			ny.settInnMellom(hale, null);
			hale = ny;
			
		}
		
		lengde++;
	}
	
	public T taUtForan() {
		Node<T> taUtDenne = hode;
		hode = taUtDenne.hentNeste();
		taUtDenne.kobleUt();
		
		lengde--;
		
		return taUtDenne.hentInnhold();
	}
	
	
	public T taUtBak() {
		Node<T> taUtDenne = hale;
		hale = taUtDenne.hentForrige();
		taUtDenne.kobleUt();
		
		lengde--;
		
		return taUtDenne.hentInnhold();
	}
	

	public void settInn(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > lengde) {
			throw new IndexOutOfBoundsException(index + " er ikke i intervallet [0," + lengde + ")");
		}
		
		if (index == 0) {
			settInnForan(element);
			
		} else if (index == lengde) {
			settInnBak(element);
			
		} else {
			Node<T> settInnHer = hode;
			
			for (int i=0; i<index; i++) {
				settInnHer = settInnHer.hentNeste();
			}
			
			Node<T> ny = new Node<T>(element);
			
			ny.settInnMellom(settInnHer.hentForrige(), settInnHer);
			
			lengde++;
		}
	}
	
	public T taUt(int index) {
		if (index < 0 || index >= lengde) {
			throw new IndexOutOfBoundsException(index + " er ikke i intervallet [0," + lengde + ")");
		}
		
		T returnerDette;
		
		if (index == 0) {
			returnerDette = taUtForan();
		} else if (index == lengde-1) {
			returnerDette = taUtBak();
		} else {
			Node<T> taUtHer = hode;
			
			for (int i=0; i<index; i++) {
				taUtHer = taUtHer.hentNeste();
			}
			
			returnerDette = taUtHer.hentInnhold();
			taUtHer.kobleUt();
			lengde--;
		}
		
		return returnerDette;
	}
	
	public Iterator<T> iterator() {
		return new LenkelisteIterator();
	}
	
	public ListIterator<T> listIterator() {
		return new LenkelisteIterator();
	}
	
	private class LenkelisteIterator implements ListIterator<T> {
		private Node<T> nesteElement;
		private Node<T> sistReturnert;
		
		private int index;
		
		public LenkelisteIterator() {
			nesteElement = hode;
			index = 0;
		}
		
		public void add(T element) {
			if (!hasNext()) {
				settInnBak(element);
			} else {
				Node<T> ny = new Node<T>(element);
			
				ny.settInnMellom(nesteElement.hentForrige(), nesteElement);
			
				if (nesteElement == hode) {
					hode = ny;
				}
				
				lengde++;
			}
			
			index++;
		}
		
		public boolean hasNext() {
			return nesteElement != null;
		}
		
		public boolean hasPrevious() {
			return nesteElement.hentForrige() != null;
		}
		
		public T next() throws NoSuchElementException {
			if (hasNext()) {
				T temp = nesteElement.hentInnhold();
				sistReturnert = nesteElement;
				nesteElement = nesteElement.hentNeste();
				index++;
				return temp;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public int nextIndex() {
			return index;
		}
		
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				T temp = nesteElement.hentForrige().hentInnhold();
				sistReturnert = nesteElement.hentForrige();
				index--;
				return temp;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public int previousIndex() {
			return index-1;
		}
		
		public void remove() throws IllegalStateException {
			if (sistReturnert != null) {
				if (sistReturnert == hode) {
					hode = hode.hentNeste();
				}
				if (sistReturnert == hale) {
					hale = hale.hentForrige();
				}
				
				sistReturnert.kobleUt();
				sistReturnert = null;
				
				if (nesteElement != null && sistReturnert == nesteElement.hentForrige()) {
					index--;
				}
				
				lengde--;
			} else {
				throw new IllegalStateException();
			}
		}
		
		public void set(T element) throws IllegalStateException {
			if (sistReturnert != null) {
				sistReturnert.nyttInnhold(element);
			} else {
				throw new IllegalStateException();
			}
		}
	}
	
	public String toString() {
		String resultat = "Lenkeliste:\n";
		
		for (T temp : this) {
			resultat += temp + ", ";
		}
		
		return resultat;
	}

}












