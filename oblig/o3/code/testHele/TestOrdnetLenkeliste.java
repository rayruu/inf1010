
public class TestOrdnetLenkeliste {
    public static void main(String[] args) {
        OrdnetLenkeliste<String> ll = new OrdnetLenkeliste<String>();
	String data1 = "elementB";
	String data2 = "elementC";
	String data3 = "elementD";
	


	System.out.println("d2 c d1: " + data2.compareTo(data1));
	System.out.println("d3 c d1: " + data3.compareTo(data1));
	System.out.println("d3 c d2: " + data3.compareTo(data2));
	
        ll.settInn("elementC");
        ll.settInn("elementAA");
        ll.settInn("elementAA");
        ll.settInn("elementBBB");
        ll.settInn("elementD");
		
	for (String s : ll) {
            System.out.println(s);
        }
    }
}


