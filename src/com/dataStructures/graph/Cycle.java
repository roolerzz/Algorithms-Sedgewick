package com.dataStructures.graph;

import edu.princeton.cs.algs4.Stack;

public class Cycle {

	private boolean[] marked; 
	
	private int[] edgeTo;
	
	private Stack<Integer> cycle;
	
	public Cycle(AdjacencyListGraph G) {
		// check if graph has self loops or parallel edges.
		if(hasSelfLoops(G)) return;
		if(hasParallelEdges(G)) return;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int v = 0; v < G.V() ; v++) {
			if(!marked[v])
				dfs(G,v,-1);
		}
	}
	
	public boolean hasCycle() {
		return null!=cycle;
	}
	
    public Iterable<Integer> cycle() {
        return cycle;
    }
	
	private void dfs(AdjacencyListGraph G, int v, int u) {
		marked[v] = true;
		// Short circuiting the recursion if cycle is already present.
		for(int w : G.adj(v)) {
			if(cycle!=null) return;
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G,w,v);
			}
			else if(w!=u) {
				/*cycle = new Stack<Integer>();
				for(int x= v ; x != w ; x = edgeTo[x] )
				{
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);*/
				cycle = new Stack<Integer>();
				cycle.push(w);
				for(int x= v ; x != w ; x = edgeTo[x] )
				{
					cycle.push(x);
				}
				
				cycle.push(w);
			}
		}
	}
	
	private boolean hasSelfLoops(AdjacencyListGraph G) {
		for(int v = 0 ; v < G.V(); v++) {
			for(int w : G.adj(v)) {
				if (w == v) {
					cycle = new Stack<Integer>();
					cycle.push(v);
					cycle.push(v);
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasParallelEdges(AdjacencyListGraph G) {
	    marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            // check for parallel edges incident to v
            for (int w : G.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }
            // reset so marked[v] = false for all v
            for (int w : G.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
	}

	/*   public static void main(String[] args) {
	        In in = new In(args[0]);
	        Graph G = new Graph(in);
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
	    }*/
	
}
