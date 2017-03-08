public class Program {
	public static void main(String[] args) {
		Lenkeliste<String> liste1 = new Lenkeliste<String>();
		
		liste1.settInnBak("Hei");
		liste1.settInnBak("på");
		liste1.settInnBak("deg");
		
		System.out.println(liste1);
		
		DusteArrayList liste2 = new DusteArrayList(5);
		
		liste2.settInn("din");
		liste2.settInn("gamle");
		liste2.settInn("sei");
		
		System.out.println(liste2);
	}
}
