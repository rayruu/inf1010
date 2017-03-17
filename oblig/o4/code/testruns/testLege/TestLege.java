
public class TestLege {
    public static void main(String[] args) {
	Legeliste leger = new Legeliste();
	
	Lege lege1 = new Lege("Dr. Dre");
	Fastlege lege2 = new Fastlege("Dr. Hus", 63634);
	Fastlege lege3 = new Fastlege("Dr. Oz", 342);
	Lege lege4 = new Lege("Dr. Phil");

	leger.settInn(lege1);
	leger.settInn(lege2);
	leger.settInn(lege3);
	leger.settInn(lege4);

	for(Lege test: leger) {
	    System.out.println(test);
	}
    }
}
