package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphClient {

	// DepthFirstPathsDigraph Client
	  public static void main(String[] args) {
	        In in = new In(args[0]);
	        Digraph G = new Digraph(in);
	        // StdOut.println(G);

	        int s = Integer.parseInt(args[1]);
	        DepthFirstPathsDigraph dfs = new DepthFirstPathsDigraph(G, s);

	        for (int v = 0; v < G.V(); v++) {
	            if (dfs.hasPathTo(v)) {
	                StdOut.printf("%d to %d:  ", s, v);
	                for (int x : dfs.pathTo(v)) {
	                    if (x == s) StdOut.print(x);
	                    else        StdOut.print("-" + x);
	                }
	                StdOut.println();
	            }

	            else {
	                StdOut.printf("%d to %d:  not connected\n", s, v);
	            }

	        }
	    }
}
