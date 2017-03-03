/** This class is superclass for vehicles and it sorts out which type of vehicles, vehicle belongs to.
 * 
 * @author Stein Raymond Rudshagen
 * @version 1.0 10. Februar 2017
 */

public class Vehicle {
    private String registerNumber;

    public Vehicle (String registerNumber) {
	this.registerNumber = registerNumber;
    }

    /**
     * Recieve information from this class
     */
    public String getInformation() {
	return ("\nType vehicle:  " + getClass().getName()
		+ "\nReg.number: " + this.registerNumber);
	
    }

    public String toString() {
	return getInformation();
    }
}
