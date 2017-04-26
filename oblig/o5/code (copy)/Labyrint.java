import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/** 
 * @author  Stein Raymond Rudshagen
 * @version v 1.0 10.april 2017
 */

public class Labyrint {
    // Variables:
    private Rute[][] ruteReferanse;

    private int totAntallKol;
    private int totAntallRad;

    private final static int OFFSET = 1;

    private boolean minimalUtskrift = false;

    public String test = "hei dette er en test";

    // privat constructor
    private Labyrint(Rute[][] ruteReferanse, int antallKolonner, int antallRader) {
	this.ruteReferanse = ruteReferanse;
	this.totAntallRad = antallRader;
	this.totAntallKol = antallKolonner;
    }	

    /**
     * Leser fra fil og setter opp labyrint 
     * @input fil
     * @return labyrint
     */
    public static Labyrint lesFraFil(File fil) throws FileNotFoundException {     	
	Scanner innfil = new Scanner(fil);
	
	// Henter ut stoerrelsen til labyrint og setter opp rutenett.
	String[] ord = innfil.nextLine().split(" ");
	int antallKolonner = Integer.parseInt(ord[0]);
	int antallRader = Integer.parseInt(ord[1]);
	Rute[][] ruteNett = new Rute[antallKolonner][antallRader];
	    
	int rad = 0;
	while(innfil.hasNextLine()){
	    char[] characterArray = innfil.nextLine().toCharArray();
	    
	    for(int kol = 0; (kol < antallKolonner); kol++) {
		Rute rute = null;
		
		rute = lagNyRute(kol, antallKolonner, rad, antallRader, characterArray[kol]);
		ruteNett[kol][rad] = rute;
		rute.settLabyrintReferanse(ruteNett[0][0]);

		if (rad == 0) {
		    if (kol >= 1) {
			kartleggRuteVest(rute, ruteNett, kol, rad);
		    }
		} else {
		    if (kol == 0) {
			kartleggRuteNord(rute, ruteNett, kol, rad);
		    } else {
			kartleggRuteNord(rute, ruteNett, kol, rad);
			kartleggRuteVest(rute, ruteNett, kol, rad);
		    }
		}		
	    }
	    
	    rad ++;
	}
	
	return new Labyrint(ruteNett, antallRader, antallKolonner);
    }

    /**
     * Metode for aa lage ny rute i metoden lesFraFil
     * @input rad, kol, bokstav
     * @return rute
     */
    public static Rute lagNyRute(int kol, int antallKolonner, int rad, int antallRader, char bokstav) {
	Rute rute = null;
	
	switch(bokstav) {
	case '#':  // Lager sortRute
	    rute = new SortRute(kol + OFFSET, rad + OFFSET);
	    break;
	case '.':  // Lager HvitRute eller Aapning hvis den er ved kanten
	    if(((rad + 1 ) == 1) | ((kol + 1) == 1) |
	       ((kol + 1) == antallKolonner) | ((rad + 1) == antallRader)) {
		rute = new Aapning(kol + OFFSET, rad + OFFSET);
	    } else {
		rute = new HvitRute(kol + OFFSET, rad + OFFSET);
	    }
	    break;
	default:
	    System.out.println("Feil i switch-case");
	    break;
	}
	return rute;
    }

    /**
     * Kartlegger naboruten i Nord til ruten i rutenettet
     * @input rute, ruteNett, kol, rad
     */
    public static void kartleggRuteNord(Rute rute, Rute[][] ruteNett, int kol, int rad) {
	rute.settRuteNord(ruteNett[kol][rad-1]);
	rute.hentRuteNord().settRuteSyd(rute);
    }

    /** 
     * Kartlegger naboruten i Vest til ruten i rutenettet
     * @input rute, ruteNett, kol, rad
     */
    public static void kartleggRuteVest(Rute rute, Rute[][] ruteNett,int kol, int rad) {
	rute.settRuteVest(ruteNett[kol - 1][rad]);
	rute.hentRuteVest().settRuteOest(rute);
    }
	
    @Override
    public String toString() {
	String resultat = "";
	for (int rad = 0; (rad < totAntallRad); rad++) {
	    for (int kol = 0; (kol < totAntallKol); kol++) {
		resultat += "" + ruteReferanse[kol][rad].tilTegn();
	    }
	    resultat += "\n";
	}
    
	return resultat;
    }
    
    /**
     * Metode for aa finne utvei i labyrinten 
     * @input startkol, startrad
     * @return utveiene
     */
    public Liste<String> finnUtveiFra( int startkol, int startRad) {
	Rute rute = ruteReferanse[startkol - OFFSET][startRad - OFFSET];
	
	if (!minimalUtskrift) {
	    System.out.println(this);   
	}
	else {
	    rute.settMinimalUtskrift();
	}
	
        rute.finnUtvei();
	return rute.hentUtvei();
    }
	
    /**
     * Setter minimalutskrift, som vil si at bare feilmeldinger skal skrives ut
     */
    public void settMinimalUtskrift() {
	minimalUtskrift = true;
    }
	
}


        
