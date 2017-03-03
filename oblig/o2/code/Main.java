
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
	// Create array list of vehicles.
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	// Read and scan input files.
	File inputfile = new File(args[0]);
	Scanner in = new Scanner(inputfile);

	// check if user requires output type
	String input = " ";
	if (args.length > 1 && args.length < 3) {
	    input = args[1];
	}

	while(in.hasNextLine()) {
	    String line = in.nextLine();
	    String[] words = line.split(" ");

	    // check if line contains "PERSONBIL"
	    if (line.contains("PERSONBIL")) {	
		Vehicle vehicle = new PassengerCar(words[1], Double.parseDouble(words[2]), Integer.parseInt(words[3]));
		vehicles.add(vehicle);
	    }
	    // check if line contains "LASTEBIL"	    
	    else if (line.contains("LASTEBIL")) {	
		Vehicle vehicle = new Truck(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]));
		vehicles.add(vehicle);
	    }
	    // if none of those above
	    else {
		Vehicle vehicle = new ElectricVehicle(words[1], Double.parseDouble(words[2]));
		vehicles.add(vehicle);
		
	    }
	}

	// Prints out type vehicle on terminal:
	for (int i = 0; i < vehicles.size(); i++) {
	    // check if vheicles.get(i) is connected to FossilVehicle class, and if an input argument is equals to FOSSIL
	    if (vehicles.get(i) instanceof FossilVehicle && input.equals("FOSSIL")) {
		System.out.print(vehicles.get(i));
	    }
	    // check if vheicles.get(i) is connected to ElectricVehicle and if an input argument is equals to EL	    
	    else if (vehicles.get(i) instanceof ElectricVehicle && input.equals("EL")) {
		System.out.print(vehicles.get(i));
	    }
	    else if (input.equals(" ")) {
		System.out.print(vehicles.get(i));
	    }
	}
    }
}
