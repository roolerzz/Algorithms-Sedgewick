package com.dataStructures.graph;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class AdjacencyListGraph {

	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V;
	
	private int E;
	
	private Bag<Integer>[]  adj;
	
	public AdjacencyListGraph(int V) {
		if(V<0) throw new IllegalArgumentException("Number of vertices as an arg to constructor must be non-negative.");
		this.V=V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v=0; v < V; v++)
			adj[v]= new Bag<Integer>();
	}
	
	public AdjacencyListGraph(In in) {
		try {
			this.V=in.readInt();
			if(V<0) throw new IllegalArgumentException("Number of vertices must be non negative.");
			adj = (Bag<Integer>[]) new Bag[V];
			for(int v = 0; v < V ; v++) 
				adj[v] = new Bag<Integer>();
			int E = in.readInt();
			if(E<0) throw new IllegalArgumentException("Number of edges must be non negative.");
			for(int e=0; e < E ; e++) {
				int v = in.readInt();
				int w = in.readInt();
				validateVertex(v);
				validateVertex(w);
				addEdge(v,w);
			}
		}
		catch(NoSuchElementException e) {
			throw new IllegalArgumentException("Invalid input format in graph constructor",e);
		}
	}
	
	public int E() {
		return E;
	}
	
	public int V() {
		return V;
	}
	
	private void validateVertex(int v) {
		if(v<0 || v>=V)
			throw new IllegalArgumentException("Vertex : " + v + " is not between 0 and " + (V-1) );
	}
	
	// created a deep copy of graph G.
	public AdjacencyListGraph(AdjacencyListGraph G) {
		this(G.V());
		this.E=G.E();
		// preservers the order of the elements in the adjacency list.
		Stack<Integer> reverse = new Stack<Integer>();
		for(int v =0; v<G.V ; v++) {
			for(int w : G.adj(v)) 
				reverse.push(w);
			for(int w : reverse)
				adj[v].add(w);
		}
	}
	

	public void addEdge(int v,int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	// return the vertices adjacent to v
	public Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices," + E + " edges "+ NEWLINE);
		for(int v = 0; v < V ; v++) {
			for(int w : adj(v)) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
}
