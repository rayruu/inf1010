public abstract class Resept {
    // static variable
    public static int id = 0;

    // private variable
    private int reseptId;
    private int pasientId;
    private int reit;

    private Lege utskrivendeLege;
    private Legemiddel legemiddel;

    
    // constructor
    Resept(Legemiddel legemiddel,
	   Lege utskrivendeLege,
	   int pasientId,
	   int reit) {
	this.legemiddel = legemiddel;
	this.utskrivendeLege = utskrivendeLege;
	this.pasientId = pasientId;
	this.reit = reit;
	this.reseptId = this.id;
	this.id ++;
    }

    /**
     * Henter id'n til resept
     * @return resept Id
     */
    public int hentId() {
	return this.reseptId;
    }

    /**
     * Henter legemiddelet knyttet til resept
     * @return legemiddel
     */
    public Legemiddel hentLegemiddel() {
	return this.legemiddel;
    }

    /**
     * Henter lege som har skrevet ut resept til pasient
     * @return utskrivendeLege
     */
    public Lege hentLege() {
	return this.utskrivendeLege;
    }

    /** 
     * Henter ut pasientens id som eier denne resepten
     * @return pasientId
     */
    public int hentPasientId() {
	return this.pasientId;
    }

    /**
     * Henter antall ganger resepten kan brukes
     * @return reit
     */
    public int hentReit() {
	return this.reit;
    }

    /**
     * Bruker resepten én gang. Returner false om resepten er
     * oppbrukt, ellers returnerer den true.
     * @return      om resepten kunne brukes
     */
    public boolean bruk() {
	return this.reit != 0;
    }

    /**
     * Returnerer reseptens farge. Enten "blaa" eller "hvit".
     * @return      reseptens farge
     */
    abstract public String farge();

    /**
     * Returnerer prisen pasienten maa betale.
     * @return      prisen pasienten maa betale
     */
    abstract public double prisAaBetale();

    @Override
    public String toString() {
	return this.hentLegemiddel().hentNavn();
    }
}

/* ######################## BlaaResept  ################################### */

/** 
 * Sub-klasse av Resept
 * Holder samme informasjon som respept, men beskriver blaaresept
 * Det vil si at det gis rabater paa legemidler
 */
class BlaaResept extends Resept {
    private double prisAaBetale;

    // constructor
    BlaaResept(Legemiddel legemiddel,
	       Lege utskrivendeLege,
	       int pasientId,
	       int reit) {
	super(legemiddel, utskrivendeLege, pasientId, reit);
	this.prisAaBetale = legemiddel.hentPris()*0.25;
    }
    
    @Override
    public String farge(){
	return "blaa";
    }
    
    @Override
    public double prisAaBetale() {
	return this.prisAaBetale;
    }

    @Override
    public String toString() {
	return super.toString() + this.farge() + this.prisAaBetale();
    }
}

/* ######################## HvitResept  ################################### */


/** 
 * Sub-klasse av Resept
 * Holder samme informasjon som respept, men beskriver hvitresept
 * Det vil si at det ikke gis rabater paa legemidler
 */
class HvitResept extends Resept {
    private double prisAaBetale;

    // constructor
    HvitResept(Legemiddel legemiddel,
	       Lege utskrivendeLege,
	       int pasientId,
	       int reit) {
	super(legemiddel, utskrivendeLege, pasientId, reit);
	this.prisAaBetale = legemiddel.hentPris();
    }

    @Override
    public String farge(){
	return "hvit";
    }

    @Override
    public double prisAaBetale() {
	return this.prisAaBetale;
    }
    
    @Override
    public String toString() {
	return super.toString() + this.farge() + this.prisAaBetale();
    }
}

	
