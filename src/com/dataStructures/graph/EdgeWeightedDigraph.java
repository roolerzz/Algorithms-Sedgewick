package com.dataStructures.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// Allows self loops and parallel edges.
public class EdgeWeightedDigraph {

	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V;
	
	private int E;
	
	private Bag<DirectedEdge>[] adj;
	
	 private int[] indegree;    
	
	// initializes an empty edgeweighteddigraph with internal adjacency list data structure empty-initialized.
	public EdgeWeightedDigraph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E=0;
		this.indegree = new int[V];
		adj = (Bag<DirectedEdge>[])new Bag[V];
		for(int v = 0 ; v < V ; v++) {
			adj[v]= new Bag<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDigraph(In in) {
		this(in.readInt());
		int e2 = in.readInt();
		if (e2 < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		for (int i = 0; i < e2; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			GraphHelper.validateVertex(v, V);
			GraphHelper.validateVertex(w, V);
			addEdge(new DirectedEdge(v,w,weight));
		}
	}
	
	// created a deep copy of a given edge weighted Digraph.
	public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
		this(G.V()); 
		this.E = G.E();
		 for (int v = 0; v < G.V(); v++)
	            this.indegree[v] = G.indegree(v);
		for(int v = 0 ; v < G.V(); v++) {
			Stack<DirectedEdge> reverse = new Stack<>();
			for(DirectedEdge e : G.adj(v)) {
				reverse.push(e);
			}
			for(DirectedEdge e : reverse) {
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
		indegree[w]++;
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
	
	 public int indegree(int v) {
	        GraphHelper.validateVertex(v,V);
	        return indegree[v];
	    }
	  
	 public int outdegree(int v) {
		 GraphHelper.validateVertex(v,V);
	        return adj[v].size();
	    }
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> list = new Bag<DirectedEdge>();
		  for (int v = 0; v < V; v++) {
			  for (DirectedEdge e : adj(v)) {
				  list.add(e);
			}
		}
		return list;
	}
	 public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(V + " " + E + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (DirectedEdge e : adj[v]) {
	                s.append(e + "  ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }
	 public static void main(String[] args) {
	        In in = new In(args[0]);
	        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
	        StdOut.println(G);
	    }
}
