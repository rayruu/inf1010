
public class Pasient {
    /* static variables */
    public static int id = 0;
    
    /* private variables */
    private int personligId;
    private int postnummer;
    
    private String navn;
    private String gateadresse;

    private long fodselsnummer;

    // private Resept resept;
    
    
    Pasient(String navn,
	    long fodselsnummer,
	    String gateadresse,
	    int postnummer) {
	this.navn = navn;
	this.fodselsnummer = fodselsnummer;
	this.gateadresse = gateadresse;
	this.postnummer = postnummer;
	this.personligId = this.id;
	this.id ++;
    }

    public int hentId() {
	return this.personligId;
    }
    public String hentNavn() {
	return this.navn;
    }
    public long hentFodselsnummer() {
	return this.fodselsnummer;
    }
    public String hentGateadresse() {
	return this.gateadresse;
    }
    public int hentPostnummer() {
	return this.postnummer;
    }
    
    public void leggTilResept(Resept resept) { /* fyll inn */ }
    
    public Stabel<Resept> hentReseptliste() {
	return null;
    }

	
}
