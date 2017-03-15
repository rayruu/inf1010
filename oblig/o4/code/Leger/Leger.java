
public class Lege implements Comparable<Lege> {
    private String navn;

    Lege(String navn) {
	this.navn = navn;
    }
    
    public String hentNavn() {
	return this.navn;
    }
    
    public int compareTo(Lege annenLege) { /* fyll inn */ }
    
    public void leggTilResept(Resept resept) { /* fyll inn */ }
    
    public Koe<Resept> hentReseptliste() { /* fyll inn */ }

}
