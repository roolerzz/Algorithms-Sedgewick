package com.dataStructures.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

// Allows self loops and parallel edges.
public class EdgeWeightedDigraph {

	private final int V;
	
	private int E;
	
	private Bag<DirectedEdge>[] adj;
	
	private Queue<DirectedEdge> edges;
	
	// initializes an empty edgeweighteddigraph with internal adjacency list data structure empty-initialized.
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		for(int v = 0 ; v < V ; v++) {
			adj[v]= new Bag<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDigraph(In in) {
		this.V = in.readInt();
		this.E = in.readInt();
		while(in.hasNextLine()) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			DirectedEdge e = new DirectedEdge(v,w,weight);
			addEdge(e);
		}
	}
	
	// created a deep copy of a given edge weighted Digraph.
	public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
		this(G.V());
		for(int v = 0 ; v < G.V(); v++) {
			Stack<DirectedEdge> stack = new Stack<>();
			for(DirectedEdge e : G.adj(v)) {
				stack.push(e);
			}
			for(DirectedEdge e : stack) {
				adj[v].add(e);
			}
		}
	}
	
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		GraphHelper.validateVertex(v, V);
		GraphHelper.validateVertex(w, V);
		adj[v].add(e);
		E++;
	}
	
	public Iterable<DirectedEdge> adj(int v){
		GraphHelper.validateVertex(v, V);
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<DirectedEdge> edges(){
		edges = new Queue<>();
		for(Bag<DirectedEdge> b : adj) {
			for(DirectedEdge e : b) {
				edges.enqueue(e);
			}
		}
		return edges;
	}
}
