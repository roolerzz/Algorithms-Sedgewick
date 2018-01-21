package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

public class AcyclicSP {

	private double[] distTo;
	
	private edu.princeton.cs.algs4.DirectedEdge[] edgeTo;
		
	public AcyclicSP(edu.princeton.cs.algs4.EdgeWeightedDigraph G, int s) {
		GraphHelper.validateVertex(s, G.V());
		distTo = new double[G.V()];
		edgeTo = new edu.princeton.cs.algs4.DirectedEdge[G.V()];
		
		for(int v = 0 ; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		edu.princeton.cs.algs4.Topological topological = new Topological(G); 
		   if (!topological.hasOrder())
	            throw new IllegalArgumentException("Digraph is not acyclic.");
		for(int v : topological.order()) {
			for(edu.princeton.cs.algs4.DirectedEdge e : G.adj(v))
				relax(e);
		}
	}
	
	private void relax(edu.princeton.cs.algs4.DirectedEdge e) {
		int v = e.from(); int w = e.to();
		if(distTo[w]>distTo[v]+e.weight()) {
			distTo[w] = distTo[v]+ e.weight();
			edgeTo[w] = e;
			
		}
	}
	
	public double distTo(int v) {
		GraphHelper.validateVertex(v, distTo.length);
		return distTo[v];
	}
	
	
	public boolean hasPathTo(int v) {
		GraphHelper.validateVertex(v, distTo.length);
		return distTo[v]< Double.POSITIVE_INFINITY;
		
	}
	
	public Iterable<edu.princeton.cs.algs4.DirectedEdge> pathTo(int v){
		GraphHelper.validateVertex(v, distTo.length);
		if(!hasPathTo(v)) return null;
		Stack<edu.princeton.cs.algs4.DirectedEdge> path = new Stack<>();
		for(edu.princeton.cs.algs4.DirectedEdge e = edgeTo[v]; e !=null; e=edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
	
	  public static void main(String[] args) {
	        In in = new In(args[0]);
	        int s = Integer.parseInt(args[1]);
	        edu.princeton.cs.algs4.EdgeWeightedDigraph G = new edu.princeton.cs.algs4.EdgeWeightedDigraph(in);

	        // find shortest path from s to each other vertex in DAG
	        AcyclicSP sp = new AcyclicSP(G, s);
	        for (int v = 0; v < G.V(); v++) {
	            if (sp.hasPathTo(v)) {
	                StdOut.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
	                for (edu.princeton.cs.algs4.DirectedEdge e : sp.pathTo(v)) {
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
