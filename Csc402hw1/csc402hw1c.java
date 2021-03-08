package Csc402hw1;
import stdlib.*;
import java.util.Scanner;
public class csc402hw1c {
	
	/*
	 * 
	 * Enter a positive GPA: 
		4.0
		3.7
		2.9
		3.5
		-1
		4.0
		14.1
		3.525

	 */
	private static Scanner scanA;
	public static void main(String[] args) {
		scanA = new Scanner(System.in);
		double n, sum = 0.0, avg = 0.0, count = 0; 
		StdOut.println("Enter a positive GPA: ");
		while (scanA.hasNextDouble() && (n = scanA.nextDouble()) >= 0.0) {
			//StdOut.println(n);
			sum = sum + n;
			++count;
		}
		avg = sum/count;
		StdOut.println(count);
		StdOut.println(sum);
		StdOut.println(avg);
	}

}
