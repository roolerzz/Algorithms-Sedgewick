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
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		validateVertex(s);
		bfs(G,s);
	}
	
	private void bfs(AdjacencyListGraph G, int s) {
		Queue<Integer> queue = new Queue<>();
		marked[s] = true;
		distTo[s] = 0;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					distTo[w] = distTo[v]+1;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public BreadthFirstPaths(AdjacencyListGraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		edgeTo  = new int[G.V()];
		distTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		GraphHelper.validateVertices(sources,marked.length);
		bfs(G,sources);
	}
	private void bfs(AdjacencyListGraph G, Iterable<Integer> sources) {
		Queue<Integer> queue = new Queue<>();
		for(int s : sources) {
			marked[s] = true;
			distTo[s] = 0;
			queue.enqueue(s);	
		}
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					distTo[w] = distTo[v]+1;
					queue.enqueue(w);
				}
			}
		}
	}

	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}
	
	private void validateVertex(int v) {
		int V = marked.length;
		if(v<0 || v>=V) throw new IllegalArgumentException("Vertex " + v + " is not b/w 0 and " + (V-1));
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
