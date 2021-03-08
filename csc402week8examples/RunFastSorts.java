package csc402week8examples;

import algs22.*;
import algs23.*;
import stdlib.*;
import java.util.*;

public class RunFastSorts {
	
	public static void fillArray(Integer[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
		}
		
	}

	public static void main(String[] args) {
		Stopwatch timer;
		int size = 12500000;
		Integer[] numbers = new Integer[size];

		fillArray(numbers);
		timer = new Stopwatch();
		Merge.sort(numbers);
		StdOut.println("Time to merge sort "+size+" integers: "+timer.elapsedTime());

		fillArray(numbers);
		timer = new Stopwatch();
		Quick.sort(numbers);
		StdOut.println("Time to quick sort "+size+" integers: "+timer.elapsedTime());

	}

}
