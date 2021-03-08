package examsolutions;

import stdlib.*;
import java.util.*;

import examsolutions.Flight;


public class ListFlights {

	public static void main(String[] args) {
		
		StdIn.fromFile("data/flightdata.txt");
		ArrayList<Flight> allFlights = new ArrayList<>();
		
		while(!StdIn.isEmpty()) {
			
			String line = StdIn.readLine();
			String[] fields = line.split("\\s+");
			
			String airlineName = fields[0];
			Integer airlineNumber = Integer.parseInt(fields[1]);
			String origin = fields[2];
			String destination = fields[3];
			String departureTime = fields[4];
			String arrivalTime = fields[5];
			allFlights.add(new Flight(airlineName, airlineNumber, origin, destination, departureTime, arrivalTime));
			
		}
		
		Collections.sort(allFlights);
		StdOut.println("Flights ordered by name:");
		for(Flight newflight: allFlights) {
			StdOut.println(newflight);
		}
		StdOut.println();
		
		Collections.sort(allFlights, Flight.departureAirport);
		StdOut.println("Flights ordered by departure airport:");
		for(Flight newflight: allFlights) {
			StdOut.println(newflight);
		}
		StdOut.println();
		
		Collections.sort(allFlights, Flight.arrivalAirport);
		StdOut.println("Flights ordered by arrival airport:");
		for(Flight newflight: allFlights) {
			StdOut.println(newflight);
		}
		StdOut.println();
	}

}
