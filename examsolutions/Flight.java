package examsolutions;

import java.util.Comparator;

public class Flight implements Comparable<Flight>{
	
	private String airlineName;
	private Integer airlineNumber;
	private String origin;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	public static final Comparator<Flight> departureAirport = new DepartureAirport();
	public static final Comparator<Flight> arrivalAirport = new ArrivalAirport();
	
	public Flight(String airlineName, Integer airlineNumber, String origin, String destination, String departureTime, String arrivalTime) {
		
		this.airlineName = airlineName;
		this.airlineNumber = airlineNumber;
		this.arrivalTime = arrivalTime;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		
		}
	
	public String airlineName() { return airlineName;}
	public Integer airlineNumber() { return airlineNumber;}
	public String origin() { return origin;}
	public String destination() {return destination;}
	public String departureTime() { return departureTime;}
	public String arrivalTime() { return arrivalTime;}
	
	public String toString() {
		return "[" + airlineName + ", " + airlineNumber + ", " + origin + ", " + destination + ", " + departureTime + ", " + arrivalTime + "]" ;
	}
	
	public int compareTo(Flight that) {
		String a = that.airlineName + that.airlineNumber;
		String b = this.airlineName + this.airlineNumber;
		return b.compareTo(a);
	}
	
	private static class DepartureAirport implements Comparator<Flight> {
		public int compare(Flight f1, Flight f2) {
			return f1.origin.compareTo(f2.origin);
		}
	}
	
	private static class ArrivalAirport implements Comparator<Flight> {
		public int compare(Flight f1, Flight f2) {
			return f1.destination.compareTo(f2.destination);
		}
	}

}
