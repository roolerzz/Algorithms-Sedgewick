package com.dataStructures.graph;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class GraphClient {

	// Bipartite Client
	  public static void main(String[] args) {
	        int V1 = Integer.parseInt(args[0]);
	        int V2 = Integer.parseInt(args[1]);
	        int E  = Integer.parseInt(args[2]);
	        int F  = Integer.parseInt(args[3]);

	        // create random bipartite graph with V1 vertices on left side,
	        // V2 vertices on right side, and E edges; then add F random edges
	        AdjacencyListGraph G = GraphGenerator.bipartite(V1, V2, E);
	        for (int i = 0; i < F; i++) {
	            int v = StdRandom.uniform(V1 + V2);
	            int w = StdRandom.uniform(V1 + V2);
	            G.addEdge(v, w);
	        }

	        /*StdOut.println(G);*/


	        BipartiteUndirected b = new BipartiteUndirected(G);
	        if (b.isBipartite()) {
	            StdOut.println("Graph is bipartite");
	            for (int v = 0; v < G.V(); v++) {
	                StdOut.println(v + ": " + b.color(v));
	            }
	        }
	        else {
	            StdOut.print("Graph has an odd-length cycle: ");
	            for (int x : b.oddCycle()) {
	                StdOut.print(x + " ");
	            }
	            StdOut.println();
	        }
	    }
}
