package csc402week7examples;

import algs21.*;
import stdlib.*;
import java.util.*;

public class RunElementarySorts {
	
	public static void fillArray(Integer[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt();
		}
		
	}

	public static void main(String[] args) {
		Stopwatch timer;
		int size = 400000;
		Integer[] numbers = new Integer[size];

//		fillArray(numbers);
//		timer = new Stopwatch();
//		Selection.sort(numbers);
//		StdOut.println("Time to selection sort "+size+" integers: "+timer.elapsedTime());
//
//		fillArray(numbers);
//		timer = new Stopwatch();
//		Insertion.sort(numbers);
//		StdOut.println("Time to insertion sort "+size+" integers: "+timer.elapsedTime());

		fillArray(numbers);
		timer = new Stopwatch();
		Bubble.sort(numbers);
		StdOut.println("Time to bubble sort "+size+" integers: "+timer.elapsedTime());

	}

}
