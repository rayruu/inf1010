import krypto.*;
import java.util.concurrent.CountDownLatch;

/**
 * Dette programmet er ment for å simulere en etteretningssentral fra 1900-tallet som overvåker
 * linjer hvor det sendes krypterte meldinger. Dette blir løst ved å bruke tråder og monitorer
 * for å simulere forskjellige arbeidere.
 * @author Stein Raymond Rudshagen
 * @version 0.1
 */

class Oblig6 {

    public static void main(String[] args) {
	// legg args som henter telegrafer og kryptografer.
	int antallTelegrafister = 3;
	int antallKryptografer = 20;
	int antallOperasjonsleder = 1;

	// Definerer felles monitor.
	Meldinger meldinger = new Meldinger(antallTelegrafister, antallKryptografer);

	// Definerer barrierer:
	CountDownLatch barriereTelegrafer = new CountDownLatch(antallTelegrafister);
	CountDownLatch barriereKryptografer = new CountDownLatch(antallKryptografer);

	// Henter kanaler fra operasjonssentral.
	Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
	Kanal[] kanaler = ops.hentKanalArray();

	// Oppretter tråder for arbeidere.
	Thread[] telegrafer = new Thread[antallTelegrafister];
	Thread[] kryptografer = new Thread[antallKryptografer];

	// Skaffer telegrafer og starter telegrafene.
	int indeks = 0;
	for(Kanal telegrafLinje: kanaler) {
	    Runnable telegraf = new Telegraf(telegrafLinje, meldinger, barriereTelegrafer);
	    telegrafer[indeks] = new Thread(telegraf);
	    telegrafer[indeks].start();
	    indeks ++;
	}

	for (int i = 0; i<antallKryptografer; i++) {
	    Runnable kryptograf = new Kryptograf(meldinger);
	    kryptografer[i] = new Thread(kryptograf);
	    kryptografer[i].start();
	}

	// Venter på telegrafene skal bli ferdig
	try { 
	    barriereTelegrafer.await();
	    meldinger.telegraferFerdig();
	    System.out.println("TelegraferFerdig");

	}

	catch (InterruptedException ex){ 
	    System.out.println(" Uventet avbrudd ");  System.exit(0); 
	}

	try {
	    for (int i = 0; i < antallKryptografer; i++) {
		kryptografer[i].join();
	    }
	} catch (InterruptedException e) {}

	System.out.println("Skriver ut meldinger:");
	meldinger.skrivUtEnMelding();

	/*
	try {
            for (int i = 0; i < antallTelegrafister; i++) {
                telegrafer[i].join();
            }
        } catch (InterruptedException e) {}
	*/
	
	//System.out.println(kanaler[0].hentId());
	//String lytter = kanaler[0].lytt();      
	//while(lytter != null) {
	//    System.out.println(lytter);
	//    lytter = kanaler[0].lytt();
	//}
	//System.out.println("###################");
	//System.out.println("Programmet er ferdig");
	//System.out.println("###################");
	//meldinger.skrivUtKoe();
    }
}
