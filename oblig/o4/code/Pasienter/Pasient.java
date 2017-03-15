
public class Pasient {
    private int ID;
    private String navn;
    private long fodselsnummer;
    private String gateadresse;
    private int postnummer;

    Pasient(int ID, String navn, long fodselsnummer, String gateadresse, int postnummer) {
	this.ID = ID;
	this.navn = navn;
	this.fodselsnummer = fodselsnummer;
	this.gateadresse = gateadresse;
	this.postnummer = postnummer;
    }

    public int hentId() {
	return this.ID;
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
    
    public Stabel<Resept> hentReseptliste() { /* fyll inn */ }
}
    
	
   
