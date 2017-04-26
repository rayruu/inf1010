/**
 * Sub-klasse av ordnetlenkeliste som er stoerrelsesorden der foerste bokstav paa alfabetet er minst
 * og siste er stoerst.
 * @author Stein Raymond Rudshagen
 * @version 1.0 17. mars 2017
 */
public class Legeliste extends OrdnetLenkeliste<Lege> {
    /**
     * Soeker gjennom listen etter en lege med samme navn som `navn`
     * og returnerer legen (uten aa fjerne den fra listen).
     * Hvis ingen slik lege finnes, returneres `null`.
     * @param   navn    navnet til legen
     * @return  legen
     */
    public Lege finnLege(String navn) {
	Lege lege = null;

	for (Lege sjekkLege:this) {
	    if(navn.compareTo(sjekkLege.hentNavn()) == 0) {
		lege = sjekkLege;
	    }
	}
	return lege;
    }

    /**
     * Returnerer et String[] med navnene til alle legene i listen
     * i samme rekkefoelge som de staar i listen.
     * @return array med navn til alle legene
     */
    public String[] stringArrayMedNavn() {
	String[] arrayMedNavn = new String[storrelse()];
	int i = 0;
	
	for (Lege navn:this) {
	    arrayMedNavn[i] = navn.hentNavn();
	    i++;
	}
	return arrayMedNavn;
    }
}


