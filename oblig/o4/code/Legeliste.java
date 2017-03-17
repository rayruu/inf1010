
public class Legeliste extends OrdnetLenkeliste<Lege> {
    /**
     * Soeker gjennom listen etter en lege med samme navn som `navn`
     * og returnerer legen (uten aa fjerne den fra listen).
     * Hvis ingen slik lege finnes, returneres `null`.
     * @param   navn    navnet til legen
     * @return  legen
     */
    public Lege finnLege(String navn) {
	initIterasjon();
	Lege lege = null;

	while((harNeste() == true) && (hentData().hentNavn().compareTo(navn) <= 0)) {
	    if (hentData().hentNavn().compareTo(navn) == 0) {
		lege = hentData();
	    }
	    neste();
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
	initIterasjon();
	
	while(harNeste() == true) {
	    arrayMedNavn[i] = hentData().hentNavn();
	    i ++;
	    neste();
	}
	return arrayMedNavn;
    }
}


