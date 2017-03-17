/**
 * Abstrakt klasse for legemiddel som holder informasjon
 * om navn, pris og virkestoff.
 * Hvert legemiddel vil faa en unik id hver.
 */
public abstract class Legemiddel {
    // static variables
    public static int id = 0;

    // private variables:
    private int legemiddelId;
    
    private String navn;
    
    private double pris;
    private double virkestoff;

    // constructor:
    Legemiddel(String navn,
	       double pris,
	       double virkestoff) {
	this.navn = navn;
	this.pris = pris;
	this.virkestoff = virkestoff;
	this.legemiddelId = this.id;
	this.id ++;
    }

    /**
     * Henter legemiddel sin id.
     *
     * @return this.id 
     */
    public int hentId() {
	return this.id;
    }
    
    /**
     * Henter navnet til legemiddelet
     *
   n  * @return navn
     */
    public String hentNavn() {
	return this.navn;
    }

    /**
     * Henter prisen til legemiddelet
     *
     * @return pris
     */
    public double hentPris() {
	return this.pris;
    }

    /**
     * Henter virkestoffet til legemiddelet
     *
     * @return virkestoff
     */
    public double hentVirkestoff() {
	return this.virkestoff;
    } 
}

/* ######################## Legemiddel A ################################### */

/**
 * Sub-klasse av Legemiddel
 * Holder samme informasjon som legemidel, men i tillegg ogsaa
 * narkotisk styrke.
 */
class LegemiddelA extends Legemiddel {
    // privat variabler
    private int narkotiskStyrke;

    // constructor
    LegemiddelA (String navn,
		 double pris,
		 double virkestoff,
		 int narkotiskStyrke) {
	super(navn, pris, virkestoff);
	this.narkotiskStyrke = narkotiskStyrke;
    }

    /**
     * Henter informasjon om narkotisk styrke
     * @return narkotisk styrke
     */
    public int hentNarkotiskStyrke() {
	return this.narkotiskStyrke;
    }
}

/* ######################## Legemiddel B ################################### */

/**
 * Sub-klasse av Legemiddel
 * Holder samme informasjon som legemidel, men i tillegg ogsaa
 * narkotisk styrke.
 */
class LegemiddelB extends Legemiddel {
    // privat variabler
    private int vanedannendeStyrke;

    // constructor
    LegemiddelB (String navn,
		 double pris,
		 double virkestoff,
		 int vanedannendeStyrke) {
	super(navn, pris, virkestoff);
	this.vanedannendeStyrke = vanedannendeStyrke;
    }

    /**
     * Henter informasjon om vanedannende styrke
     * @return vanedannende styrke
     */
    public int hentVanedannendeStyrke() {
	return this.vanedannendeStyrke;
    }
}

/* ######################## Legemiddel C ################################### */

/**
 * Sub-klasse av Legemiddel
 * Holder samme informasjon som legemidel
 */
class LegemiddelC extends Legemiddel {
    // constructor
    LegemiddelC (String navn,
		 double pris,
		 double virkestoff) {
	super(navn, pris, virkestoff);
    }
}
