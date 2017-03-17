/**
 * Sub-klasse av lege som har tilleggsinformasjon om kommuneavtale
 * @author Stein Raymond Rudshagen
 * @version 1.0 14. mars 2017
 */
public class Fastlege extends Lege implements Kommuneavtale{
    private int avtalenummer;
    
    Fastlege(String navn, int avtalenummer) {
	super(navn);

	this.avtalenummer = avtalenummer;
    }

    /**
     * Henter ut avtalenummer
     * @return avtalenummer
     */
    public int hentAvtalenummer() {
	return this.avtalenummer;
    }
}
