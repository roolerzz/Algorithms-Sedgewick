package com.dataStructures.graph;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Digraph {
	// number of edges in the directed graph
	private int E;
	// number of vertices in graph;
	private final int V;
	
	private Bag<Integer>[] adj;
	
	private int[] indegree;
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public Digraph(int V) {
		if(V<0) throw new IllegalArgumentException("Number of vertices in a diagraph must be non-negative.");
		this.V=V;
		this.E=0;
		indegree = new int[V];
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0 ; v < V ; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	public Digraph(In in) {
		try {
			this.V = in.readInt();
			if (V < 0)
				throw new IllegalArgumentException("Number of vertices in a diagraph must be non-negative.");
			indegree = new int[V];
			adj = (Bag<Integer>[]) new Bag[V];
			for (int v = 0; v < V; v++) {
				adj[v] = new Bag<Integer>();
			}
			int E = in.readInt();
			if (E < 0)
				throw new IllegalArgumentException("Number of edges in a diagraph must be non negative.");
			for (int i = 0; i < E; i++) {
				int v = in.readInt();
				int w = in.readInt();
				addEdge(v, w);
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("Invalid input format in diagraph constructor", e);
		}
	}
	
	// Creates a deep copy of the specified diagraph. Make sure to keep the order same in the bag.
	public Digraph(Digraph G) {
		this(G.V());
		this.E = G.E();
		for(int v = 0; v < V; v++) {
			this.indegree[v]=G.indegree(v);
		}
		
		for(int v = 0; v<V; v++) {
			Stack<Integer> reverse = new Stack<Integer>();
			for(int w : G.adj(v))
				reverse.push(w);
			for(int w : reverse) {
				adj[v].add(w);
			}
		}
	}

	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}
	
	// adds a directed edge from v->w
	void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}
	
	Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
	private int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	private void validateVertex(int v) {
		if(v<0 || v >= V) throw new IllegalArgumentException("Vertex : " + v + " is not b/w 0 and " + (V-1));
	}
	
	int V() {return V;}
	
	int E() {return E;}
	
	public Digraph reverse() {
		Digraph rev = new Digraph(V);
		for (int v = 0; v < V ; v++) {
			for (int w : adj(v)) {
				rev.addEdge(w, v);
			}
		}
		return rev;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices and " + E + " edges" + NEWLINE);
		for(int v = 0 ; v < V ; v++) {
			sb.append(v + " : ");
			for(int w : adj(v)) {
				sb.append(w + " ");
			}
			sb.append(NEWLINE);
		}
		return sb.toString();
		
	}

}

/*public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph G = new Digraph(in);
    StdOut.println(G);
}*/