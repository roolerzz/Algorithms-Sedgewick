package com.dataStructures.graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

public class AcyclicLP {

	private double[] distTo;
	
	private DirectedEdge[] edgeTo;
	
	
	public AcyclicLP(EdgeWeightedDigraph G, int s) {
		GraphHelper.validateVertex(s, G.V());
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		
		// Initialize distTo
		for(int v = 0 ; v < G.V(); v++) {
			distTo[v] = Double.NEGATIVE_INFINITY;
		}
		distTo[s]=0.0;
		
		Topological topological = new Topological(G);
		for(int v : topological.order()) 
			for(DirectedEdge e : G.adj(v))
				relax(e);
	}
	
	private void relax(DirectedEdge e) {
		int v = e.from(); int w = e.to();
		if(distTo[w] < distTo[v] + e.weight()) {
			distTo[w] = distTo[v]+e.weight();
			edgeTo[w] = e;
		}
	}
	
	public double distTo(int v) {
		GraphHelper.validateVertex(v, distTo.length);
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		GraphHelper.validateVertex(v, distTo.length);
		return (distTo[v]>Double.NEGATIVE_INFINITY);
	}
	public Iterable<DirectedEdge> pathTo(int v){
		GraphHelper.validateVertex(v, distTo.length);
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<>();
		for(DirectedEdge e=edgeTo[v]; e!=null; e=edgeTo[e.from()])
			path.push(e);
		return path;
	}
	
	 public static void main(String[] args) {
	        In in = new In(args[0]);
	        int s = Integer.parseInt(args[1]);
	        edu.princeton.cs.algs4.EdgeWeightedDigraph G = new edu.princeton.cs.algs4.EdgeWeightedDigraph(in);

	        // find longest path from s to each other vertex in DAG
	        AcyclicLP lp = new AcyclicLP(G, s);
	        for (int v = 0; v < G.V(); v++) {
	            if (lp.hasPathTo(v)) {
	                StdOut.printf("%d to %d (%.2f)  ", s, v, lp.distTo(v));
	                for (edu.princeton.cs.algs4.DirectedEdge e : lp.pathTo(v)) {
	                    StdOut.print(e + "   ");
	                }
	                StdOut.println();
	            }
	            else {
	                StdOut.printf("%d to %d         no path\n", s, v);
	            }
	        }
	    }
	
}
