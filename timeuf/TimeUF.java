package timeuf;

import stdlib.*;
import algs15.*;

/*
 * I needed to change CompressionUF.java and WeightedUF.java because they used 
 * GraphViz which would create so many images that my computer would crash 
 * 
 */


public class TimeUF {

	public static void main(String[] args) {
		Stopwatch timer;
		String dataFile = "data/uf16k.txt";
		
		StdOut.println("------ Runtime for UF implementations ------");
		StdIn.fromFile(dataFile);
		timer = new Stopwatch();
		QuickFindUF quickFindUF = new QuickFindUF(StdIn.readInt());
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			quickFindUF.union(p, q);
		}
		StdOut.println("QuickFindUF runs in "+ timer.elapsedTime() + " seconds");
		
		StdIn.fromFile(dataFile);
		timer = new Stopwatch();
		QuickUnionUF quickUnionUF = new QuickUnionUF(StdIn.readInt());
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			quickUnionUF.union(p, q);
		}
		StdOut.println("QuickUnionUF runs in "+ timer.elapsedTime() + " seconds");
		
		StdIn.fromFile(dataFile);
		timer = new Stopwatch();
		CompressionUF compressionUF = new CompressionUF(StdIn.readInt());
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			compressionUF.union(p, q);
		}
		StdOut.println("CompressionUF runs in "+ timer.elapsedTime() + " seconds");
		
		
		StdIn.fromFile(dataFile);
		timer = new Stopwatch();
		WeightedUF weightedUF = new WeightedUF(StdIn.readInt());
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			weightedUF.union(p, q);
		}
		StdOut.println("WeightedUF runs in "+ timer.elapsedTime() + " seconds");
		
		
		
	}

}
