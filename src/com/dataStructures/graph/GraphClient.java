package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class GraphClient {

	   public static void main(String[] args) {
		   In in = new In(args[0]);
	        Digraph G = new Digraph(in);

	        DirectedCycle finder = new DirectedCycle(G);
	        if (finder.hasCycle()) {
	            StdOut.print("Directed cycle: ");
	            for (int v : finder.cycle()) {
	                StdOut.print(v + " ");
	            }
	            StdOut.println();
	        }

	        else {
	            StdOut.println("No directed cycle");
	        }
	        StdOut.println();
	    }
}
