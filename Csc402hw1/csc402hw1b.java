package Csc402hw1;
import stdlib.*;
import java.util.Scanner;
public class csc402hw1b {
	/*
	 * 
	 * Enter a positive integer: 
		8
		4
		2
		1
		3
		3.0
		
		Enter a positive integer: 
		2
		1
		1
		1.0
		
		Enter a positive integer: 
		19
		9
		4
		2
		1
		4
		4.247927513443585
		
	 */
	private static Scanner scanA;
	public static void main(String[] args) {
		scanA = new Scanner(System.in);
		int n; 
		StdOut.println("Enter a positive integer: ");
		while (!scanA.hasNextInt() || (n = scanA.nextInt()) <= 0) {
				StdOut.println("That's not a positive integer!");
		        scanA.nextLine();
		}
		double a = n;
		a = Math.log(a)/Math.log(2.0);
		int count = 0;
		do {
			++count; 
			n = n/2;
			StdOut.println(n);
		} while (n > 1);
		StdOut.println(count);
		StdOut.println(a);
	}
}
