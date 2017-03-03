/** This class is a subclass of vehicle and FossilVehicle, which manage information on passanger cars.
 *
 *@author Stein Raymond Rudshagen
 *@version 1.0 10. Februar 2017
 */

public class PassengerCar extends FossilVehicle {
    private int seats;

    public PassengerCar(String registerNumber, double co2Emission, int seats) {
	super(registerNumber, co2Emission);

	this.seats = seats;
    }

    @Override
    /**
     * Recieve information from both superclass and this class
     */
    public String getInformation() {
	return (super.getInformation()
		+ "\nSeats: " + this.seats + "\n");
    }

    public String toString() {
	return getInformation();
    }
}
