public class Program {
	public static void main(String[] args) {

		OrdnetLenkeliste<String> liste2 = new OrdnetLenkeliste();
		System.out.println(liste2.erTom());
		System.out.println(liste2.storrelse());
		liste2.settInn("A");
		System.out.println(liste2.storrelse());
		liste2.settInn("2");
		System.out.println(liste2.storrelse());
		liste2.settInn("C");
		System.out.println(liste2.storrelse());
		liste2.settInn("4");
		System.out.println(liste2.storrelse());
		liste2.settInn("5");
		System.out.println(liste2.storrelse());
		System.out.println(liste2.erTom());
		//liste2.settInn("plopp");


		for(String s: liste2){
			System.out.println(s);
		}

	}
}
