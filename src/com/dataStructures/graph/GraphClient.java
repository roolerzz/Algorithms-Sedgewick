package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;

public class GraphClient {
	// Depth First Order Client.
	public static void main(String[] args) {
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		Topological topological = new Topological(G);
		System.out.println("Is Order present : " + topological.hasOrder());
		if(topological.hasOrder())
			for(int w : topological.order())
				System.out.println("-->" + w);
	}
}
