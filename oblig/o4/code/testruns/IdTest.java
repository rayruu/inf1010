
abstract class Hund {
    static int antall = 0;
    private int id;

    Hund() {
	this.id = antall;
	antall ++;
    }

    public int hentID() {
	return this.id;
    }	
}

class Valp extends Hund {
    Valp() {
	super();
    }
}

class Katt {
    static int antall = 0;
    private int id;

    Katt() {
	this.id = this.antall;
	this.antall ++;
    }

    public int hentID() {
	return this.id;
    }
}

public class IdTest {
    public static void main(String[] args) {
	//Hund jiff = new Hund();
	Valp balto = new Valp();
	Valp gunnar = new Valp()
	Katt zalo = new Katt();
	Katt pussi = new Katt();

	//System.out.println("Hund jiff sin id:" + jiff.hentID());
	System.out.println("Katt zalo sin id:" + zalo.hentID());
	System.out.println("Katt pussi sin id:" + pussi.hentID());
	System.out.println("Valp balto sin id:" + balto.hentID());
	System.out.println(Hund.antall);
	System.out.println(Katt.antall);
    }
}
	
	
