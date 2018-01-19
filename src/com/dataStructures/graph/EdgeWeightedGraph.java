package com.dataStructures.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// undirected. Each edge appears twice. parallel edges and self loops permitted.
public class EdgeWeightedGraph {

	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;

	private int E;

	// maintain a vertex indexed array of bags of edges.
	private Bag<Edge>[] adj;

	// initializes and empty edgeweighted graph of V vertices.
	public EdgeWeightedGraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices can;t be negative.");
		this.V = V;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Edge>();
		}
	}

	public EdgeWeightedGraph(In in) {
		this(in.readInt());
		int edges = in.readInt();
		if (edges < 0)
			throw new IllegalArgumentException("Number of vertices or edges cannot be negative.");
		for (int i = 0; i < edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			GraphHelper.validateVertex(v, V);
			GraphHelper.validateVertex(w, V);
			double weight = in.readDouble();
			Edge e = new Edge(v, w, weight);
			addEdge(e);
		}
	}

	// creates a deep copy of edgeweightedgraph G.
	public EdgeWeightedGraph(EdgeWeightedGraph G) {
		this(G.V());
		for (int v = 0; v < V; v++) {
			Stack<Edge> reverse = new Stack<Edge>();
			for (Edge e : G.adj(v)) {
				reverse.push(e);
			}
			for (Edge e : reverse) {
				adj[v].add(e);
			}
		}
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		GraphHelper.validateVertex(v, V);
		GraphHelper.validateVertex(w, V);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public int degree(int v) {
		GraphHelper.validateVertex(v, V);
		return adj[v].size();
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	// Returns all the edges in this edge weighted graph.
	public Iterable<Edge> edges() {
		Bag<Edge> list = new Bag<Edge>(); 
		for(int v = 0 ; v < V ; v++) {
			int selfLoops = 0;
			for (Edge e : adj(v)) {
				if(e.other(v)>v)
					list.add(e);
				else if (e.other(v)==v) {
					if(selfLoops%2==0) list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public String toString() {
		  StringBuilder s = new StringBuilder();
	        s.append(V + " " + E + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (Edge e : adj[v]) {
	                s.append(e + "  ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	}
	
	public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        StdOut.println(G);
    }
	
}
