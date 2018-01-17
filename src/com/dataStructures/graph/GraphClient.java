package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphClient {
	// Depth First Order Client.
	public static void main(String[] args) {
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		DepthFirstOrder dfs = new DepthFirstOrder(G);
		StdOut.println("   v  pre post");
		StdOut.println("--------------");
		for (int v = 0; v < G.V(); v++) {
			StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
		}
		StdOut.print("Preorder:  ");
		for (int v : dfs.preOrder()) {
			StdOut.print(v + " ");
		}
		StdOut.println();
		StdOut.print("Postorder: ");
		for (int v : dfs.postOrder()) {
			StdOut.print(v + " ");
		}
		StdOut.println();
		StdOut.print("Reverse postorder: ");
		for (int v : dfs.reversePostOrder()) {
			StdOut.print(v + " ");
		}
		StdOut.println();
	}
}
