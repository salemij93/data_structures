package algs34;

import java.util.HashSet;
import stdlib.*;

public class XPhoneNumberPerformanceTest {
	private static int NUM_SIZES = 6;
	private static int START_SIZE = 25000;
	public static void main(String[] args) {
		int size = START_SIZE;
		for (int count=1; count<NUM_SIZES; count++) {
			size += size;
			HashSet<XPhoneNumber> set = new HashSet<> ();
			Stopwatch sw1 = new Stopwatch ();
			for (int i=size-1; i>=0; i--) {
				XPhoneNumber x = new XPhoneNumber
					(StdRandom.uniform (1000), StdRandom.uniform (1000), StdRandom.uniform (10000));
				set.add(x);
			}
			double time1 = sw1.elapsedTime ();
			Stopwatch sw2 = new Stopwatch ();
			for (int i=size-1; i>=0; i--) {
				XPhoneNumber x = new XPhoneNumber
					(StdRandom.uniform (1000), StdRandom.uniform (1000), StdRandom.uniform (10000));
				set.contains (x);
			}
			double time2 = sw1.elapsedTime ();
			System.out.format ("%9d: add=%f contains=%f\n", size, time1, time2);
		}
	}
}
