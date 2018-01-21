package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraSP {
	// d.s for single source shortest path for non-negative edge weights.
	private double[] distTo; // dist[v] represent distance of shortest path from s to v
	
	private DirectedEdge[] edgeTo; // edgeTo[v] represent last edge on the shortest path from s to v.
	
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		for(DirectedEdge e : G.edges()) {
			if(e.weight()<0) throw new IllegalArgumentException("edge" + e + " has non-negative weight");
		}
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		GraphHelper.validateVertex(s, G.V());
		for(int v = 0 ; v < G.V(); v++) 
			distTo[v]=Double.POSITIVE_INFINITY;
		distTo[s]=0.0;
		pq = new IndexMinPQ<Double>(G.V());
		pq.insert(s,distTo[s]);
		while(!pq.isEmpty()) {
			int v = pq.delMin();
			for(DirectedEdge e : G.adj(v)) {
				relax(e);
			}
		}
	}
	
	private void relax(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w))
				pq.decreaseKey(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
	}
	
	public double distTo(int v) {
		GraphHelper.validateVertex(v, edgeTo.length);
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		GraphHelper.validateVertex(v, distTo.length);
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		GraphHelper.validateVertex(v, distTo.length);
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v]; e!=null; e=edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
	
	public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = Integer.parseInt(args[1]);

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
    }
	
}
