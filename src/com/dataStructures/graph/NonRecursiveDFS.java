package com.dataStructures.graph;

import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;

public class NonRecursiveDFS {

	private boolean[] marked;
	
	public NonRecursiveDFS(AdjacencyListGraph G, int s) {
		marked = new boolean[G.V()];
		GraphHelper.validateVertex(s, marked.length);
		Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
		for(int v = 0 ; v < G.V(); v++) {
			adj[v] = G.adj(v).iterator();
		}
		// DFS using an explicit stack instead of recursion.
		Stack<Integer> stack = new Stack<Integer>();
		marked[s]= true;
		stack.push(s);
		while (!stack.isEmpty()) {
			int v = stack.peek();
			if(adj[v].hasNext()) {
				int w = adj[v].next();
				if(!marked[w]) {
					marked[w]=true;
					stack.push(w);
				}
			}
			else {
				stack.pop();
			}
		}
	}
	
	public boolean marked(int v) {
		GraphHelper.validateVertex(v, marked.length);
		return marked[v];
	}
	
}
