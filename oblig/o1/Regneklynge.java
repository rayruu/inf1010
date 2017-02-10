/** Objekter av denne klassen tar vare paa og organiserer objekter som Rack, Node og Prosessor
 * ved hjelp av ArrayList og andre metoder.
 *
 * @author Stein Raymond Rudshagen
 * @version 1.0 31. januar 2017
 */

import java.util.ArrayList;
import java.lang.Math;

public class Regneklynge {
    ArrayList<Rack> rack = new ArrayList<Rack>();
    Rack racket;

    private int fpk = 8;                   // flyttallsoperasjoner per klokkesyklus
    //private double hz = Math.pow(10, 9);   // 1 GHz = 10**9 Hz
    private double flops = 0;              // sum flops
    private int doublePros = 2;            // Antall prosessorer
    
    int antallNoderPrRack;
    int rackPos = 0;

    Regneklynge(int nPrRack) {
	antallNoderPrRack = nPrRack;
	racket = new Rack(antallNoderPrRack);
	rack.add(racket);
    }

    /**
     * Denne metoden setter inn node inn i et ledig Rack-objekt fra listen hvis det er plass.
     * Hvis det ikke er plass vil den opprette et nytt Rack-objekt og legge noden til der.
     *
     * @ node Node-objekt
     */
    public void settInnNode(Node node) {
	if (antallNoderPrRack > rackPos) {
	    //System.out.println(racket.rackSize());
	    racket.settInnNode(node, rackPos);
	    rackPos++;			       
	}
	else {
	    racket = new Rack(antallNoderPrRack);
	    rackPos = 0;
	    rack.add(racket);
	    racket.settInnNode(node, rackPos);
	    rackPos++;
	}
    }
    
    /**
     * Henter ut objektet: Racket i ArrayList: Rack
     *
     * @param i posisjonen til racket.
     * @return rack.get(i) Den avgitte racket til i
     */
    public Rack hentRack(int i) {
	return rack.get(i);
    }
    
    /**
     * Skriver ut  maksimal teoretisk ytelse ved hjelp av flyttallsoperasjoner per sekund (FLOPS)
     * FLOPS = antall kjerner*klokkehastighet*flyttallsoperasjoner per klokkesyklus.
     * Det antas at regnekapasiteten for hele regneklyngen er summen av  regnekapasiteten til alle nodene.
     */
    public void flops() {
	for (int j = 0; j < rack.size(); j++) { 
	    
	    for (int i = 0; i < antallNoderPrRack; i++) {
		// FLOPS = antall kjerner * klokkehastighet* flyttalsoperasjoner per klokkesyklus
		if (hentRack(j).hentNode(i) != null) {
		
		    if (hentRack(j).hentNode(i).prosessorer == doublePros) {
			// Prosessor 1:
			flops = flops + (hentRack(j).hentNode(i).pros1.kjerne*
					 hentRack(j).hentNode(i).pros1.klHastighet*fpk);
			// Prosessor 2:
			flops = flops + (hentRack(j).hentNode(i).pros2.kjerne*
					 hentRack(j).hentNode(i).pros2.klHastighet*fpk);
		    }
		    else {
			flops = flops + (hentRack(j).hentNode(i).pros1.kjerne*
					 hentRack(j).hentNode(i).pros1.klHastighet*fpk);
		    }	      
		}		    
	    }
	}
	flops = flops;
	System.out.printf("Samlet FLOPS: %.5e \n", flops);
    }

    /**
     * Skriver ut oversikt over tilgjengelige noder som kan haandtere paakrevd minne
     *
     *@param paakrevdMinne Settverdien for paakrevd minne
     */
    public void noderMedNokMinne(int paakrevdMinne) {
	int antall = 0;
	for (int i = 0; i < rack.size(); i++) {
	    for (int j = 0; j < antallNoderPrRack; j++) {
		if (hentRack(i).hentNode(j) != null) {
		    if (paakrevdMinne <= hentRack(i).hentNode(j).minneStorrelse) {
			antall++;
		    }
		}
	    }
	}
	
	System.out.println("Noder med minst " + paakrevdMinne +" GB: " + antall);
    }

    /**
     * Skriver ut antall racket som har blitt opprettet avhengig av hvor mange noder 
     * det er plass til pr racket og hvor mange noder som er lagt til.
     */
    public void antallRack() {
	System.out.println("Antall rack: " + rack.size());
    }    
}
