package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class GraphClient {

	   public static void main(String[] args) {
	        In in = new In(args[0]);
	        AdjacencyListGraph G = new AdjacencyListGraph(in);
	        Cycle finder = new Cycle(G);
	        if (finder.hasCycle()) {
	            for (int v : finder.cycle()) {
	                StdOut.print(v + " ");
	            }
	            StdOut.println();
	        }
	        else {
	            StdOut.println("Graph is acyclic");
	        }
	    }
}
