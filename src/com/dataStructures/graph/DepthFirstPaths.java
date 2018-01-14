package com.dataStructures.graph;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {

	private boolean[] marked;

	private int[] edgeTo; 

	private final int s;

	public DepthFirstPaths(AdjacencyListGraph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		validateVertex(s);
		dfs(G,s);
	}

	private void dfs(AdjacencyListGraph G, int v) {
		marked[v]=true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v){
		validateVertex(v);
		if(!hasPathTo(v))return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v ; x != s ; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	private void validateVertex(int v) {
		int V = marked.length;
		if(v<0 || v>V) throw new IllegalArgumentException("Vertex : " + v + " is not b/w 0 and " + (V-1));
	}
	 
	/*public static void main(String[] args) {
	        In in = new In(args[0]);
	        AdjacencyListGraph G = new AdjacencyListGraph(in);
	        int s = Integer.parseInt(args[1]);
	        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

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
	    }*/

}
