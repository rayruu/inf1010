/** 
 * @author  Stein Raymond Rudshagen
 * @version v 1.0 10.april 2017
 */

public abstract class Rute {
    // Variables;
    private int kolonne, rad;

    private Rute ruteReferanse;
    private Rute nord, syd, vest, oest;

    private enum Retning {NORD, SYD, VEST, OEST}

    private Koe<String> utvei = new Koe<String>();

    private boolean minimalUtskrift = false;

    public boolean paaVeien = false; // bonusoppgave

    Rute (int kolonne, int rad) {
	this.rad = rad;
	this.kolonne = kolonne;	
    }

    /**
     * Returnerer rutens tegnepresentasjon i en fil som beskrevet
     * i filformat
     * @return tegnerepresentasjon
     */
    public abstract char tilTegn();

    /**
     * Setter referanse til labyrinten (mulig komme med mer forklaring her)
     * @input referanse
     */
    public void settLabyrintReferanse(Rute referanse) {
	this.ruteReferanse = referanse;
    }	

    @Override
    public String toString() {
	return "(" + this.kolonne + "," + this.rad + ")";
    }

    /**
     * Peker til rute i nord for denne ruten
     * @input rute
     */
    public void settRuteNord(Rute rute) {
	this.nord = rute;
    }
    
    /**
     * Peker til rute i syd for denne ruten
     * @input rute
     */
    public void settRuteSyd(Rute rute) {
	this.syd = rute;
    }
    
    /**
     * Peker til rute i vest for denne ruten
     * @input rute
     */
    public void settRuteVest(Rute rute) {
	this.vest = rute;
    }
    
    /**
     * Peker til rute i Oest for denne ruten
     * @input rute
     */
    public void settRuteOest(Rute rute) {
	this.oest = rute;
    }

    /**
     * henter rute nord for denne ruten
     * @return rute
     */
    public Rute hentRuteNord() {
	return this.nord;
    }

    /**
     * henter rute vest for denne ruten
     * @return rute
     */
    public Rute hentRuteVest() {
	return this.vest;
    }

    /**
     * henter rute nord for denne ruten
     * @return rute
     */
    public Rute hentRuteSyd() {
	return this.syd;
    }

    /**
     * henter rute vest for denne ruten
     * @return rute
     */
    public Rute hentRuteOest() {
	return this.oest;
    }
    

    /**
     * Initialiser gaa for aa finne en rute av type: aapning
     * @input rute, vei
     */
    public void gaa(Rute rute, String vei) {
	String ruteVei = "";
	if (rute instanceof Aapning) {
	    ruteVei = vei + " --> " + rute;
	    
	    utvei.settInn(ruteVei);

	    if (!minimalUtskrift) { // skriver ut labyrinten
		this.skrivUtRuteNett();
	    }
	    
	    return;
	}

	for (Retning retning : Retning.values()) {
	    if(sjekkRetning(retning, rute)) {
		ruteVei = "" + rute;
		switch(retning) {
		case NORD:
		    rute.nord.paaVeien = true;
		    gaa(rute.nord, Retning.SYD, ruteVei);
		    rute.nord.paaVeien = false;
		    break;
		case VEST:
		    rute.vest.paaVeien = true;
		    gaa(rute.vest, Retning.OEST, ruteVei);
		    rute.vest.paaVeien = false;
		    break;
		case OEST:
		    rute.oest.paaVeien = true;
		    gaa(rute.oest, Retning.VEST, ruteVei);
		    rute.oest.paaVeien = false;
		    break;
		case SYD:
		    rute.syd.paaVeien = true;
		    gaa(rute.syd, Retning.NORD, ruteVei);
		    rute.syd.paaVeien = false;
		    break;
		}
	    }
	}
    }    

