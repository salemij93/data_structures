package algs21;
import stdlib.*;
import java.util.*;
public class TestSelection {

	public static void main(String[] args) {
		Integer[] a = new Integer[30000];
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt();
		}
		Stopwatch timer = new Stopwatch();
		Selection.sort(a);
		StdOut.println("Sorting took " + timer.elapsedTime());
	}

}
