
public class Lege implements Comparable<Lege> {
    // static variables:

    // private variables:
    private String navn;
    
    Lege (String navn) {
	this.navn = navn;
    }

    public String hentNavn() {
	return this.navn;
    }
    
    public int compareTo(Lege annenLege) {
	return 0;
    }

    public void leggTilResept(Resept resept) {
	/* fyll inn */
    }
    
    public Koe<Resept> hentReseptliste() {
	return null;
	/* fyll inn */
    }	
}
