import krypto.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Dette programmet inneholder monitor og informasjonskapsel som er ment for å bruke til oblig 6 i inf1010 2017.
 * Monitoren er ment for å samle alle meldingene fra telegrafen og kryptografen. Melding vil bli benyttet for å sammle
 * informasjon om sekvensnummer, id og melding
 * @author Stein Raymond Rudshagen
 * @version 0.1
 */

class Meldinger { // Monitor

    private int antallTelegrafer, antallKryptografer;

    private Koe<Melding> krypterteMeldinger;
    private Stabel<Melding> stabelMeldinger;
    
    volatile private boolean telegraferFerdig;
    
    private Lock laas;
    private Condition krypterteMeldingerIkkeTom;

    Meldinger(int antallTelegrafer, int antallKryptografer) {
	this.antallTelegrafer = antallTelegrafer;
	this.antallKryptografer = antallKryptografer;
	
	krypterteMeldinger = new Koe<Melding>();
	stabelMeldinger = new Stabel<Melding>();
	telegraferFerdig = false;
	
	laas = new ReentrantLock();
	krypterteMeldingerIkkeTom = laas.newCondition();

    }

    /*
      ################## Telegraf ############################
     */

    public void settInnKrypMelding(Melding melding) {
	laas.lock();
	try {
	    krypterteMeldinger.settInn(melding);
	    krypterteMeldingerIkkeTom.signalAll();
	}
	finally {laas.unlock(); }}

    //
    public void skrivUtKoe() {
	for (Melding melding : krypterteMeldinger) {
	    System.out.println(melding);
	}
    }

    public void telegraferFerdig() {
	this.telegraferFerdig = true; }

    public boolean telegrafIkkeFerdig () {
	return !this.telegraferFerdig;   }
    
    
    /*
      ################## Kryptograf ############################
     */

    public Melding hentKryptertMelding() {
	Melding melding = null;
	laas.lock();
	try {
	    while (ingenKrypterteMeldinger()) {
		krypterteMeldingerIkkeTom.await();
	    }
	     melding = krypterteMeldinger.fjern();
	}
	catch (InterruptedException ex) { }
	finally {laas.unlock();}
	return melding;
    }

    public void settInnMelding(Melding melding) {
	laas.lock();
	try {
	    stabelMeldinger.settInn(melding);
	} finally {laas.unlock(); }
    }

    public boolean ingenKrypterteMeldinger() {
	return krypterteMeldinger.erTom();
    }

    public void skrivUtEnMelding() {
	for (Melding melding: stabelMeldinger) {
	    System.out.println(melding);
	}
    }
}

class Melding {
    private static int totalSekvensnummer = 0;
    private int sekvensnummer;
    private int kanalId;
    private String kryptertMelding;
    private String melding;

    // Konstruktør:
    Melding(String kryptertMelding, int kanalId) {
	this.kryptertMelding = kryptertMelding;
	this.kanalId = kanalId;
	this.sekvensnummer = this.totalSekvensnummer;
	this.totalSekvensnummer ++;
    }

    public void dekryptertMelding(String melding) {
	this.melding = melding;
    }

    public String toString() {
	return "" + this.kanalId + " " + this.sekvensnummer + " " + this.melding;
    }

    public String hentKryptertMelding() {
	return this.kryptertMelding;
    }

    public int hentSekvensnummer() {
	return this.sekvensnummer;
    }

    public int hentId() {
	return this.kanalId;
    }
}
