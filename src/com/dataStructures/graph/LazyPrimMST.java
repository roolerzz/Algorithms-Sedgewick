package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/*This implementation uses a lazy version of <em>Prim's algorithm</em>
	with a binary heap of edges. */
public class LazyPrimMST {
		// total weight of the mst.
	private double weight;
	// edges in the mst.
	private Queue<Edge> mst;
	// edges with one endpoint in T.
	private MinPQ<Edge> pq;
	// For identifying if the vertex v is already on the Tree T.
	private boolean[] marked;
			
	/*The constructor takes time proportional to <em>E</em> log <em>E</em>
	 *  and extra space (not including the graph) proportional to <em>E</em>,
	 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
	*/
	public LazyPrimMST(EdgeWeightedGraph G) {
		// API's of G that we could use. G.V(), G.E(), G.adj(v), edges, degree(v)
		//initializing the data structures for our MST algo.
		mst = new Queue<>();
		marked = new boolean[G.V()];
		pq = new MinPQ<>();
		for(int v = 0 ; v < G.V(); v++) {
			if(!marked[v]) {
				Prim(G,v);
			}
		}
	}
	
	private void Prim(EdgeWeightedGraph G , int s) {
		scan(G,s);
		while(!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either(); int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.enqueue(e);
			weight += e.weight();
			if(!marked[v]) scan(G,v);
			if(!marked[w]) scan(G,w);
		}
	}
	
	private void scan(EdgeWeightedGraph G, int v) {
		assert !marked[v];
		marked[v]=true;
		for(Edge e : G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);
		
	}
	
	public double weight() {
		return weight;
	}
	/*the {@code edges()} method takes time proportional to <em>V</em>.*/
	public Iterable<Edge> edges(){
		return mst;
	}
	
	 public static void main(String[] args) {
	        In in = new In(args[0]);
	        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	        LazyPrimMST mst = new LazyPrimMST(G);
	        for (Edge e : mst.edges()) {
	            StdOut.println(e);
	        }
	        StdOut.printf("%.5f\n", mst.weight());
	    }

	
}
