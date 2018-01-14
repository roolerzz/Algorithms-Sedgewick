package com.dataStructures.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths {

	private boolean[] marked;
	
	private int[] edgeTo;
	
	private int[] distTo;
	
	private static final int INFINITY = Integer.MAX_VALUE;
	
	public BreadthFirstPaths(AdjacencyListGraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo  = new int[G.V()];
		distTo = new int[G.V()];
		validateVertex(s);
		bfs(G,s);
	}
	
	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}
	
	private void bfs(AdjacencyListGraph G, int s) {
		Queue<Integer> queue = new Queue<>();
		
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		queue.enqueue(s);
		distTo[s] = 0;
		marked[s] = true;
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
					distTo[w] = distTo[v]+1;
				}
			}
		}
	}
	
	private void validateVertex(int v) {
		int V = marked.length;
		if(v<0 || v>V) throw new IllegalArgumentException("Vertex " + v + " is not b/w 0 and " + (V-1));
	}
	
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		validateVertex(v);
		if(!hasPathTo(v))return null;
		int x ;
		Stack<Integer> path = new Stack<Integer>();
		for(x = v ; distTo[x] !=0 ; x = edgeTo[x])
			path.push(x);
		path.push(x);
		return path;
	}
}
