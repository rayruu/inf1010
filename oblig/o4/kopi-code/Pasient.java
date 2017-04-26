/**
 * Pasientklasse som inneholder informasjon til pasienten
 * @author Stein Raymond Rudshagen
 * @version 1.0 16. mars 2017
 */
public class Pasient {
    /* static variables */
    public static int id = 0;
    
    /* private variables */
    private int personligId;
    private int postnummer;
    
    private String navn;
    private String gateadresse;

    private long fodselsnummer;

    public Stabel<Resept> reseptliste = new Stabel<Resept>();

    // constructor
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

    /**
     * Henter id'n til pasient
     *@return pasient Id
     */
    public int hentId() {
	return this.personligId;
    }

    /**
     * Hener pasientens navn
     * @return navn
     */
    public String hentNavn() {
	return this.navn;
    }

    /**
     * Henter fodselsnummeret til pasienten
     * @return fodselsnummer
     */
    public long hentFodselsnummer() {
	return this.fodselsnummer;
    }

    /**
     * Henter gateadressen til pasienten
     * @return gateadresse
     */
    public String hentGateadresse() {
	return this.gateadresse;
    }

    /**
     * Henter postnummeret til pasienten
     * @return postnummer
     */
    public int hentPostnummer() {
	return this.postnummer;
    }

    /**
     * Legger til resept i reseptlisten
     * @input resept
     */
    public void leggTilResept(Resept resept) {
	this.reseptliste.settInn(resept);
    }

    /**
     * Henter reseptlisten til paasienten
     * @return Stabel<Resept>
     */
    public Stabel<Resept> hentReseptliste() {
	return this.reseptliste;
    }

    @Override
    public String toString() {
	return hentNavn();
    }
}
