package algs63; // section 6.3
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Manber.java
 *  Execution:    java Manber < text.txt
 *  Dependencies: In.java
 *
 *  Reads a text corpus from stdin and suffix sorts it in subquadratic
 *  time using a variant of XManber's algorithm.
 *
 *  NOTE: I THINK THIS IS CYCLIC SUFFIX SORTING
 *
 *************************************************************************/

public class XManber {
	private final int N;               // length of input string
	private final String text;         // input text
	private final int[] index;         // offset of ith string in order
	private final int[] rank;          // rank of ith string
	private final int[] newrank;       // rank of ith string (temporary)
	private int offset;

	public XManber(String s) {
		N    = s.length();
		text = s;
		index   = new int[N+1];
		rank    = new int[N+1];
		newrank = new int[N+1];

		// sentinels
		index[N] = N;
		rank[N] = -1;

		msd();
		doit();
	}

	// do one pass of msd sorting by rank at given offset
	private void doit() {
		for (offset = 1; offset < N; offset += offset) {
			StdOut.println("offset = " + offset);

			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (rank[index[i]] == rank[index[i-1]]) count++;
				else if (count > 0) {
					// sort
					int left = i-1-count;
					int right = i-1;
					quicksort(left, right);

					// now fix up ranks
					int r = rank[index[left]];
					for (int j = left + 1; j <= right; j++) {
						if (less(index[j-1], index[j]))  {
							r = rank[index[left]] + j - left;
						}
						newrank[index[j]] = r;
					}

					// copy back - note can't update rank too eagerly
					for (int j = left + 1; j <= right; j++) {
						rank[index[j]] = newrank[index[j]];
					}

					count = 0;
				}
			}
		}
	}

	// sort by leading char, assumes extended ASCII (256 values)
	private void msd() {
		// calculate frequencies
		int[] freq = new int[256];
		for (int i = 0; i < N; i++)
			freq[text.charAt(i)]++;

		// calculate cumulative frequencies
		int[] cumm = new int[256];
		for (int i = 1; i < 256; i++)
			cumm[i] = cumm[i-1] + freq[i-1];

		// compute ranks
		for (int i = 0; i < N; i++)
			rank[i] = cumm[text.charAt(i)];

		// sort by first char
		for (int i = 0; i < N; i++)
			index[cumm[text.charAt(i)]++] = i;
	}


	// for debugging
	public void show() {
		String texttext = text + text;  // make cyclic
		StdOut.println("j, rank[index[j]], index[j]");
		for (int i = 0; i < N; i++) {
			String s = texttext.substring(index[i], index[i] +  Math.min(40, N));
			StdOut.println(s + " " + i + " " + rank[index[i]] + " " + index[i]);
		}
		StdOut.println();
	}


	// test client
	public static void main(String[] args) {
		String s = StdIn.readAll();
		XManber m = new XManber(s);
		m.show();
	}


	/* ********************************************************************
	 *  Helper functions for comparing suffixes.
	 **********************************************************************/

	/* ********************************************************************
	 * Is the substring text[v..N] lexicographically less than the
	 * substring text[w..N] ?
	 **********************************************************************/
	private boolean less(int v, int w) {
		if (v + offset >= N) v -= N;
		if (w + offset >= N) w -= N;
		return rank[v + offset] < rank[w + offset];
	}



	/* ***********************************************************************
	 *  Quicksort code from Sedgewick 7.1, 7.2.
	 *************************************************************************/

	// swap pointer sort indices
	private void exch(int i, int j) {
		int swap = index[i];
		index[i] = index[j];
		index[j] = swap;
	}


	// SUGGEST REPLACING WITH 3-WAY QUICKSORT SINCE ELEMENTS ARE
	// RANKS AND THERE MAY BE DUPLICATES
	void quicksort(int l, int r) {
		if (r <= l) return;
		int i = partition(l, r);
		quicksort(l, i-1);
		quicksort(i+1, r);
	}

	int partition(int l, int r) {
		int i = l-1, j = r;
		int v = index[r];

		while (true) {

			// find item on left to swap
			while (less(index[++i], v))
				;

			// find item on right to swap
			while (less(v, index[--j]))
				if (j == l) break;

			// check if pointers cross
			if (i >= j) break;

			exch(i, j);
		}

		// swap with partition element
		exch(i, r);

		return i;
	}
}
