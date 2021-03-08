package Csc402hw1;
import stdlib.*;
import java.util.Scanner;
public class csc402hw1a {
	/*
	 * Please enter a number!
		3.5
		Thank you! Got A 3.5
		Please enter a number!
		4.2
		Thank you! Got B 4.2
		7.7
		-0.7000000000000002
		0.8333333333333333
		192.79056951583615
	 * 
	 */
	private static Scanner scanA;
	public static void main(String[] args) {
		scanA = new Scanner(System.in);
		double numberA = 0, numberB = 0;
		int number = 0;
		do {
		    StdOut.println("Please enter a number!");
		    while (!scanA.hasNextDouble()) {
		        StdOut.println("That's not a number!");
		        scanA.next();
		    }
		    if (number == 0) {
		    	numberA = scanA.nextDouble();
		    	StdOut.println("Thank you! Got A " + numberA);
		    	++number;
		    } else {
		    	numberB = scanA.nextDouble();
			    StdOut.println("Thank you! Got B " + numberB);
			    ++number;
		    }
		} while (number <= 1);
		double sum = numberA + numberB, difference = numberA - numberB, quotient = numberA/numberB, power = Math.pow(numberA, numberB);
		StdOut.println(sum);
		StdOut.println(difference);
		StdOut.println(quotient);
		StdOut.println(power);
	}
}