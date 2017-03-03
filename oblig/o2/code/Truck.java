/** This class is a subclass of vehicle and FossilVehicle, which manage information on trucks
 *
 * @author Stein Raymond Rudshagen
 * @version 1.0 31.januar.2017
 */

public class Truck extends FossilVehicle {
    private double usefulWeight; // kg

    public Truck (String registerNumber, double co2Emission, double usefulWeight) {
	super(registerNumber, co2Emission);	
	this.usefulWeight = usefulWeight;
    }

    @Override
    /**
     * Recieve information from both superclass and this class
     */
    public String getInformation() {
	return (super.getInformation()
		+ "\nUsefull Weight: " + this.usefulWeight) + " kg\n";
    }

    public String toString() {
	return getInformation();
    }
}
