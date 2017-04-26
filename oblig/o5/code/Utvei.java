
/**
 * Lagrer utveier til klasse-objekt og endrer Comparable.
 * @author Stein Raymond Rudshagen
 * @version 1.0 19. april 2017
 */

public class Utvei implements Comparable<Utvei>{
    private String utvei;
    private int lengde;

    // Konstruktoer
    public Utvei(String utvei) {
	this.utvei = utvei;
	this.lengde = this.utvei.length();
    }

    // Skriver over compareTo() - metoden
    @Override
    public int compareTo(Utvei other) {
	return this.hentLengde() - other.hentLengde();
    }

    // Skriver over toString() - metoden
    @Override
    public String toString() {
	return "" + this.utvei;
    }

    /**
     * Henter lengde.
     * @return lengde
     */
    public int hentLengde() {
	return this.lengde;
    }

    /**
     * Henter utvei
     * @return utvei
     */
    public String hentUtvei() {
	return this.utvei;
    }
}
	
    
