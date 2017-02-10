/** Dette objektet er ment for aa teste objektene i klassen Regneklynge.
 * Setter opp n antall node - objekter med spesifikasjonene:
 *  minne, prosessor, kjerne og klokkehastighet.
 * 
 * @author Stein Raymond Rudshagen
 * @version 1.0 31. januar 2017
 */

public class abel {
    public static void main(String[] args) {

	// ----------- initialiser Regneklynge ----------------------
	int antallNoderPrRack = 12;
	Regneklynge rk = new Regneklynge(antallNoderPrRack);

	// ---------- Sett inn type noder ---------------------------
	int antall1 = 650;      // noder
	int minne1 = 64;        // GB minne
	int prosessorer1 = 2;   // antall prosessorer
	int kjerner1 = 8;       // antall kjerner
	double klokke1 = 2.6e9;   // GHz

	for (int i = 0; i < antall1; i++) {
	    Node node = new Node(minne1, kjerner1, klokke1, prosessorer1);
	    rk.settInnNode(node);
	}

      	// ---------- Sett inn type noder ---------------------------
	int antall2 = 16;       // noder
	int minne2 = 1024;      // GB minne
	int prosessorer2 = 2;   // antall prosessorer
	int kjerner2 = 4;       // antall kjerner
	double klokke2 = 2.3e9;   // GHz
	    
	for (int i = 0; i < antall2; i++) {
	    Node node = new Node(minne2, kjerner2, klokke2, prosessorer2);
	    rk.settInnNode(node);
	}
	
	rk.flops();
	int minne_32_GB = 32;
	int minne_64_GB = 64;
	int minne_128_GB = 128;
	
	rk.noderMedNokMinne(minne_32_GB);
	rk.noderMedNokMinne(minne_64_GB);
	rk.noderMedNokMinne(minne_128_GB);
	rk.antallRack();
	
    }
}
