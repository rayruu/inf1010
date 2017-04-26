import krypto.*;
import java.util.concurrent.CountDownLatch;

/**
 * Dette programmet inneholder klassene Telegraf, Kryptograf og Operasjonsleder. Disse er definert som arbeidere for oblig 6
 * i inf1010 2017. Telegrafen skal lytte på krypterte meldinger og legge disse til monitor, der kryptografen skal hente og
 * dekryptere meldingene. Når både lytting og dekryptering er ferdig skal Operasjonsleder skrive ut alle meldingene sortert
 * ved sekvensnummer og id.
 * @author Stein Raymond Rudshagen
 * @version 0.1
 */

class Telegraf implements Runnable {
    private Kanal telegrafLinje;
    private int kanalId;
    private Meldinger meldinger;
    private CountDownLatch barriere;

    // Konstruktør:
    Telegraf (Kanal telegrafLinje, Meldinger meldinger, CountDownLatch barriere) {
	this.telegrafLinje = telegrafLinje;
	this.kanalId = telegrafLinje.hentId();
	this.meldinger = meldinger;
	this.barriere = barriere;
    }

    @Override
    public void run() {
	String lytter = telegrafLinje.lytt();
	while (lytter != null) {
		Melding melding = new Melding(lytter, this.kanalId);
		//System.out.println(this.kanalId + " " + melding.hentSekvensnummer() + " " + lytter);
		meldinger.settInnKrypMelding(melding);
		lytter = telegrafLinje.lytt();
		
		if(lytter == null) {
		    System.out.println("Denne telegrafen er ferdig");
		    this.barriere.countDown();
		}
		    
	}
    }
    
}

class Kryptograf implements Runnable {
    private Meldinger meldinger;

    // Konstruktør:
    Kryptograf (Meldinger meldinger) {
	this.meldinger = meldinger;
    }
    
    @Override
    public void run() {
	while(meldinger.telegrafIkkeFerdig() || meldinger.ingenKrypterteMeldinger() == false) {
	    Melding melding = meldinger.hentKryptertMelding();
	    String dekryptertMelding = Kryptografi.dekrypter(melding.hentKryptertMelding());
	    melding.dekryptertMelding(dekryptertMelding);
	    this.meldinger.settInnMelding(melding);
	}

    }
}

//class Operasjonsleder {}
