package com.dataStructures.graph;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {

	private boolean[] marked;
	
	private int[] edgeTo;
	
	private Stack<Integer> cycle;
	
	private boolean[] onStack;
	
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		 for (int v = 0; v < G.V(); v++) {
			 if (!marked[v] && cycle == null) 
				 dfs(G, v);
		 }
	}
	
	private void dfs(Digraph G, int v) {
		onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            // short circuit if directed cycle found
            if (cycle != null) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w]) {
            	 cycle = new Stack<Integer>();
                 for (int x = v; x != w; x = edgeTo[x]) {
                     cycle.push(x);
                 }
                 cycle.push(w);
                 cycle.push(v);
                 assert check();
            }
        }
        onStack[v]=false;
	}
	 private boolean check() {

	        if (hasCycle()) {
	            // verify cycle
	            int first = -1, last = -1;
	            for (int v : cycle()) {
	                if (first == -1) first = v;
	                last = v;
	            }
	            if (first != last) {
	                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
	                return false;
	            }
	        }
	        return true;
	    }

	
	public boolean hasCycle() {
		return cycle!=null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
	
	
}
