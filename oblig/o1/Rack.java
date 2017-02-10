/** Objekter av denne klassen organiserer Node - objektene.
 * Setter inn/leser Node-objekter i racket som har n plass til Noder.
 * Array: racket, blir definert i konstruktoer ved hjelp av antallNoderPrRack
 *
 * @author Stein Raymond Rudshagen
 * @version 1.1 31. januar 2017
 */

public class Rack {
    int storrelse;
    Node[] racket;
    
    Rack(int antallNoderPrRack){
	racket = new Node[antallNoderPrRack];
    }	

    /**
     * Setter inn Node-objekt i racket
     *
     * @param n Node-objektet
     * @param pos Posisjonen i racket som noden til
     */
    public void settInnNode(Node n, int pos) {
	racket[pos] = n;
    }

    /**
     * Leser av node i racket
     *
     * @param i Posisjonen til noden i racket
     * @return racket[i] Leser node i racket
     */
    public Node hentNode(int i) {
	return racket[i];
	    }
}

/* version log:
   1.1 Endret int variable i konstruktoeren til int  antallNoderPrRack. Het tidligere nPrRack
    -  Endret også array-type. Proevde foerst med ArrayList, og dynamisk legge til noder
    -  Dette funket ikke ved test med 650 noder. Så endret det til statisk array istedenfor.
 */
