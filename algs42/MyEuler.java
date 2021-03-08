package algs42;

import java.util.Iterator;
import java.util.LinkedList;
import algs13.Queue;
import stdlib.*;


/*
 * From Exercise 4.2.28 Directed Eulerian cycle. 
 * 
 * A directed Eulerian cycle is a directed cycle that contains each edge exactly once. 
 * Write a digraph client call MyEuler that finds a directed Eulerian cycle or reports 
 * that no such cycle exists.  You should return a Queue from the tour function.
 * 
 * Hint : Prove that a digraph G has a directed Eulerian cycle if and only if G is 
 * connected and each vertex has its indegree equal to its outdegree. 
 *
 * Implement the parts that say TODO.
 * 
 */

public class MyEuler {
	// local copy of the graph
	private Queue<Integer>[] adj;
	private int E;
	private boolean isEulerian = false;
	private Queue<Integer> tour = new Queue<> ();

	@SuppressWarnings("unchecked")
	public MyEuler(Digraph G) {
		// create local copy of graph
		adj = new Queue[G.V()];
		for (int v = 0; v < G.V(); v++) {
			adj[v] = new Queue<>();
			for (int w : G.adj(v))
				adj[v].enqueue(w);
		}
		// get initial number of edges
		E = G.E ();
		if (E == 0) {
			isEulerian = true;
			return;
		}
		// find starting vertex with at least one edge
		int s = 0;
		while (adj[s].isEmpty ()) 
			s++;
			
		if (new KosarajuSharirSCC(G).count () == 1) {
			isEulerian = true;
//			for(int i=0; i < G.V(); i++) {
//				tour.enqueue(i);
//			}
		}
		
		
		
	}
	public Iterable<Integer> tour() {
		if (isEulerian) {
			return tour; 
		}
		return null;
	}
	public boolean isEulerian() {
		return isEulerian;
	}

	public static boolean isTour(Digraph G, Iterable<Integer> tour) {
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] adj = new LinkedList[G.V()];
		int E = G.E ();
		for (int v = 0; v < G.V(); v++) {
			adj[v] = new LinkedList<>();
			for (int w : G.adj(v))
				adj[v].add(w);
		}
		if (tour == null)
			return E == 0;
		Iterator<Integer> it = tour.iterator ();
		if (!it.hasNext())
			return E == 0;
		int s = it.next();
		int v = s;
		while (it.hasNext()) {
			int w = it.next();
			if (adj[v].contains(w)) {
				adj[v].remove((Integer) w);
				E--;
				v = w;
			} else {
				throw new Error();
			}
		}
		if (v != s) throw new Error();
		if (E != 0) throw new Error();
		return (v == s) && (E == 0);
	}

	public static Digraph inOutEqual (int V, int E) {
		// random graph of V vertices and approximately E edges
		// with indegree[v] = outdegree[v] for all vertices
		Digraph G = new Digraph(V);
		int[] indegree  = new int[V];
		int[] outdegree = new int[V];
		int deficit = 0;
		for (int i = 0; i < E - deficit/2; i++) {
			int v = StdRandom.uniform(V);
			int w = StdRandom.uniform(V);
			if (v == w) { i--; continue; }
			G.addEdge(v, w);
			if (outdegree[v] >= indegree[v]) deficit++;
			else                             deficit--;
			outdegree[v]++;
			if (indegree[w] >= outdegree[w]) deficit++;
			else                             deficit--;
			indegree[w]++;
		}
		while (deficit > 0) {
			int v = StdRandom.uniform(V);
			int w = StdRandom.uniform(V);
			if (v == w) continue;
			if (outdegree[v] >= indegree[v]) continue;
			if (indegree[w]  >= outdegree[w]) continue;
			G.addEdge(v, w);
			if (outdegree[v] >= indegree[v]) deficit++;
			else                             deficit--;
			outdegree[v]++;
			if (indegree[w] >= outdegree[w]) deficit++;
			else                             deficit--;
			indegree[w]++;
		}
		return G;
	}
	public static void main(String[] args) {
		//args = new String[] { "data/tinyDG.txt" }; // NO
		//args = new String[] { "data/tinyCG.txt" }; // NO
		//args = new String[] { "data/tinyDGeuler9.txt" }; // YES
		//args = new String[] { "data/tinyDGeuler2.txt" }; // YES
		//args = new String[] { "data/tinyDGeuler3.txt" }; // YES
		//args = new String[] { "data/tinyDGeuler4.txt" }; // YES
		//args = new String[] { "data/tinyDGeuler5.txt" }; // NO
		//args = new String[] { "data/tinyDGeuler6.txt" }; // YES
		//args = new String[] { "data/tinyDGeuler7.txt" }; // NO
		args = new String[] { "data/tinyDGeuler8.txt" }; // YES
		//args = new String[] { "data/tinyDGeuler9.txt" }; // YES
		//args = new String[] { "20", "40" };

		Digraph G;
		if (args.length == 1) {
			In in = new In(args[0]);
			G = DigraphGenerator.fromIn(in);
		} else {
			int V = Integer.parseInt(args[0]);
			int E = Integer.parseInt(args[1]);
			while (true) {
				G = inOutEqual(V,E);
				if (new KosarajuSharirSCC(G).count () == 1)
					break;
			}
		}
		StdOut.println(G);
		MyEuler euler0 = new MyEuler(G);
		if (euler0.isEulerian()) {
			for (int v : euler0.tour())
				StdOut.print(v + " ");
			StdOut.println();
		} else {
			StdOut.println("Not eulerian");
		}
		if (!isTour(G,euler0.tour())) StdOut.println("Not a tour");
		MyEuler euler1 = new MyEuler(G);
		if (euler1.isEulerian()) {
			for (int v : euler1.tour())
				StdOut.print(v + " ");
			StdOut.println();
		} else {
			StdOut.println("Not eulerian");
		}
		if (!isTour(G,euler1.tour())) StdOut.println("Not a tour");
	}
}
