package com.dataStructures.graph;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPathsDigraph {

	// Given a digraph G, and a source vertex s, find the paths from source vertex to other reachable vertices 
	// in G using DFS and Digraph API functions.
	private static final int INFINITY = Integer.MAX_VALUE;
	
	public boolean[] marked; 
	
	public int[] edgeTo;
	
//	public int[] distTo;
	
	private int s;
	
	public DepthFirstPathsDigraph(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		//distTo = new int[G.V()];
		this.s = s;
		GraphHelper.validateVertex(s, G.V());
		/*for(int v = 0 ; v < G.V(); v++) {
			distTo[v]=INFINITY;
		}*/
		//distTo[s]=0;
		
		//edgeTo[s]=s;
		dfs(G,s);
	}
	
	public void dfs(Digraph G, int v) {
		marked[v]=true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				//marked[w]=true;
				//distTo[w]=distTo[v]+1;
				edgeTo[w]=v;
				dfs(G,w);
			}
		}
	}
	
	public Iterable<Integer> pathTo(int v){
		GraphHelper.validateVertex(v, marked.length);
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>(); 
		int V = marked.length;
		for(int x = v ; x != s ; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
	public boolean hasPathTo(int v) {
		GraphHelper.validateVertex(v, marked.length);
		return marked[v];
	}
	
	/*  public static void main(String[] args) {
	        In in = new In(args[0]);
	        Digraph G = new Digraph(in);
	        // StdOut.println(G);

	        int s = Integer.parseInt(args[1]);
	        DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, s);

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