    // Lik som gaa metoden ovenfor, men husker ogsaa hvor gaa kommer fra
    // slik at den ikke gaar tilbake samme retning den kommer fra.
    private void gaa(Rute rute, Retning kommerFra, String vei) {
	String ruteVei = "";
	if (rute instanceof Aapning) {
	    ruteVei = vei + " --> " + rute + "\n";
	    //	    utvei.settInn(ruteVei);
	    utvei.settInn(ruteVei);

	    if (!minimalUtskrift) {  // Skriver ut labyrinten
		this.skrivUtRuteNett();
	    }
	    
	    return;
	}
	
	for (Retning retning : Retning.values()) {
	    if((sjekkRetning(retning, rute)) && (kommerFra != retning)) {
		ruteVei = vei + " --> " + rute;
		switch(retning) {
		case NORD:
		    rute.nord.paaVeien = true;
		    gaa(rute.nord, Retning.SYD, ruteVei);
		    rute.nord.paaVeien = false;
		    break;
		case VEST:
		    rute.vest.paaVeien = true;
		    gaa(rute.vest, Retning.OEST, ruteVei);
		    rute.vest.paaVeien = false;
		    break;
		case OEST:
		    rute.oest.paaVeien = true;
		    gaa(rute.oest, Retning.VEST, ruteVei);
		    rute.oest.paaVeien = false;
		    break;
		case SYD:
		    rute.syd.paaVeien = true;
		    gaa(rute.syd, Retning.NORD, ruteVei);
		    rute.syd.paaVeien = false;
		    break;
		}
	    }
	}
    }

    // Sjekker om naboruten er HvitRute, hvis true. Da gaar vi dit.
    // Bonus: sjekker ogsaa om vi ikke har gaat der foer.
    private boolean sjekkRetning(Retning retning, Rute rute) {
	boolean gaa = false;
	
	switch(retning) {
	case NORD:
	    if ((rute.nord instanceof HvitRute) && (rute.nord.paaVeien == false)) {
		gaa = true;
	    }
	    //return rute.nord instanceof HvitRute;
	    return gaa;
	case VEST:
	    if ((rute.vest instanceof HvitRute) && (rute.vest.paaVeien == false)) {
		gaa = true;
	    }
	    //return rute.vest instanceof HvitRute;
	    return gaa;
	case OEST:
	    if ((rute.oest instanceof HvitRute) && (rute.oest.paaVeien == false)) {
		gaa = true;
	    }
	    //return rute.oest instanceof HvitRute;
	    return gaa;
	case SYD:
	    if ((rute.syd instanceof HvitRute) && (rute.syd.paaVeien == false)) {
		gaa = true;
	    }
	    //return rute.syd instanceof HvitRute;
	    return gaa;
	}
	return gaa;
    }
    
    /**
     * Metode for aa finne utvei, hvis stabel er tom initialiser gaa-metoden.
     */
    public void finnUtvei() {
	if ((utvei.erTom()) && (this instanceof HvitRute)) {
	    String start = " " + this;
	    this.paaVeien = true;
	    gaa(this, start);
	    this.paaVeien = false;

	}
    }
    
    /**
     * Henter utvei.
     */
    public Koe<String> hentUtvei() {
	return this.utvei;
    }

    /**
     * Setter minimalutskrift saa ikke alle loesningene skrives ut i labyrint-form
     */
    public void settMinimalUtskrift() {
	minimalUtskrift = true;
    }
	
    /**
     * Skriver ut labyrint og eventuelt loesningen til labyrinten
     */
    public void skrivUtRuteNett() {
	Rute rad = ruteReferanse;
	Rute kol = ruteReferanse;

	while (rad != null) {
	    while(kol != null) {
		System.out.print(kol.tilTegn());
		kol = kol.hentRuteOest();
	    }
	    rad = rad.hentRuteSyd();
	    kol = rad;

	    System.out.print("\n");
	}
	
	System.out.print("\n");
    }
}


/*
  ########################## Sub - klasser #############################################
*/

/**
 * Sub - klasse av Rute som indikerer at denne ruten er ikke mulig aa gaa paa.
 */
class SortRute extends Rute {
    private static final char TEGN = '#';

    SortRute(int kolonne, int rad) {
	super(kolonne, rad);
    }
    
    @Override
    public char tilTegn() {
	return this.TEGN;
    }
}

/**
 * Sub - klasse av Rute som indikerer at denne ruten er mulig aa gaa paa.
 */
class HvitRute extends Rute {
    private static final char TEGN = ' ';
    private static final char TRAAD = '.';
    
    HvitRute(int kolonne, int rad) {
	super(kolonne, rad);
    }

    @Override
    public char tilTegn() {
	if (this.paaVeien) {
	    return this.TRAAD;
	} else {
	    return this.TEGN;
	}
    }
}

/**
 * Sub - klasse av HvitRute som indikerer at denne ruten er aapen og ingangen til labyrinten.
 */
class Aapning extends HvitRute {

    Aapning(int kolonne, int rad) {
	super(kolonne, rad);
    }
}
