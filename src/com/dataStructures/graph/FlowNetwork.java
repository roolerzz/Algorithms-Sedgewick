package com.dataStructures.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class FlowNetwork {

	private final int V;
	
	private int E;
	
	private Bag<FlowEdge>[] adj;
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public FlowNetwork(int V) {
		this.V = V;
		this.E = 0;
		if(V<0) throw new IllegalArgumentException("Number of vertices in the network must be non negative.");
		adj = (Bag<FlowEdge> [])new Bag[V];
		for(int v = 0 ; v < V ; v++) {
			adj[v] = new Bag<FlowEdge>();
		}
	}
	
	public FlowNetwork(In in) {
		this(in.readInt());
		int edges = in.readInt();
		for(int i = 0 ; i < edges ; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double capacity = in.readDouble();
			GraphHelper.validateVertex(v, V);
			GraphHelper.validateVertex(w, V);
			addEdge(new FlowEdge(v,w,capacity));
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(FlowEdge e) {
		int v = e.from(); int w = e.to();
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<FlowEdge> adj(int v){
		GraphHelper.validateVertex(v, V);
		return adj[v];
	}
/*	public Iterable<FlowEdge> edges(){
		return null;
	}*/
	/*public String toString() {
		
	}*/
	
	
}
