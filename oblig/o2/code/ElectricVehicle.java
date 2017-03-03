/** This class is a subclass of vehicle and manage two sublcasses of ElectricVehicle
 * 
 *@author Stein Raymond Rudshagen
 *@version 1.0 10. Februar 2017
 */

public class ElectricVehicle extends Vehicle {
    private double batteriPower;

    public ElectricVehicle (String registerNumber, double batteriPower) {
	super(registerNumber);
	
	this.batteriPower = batteriPower;
    }

    @Override
    /**
     * Recieve information from both superclass and this class
     */
    public String getInformation() {
	return(super.getInformation()
	       + "\nBatteri Power: " + this.batteriPower + " kWh\n");
    }

    public String toString() {
	return getInformation();
    }
    
}
