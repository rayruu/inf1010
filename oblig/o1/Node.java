/** Objektet av denne klassen tar vare paa:
 * minnestoerrelsen og oppretter en eller to Prosessor-objekter
 * avhengig av konstruktoerene.
 *
 * @author Stein Raymond Rudshagen
 * @version 1.0 31.januar.2017
 */

public class Node {
    int minneStorrelse;    // stoerrelsen paa minnet.
    int prosessorer = 1;   // antall prosessor knyttet til node.
    Prosessor pros1;       // prosessor 1.
    Prosessor pros2;       // prosessor 2.

    Node(int minne, int kjerner, double klokke) {
	minneStorrelse = minne;    // referer til minnet.

	Prosessor prosessor1 = new Prosessor(kjerner, klokke);
	pros1 = prosessor1;        // referer til prosessor
    }

    Node(int minne, int kjerner, double klokke, int antProsessor) {
	minneStorrelse = minne;     // referer til minnet.
	prosessorer = antProsessor; // referer til antall prosessorer knyttet noden

	Prosessor prosessor1 = new Prosessor(kjerner, klokke);
	pros1 = prosessor1;         // referer til prosessor 1
	Prosessor prosessor2 = new Prosessor(kjerner, klokke);
	pros2 = prosessor2;         // referer til prosessor 2
    }
}

