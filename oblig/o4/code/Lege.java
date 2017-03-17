/**
 * Klassen lege inneholder navnet til legen
 * lege kan opprette resept.
 * @author Stein Raymond Rudshagen
 * @version 1.0 16. mars 2017
 */
public class Lege implements Comparable<Lege> {
   
    // private variables:
    private String navn;

    private Koe<Resept> reseptliste = new Koe<Resept>();
    
    Lege (String navn) {
	this.navn = navn;
    }

    /**
     * Henter navnet til legen
     * @return navn
     */
    public String hentNavn() {
	return this.navn;
    }

    /**
     * Sammenligner navnet til legen med en annens lege sitt navn
     * @input annenLege
     * @return int differansen mellom navnene
     */
    public int compareTo(Lege annenLege) {
	return this.hentNavn().compareTo(annenLege.hentNavn());
    }

    /**
     * Legger til resept i reseptlisten
     * @input resept
     */
    public void leggTilResept(Resept resept) {
        
	this.reseptliste.settInn(resept);
    }

    /**
     * Henter reseptlisten til legen
     * @return reseptliste
     */
    public Koe<Resept> hentReseptliste() {
	return this.reseptliste;
    }

    public String toString() {
	return this.hentNavn();
    }
}
