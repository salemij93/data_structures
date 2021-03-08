package Hello;
import stdlib.*;
import java.util.Scanner;
public class Hello {
private static Scanner scanA;
/*
 * java garbage
 * BY Me
 */
	public static void main(String[] args) {
		scanA = new Scanner(System.in);
		double numberA = 0;
		double numberB = 0;
		double sum;
		double difference;
		double quotient;
		double power;
		int number = 0;
		do {
		    StdOut.println("Please enter a number!");
		    while (!scanA.hasNextDouble()) {
		        System.out.println("That's not a number!");
		        scanA.next(); // this is important!
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
		sum = numberA + numberB;
		difference = numberA - numberB;
		quotient = numberA/numberB;
		power = Math.pow(numberA, numberB);
		StdOut.println(sum);
		StdOut.println(difference);
		StdOut.println(quotient);
		StdOut.println(power);

	}
}
