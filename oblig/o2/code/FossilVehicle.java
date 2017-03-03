/** This class is a subclass of vehicle and manage two sublcasses of FossilVehicle
 * 
 *@author Stein Raymond Rudshagen
 *@version 1.0 10. Februar 2017
 */

public class FossilVehicle extends Vehicle {
    private double co2Emission; // g/km
    
    public FossilVehicle (String registerNumber, double co2Emission) {
	super(registerNumber);
	
	this.co2Emission = co2Emission;
    }

    @Override
    /**
     * Recieve information from both superclass and this class
     */
    public String getInformation() {
	return(super.getInformation()
	       + "\nCO2 emission: " + this.co2Emission + " g/km");
    }
    
    public String toString() {
	return getInformation();
    }
    
}
