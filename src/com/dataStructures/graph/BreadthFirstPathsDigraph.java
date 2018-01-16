package com.dataStructures.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPathsDigraph {

	private static final String NEWLINE = System.getProperty("line.separator");
	
	private static final int INFINITY = Integer.MAX_VALUE;
	
	private boolean marked[];
	
	private int[] edgeTo;
	
	private int[] distTo;
	
	//private int s;
	
	public BreadthFirstPathsDigraph(Digraph G, int s) {
		GraphHelper.validateVertex(s, G.V());
		//this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for(int v = 0 ; v < G.V(); v++) {
			distTo[v] = INFINITY;
		}
		bfs(G,s);
		
	}
	
	
	
	private void bfs(Digraph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		distTo[s] = 0;
		marked[s]=true;
		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}
	
	public BreadthFirstPathsDigraph(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for(int v = 0 ; v < G.V(); v++) {
			distTo[v] = INFINITY;
		}
		GraphHelper.validateVertices(sources,marked.length);
		bfs(G,sources);
	}

	private void bfs(Digraph G, Iterable<Integer> sources) {
		Queue<Integer> q = new Queue<Integer>();
		for (int s : sources) {
			marked[s] = true;
			distTo[s] = 0;
			q.enqueue(s);
		}

		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		GraphHelper.validateVertex(v, marked.length);
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		GraphHelper.validateVertex(v, marked.length);
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for(x = v ; distTo[x]!=0 ; x= edgeTo[x]) {
			path.push(x);
		}
		path.push(x);
		return path;
	}
	
	public int distTo(int v) {
		GraphHelper.validateVertex(v, marked.length);
		return distTo[v];
	}
	
	/* public static void main(String[] args) {
	        In in = new In(args[0]);
	        Digraph G = new Digraph(in);
	        // StdOut.println(G);

	        int s = Integer.parseInt(args[1]);
	        BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G, s);

	        for (int v = 0; v < G.V(); v++) {
	            if (bfs.hasPathTo(v)) {
	                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
	                for (int x : bfs.pathTo(v)) {
	                    if (x == s) StdOut.print(x);
	                    else        StdOut.print("->" + x);
	                }
	                StdOut.println();
	            }

	            else {
	                StdOut.printf("%d to %d (-):  not connected\n", s, v);
	            }

	        }
	    }*/
}
