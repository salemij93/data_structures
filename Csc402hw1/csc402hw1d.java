package Csc402hw1;
import stdlib.*;
import java.util.Scanner;
public class csc402hw1d {
	
	/*
	 * 
	 * Please enter a number!
		9
		1
		1.0
		3
		3.0
		6
		6.0
		10
		10.0
		15
		15.0
		21
		21.0
		28
		28.0
		36
		36.0
		45
		45.0
	 */
	private static Scanner scanA;
	public static void main(String[] args) {
		scanA = new Scanner(System.in);
		int number = 0;
		StdOut.println("Please enter a number!");
	    while (!scanA.hasNextInt()) {
	        StdOut.println("That's not a number!");
	        scanA.next();
	    }
	    number = scanA.nextInt();
	    if (number > 0) {
			for (int i=1; i<= number;i++) {
				int sum = sumInts(i);
				double value = (i+1)*i/2; 
				StdOut.println(sum);
				StdOut.println(value);
			}
		} else if (number < 0 ) {
			for (int i=1; i >= number;i--) {
				int sum = sumInts(i);
				double value = (i+1)*i/2;
				StdOut.println(sum);
				StdOut.println(value);
			}
		} else {
			StdOut.println(number);
		}
	    
	}
	
	public static int sumInts(int N ) {
		int sum = 0;
		if (N > 0) {
			for (int i=1; i<= N;i++) {
				sum = sum + i;
			}
		} else if (N < 0 ) {
			for (int i=1; i >= N;i--) {
				sum = sum + i;
			}
		} else {
			sum = 0;
		}
		return sum;
	}

}
