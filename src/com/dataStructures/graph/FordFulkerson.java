package com.dataStructures.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class FordFulkerson {
	
	private boolean[] marked;
	
	private FlowEdge[] edgeTo;
	
	private double value; // Flow of the network.
	
	public FordFulkerson(FlowNetwork G, int s, int t) {
		value = 0.0;
		while(hasAugmentingPaths(G,s,t)) {
			double bottle = Double.POSITIVE_INFINITY;
			for(int v = t; v != s ; v = edgeTo[v].other(v)) {
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			}
			for(int v = t; v != s ; v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(v, bottle);
			}
			value += bottle;
		}
	}
	
	private boolean hasAugmentingPaths(FlowNetwork G, int s, int t) {
		edgeTo = new FlowEdge[G.V()];
		marked = new boolean[G.V()];
		// Graph Traversal using BFS.
		Queue<Integer> q = new Queue<>();
		q.enqueue(s);
		marked[s]=true;
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for(FlowEdge e : G.adj(v)) {
				int w = e.other(v);
				if(e.residualCapacityTo(w)>0 && !marked[w]) {
					edgeTo[w] = e;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
		return marked[t];
	}
	
	public double value(){
		return value;
	}
	
	public boolean inCut(int v) {
		return marked[v]; // is v reachable from s in residual network.
	}
	
	public static void main(String[] args)
	{
	FlowNetwork G = new FlowNetwork(new In(args[0]));
	int s = 0, t = G.V() - 1;
	FordFulkerson maxflow = new FordFulkerson(G, s, t);
	StdOut.println("Max flow from " + s + " to " + t);
	for (int v = 0; v < G.V(); v++)
		for (FlowEdge e : G.adj(v))
			if ((v == e.from()) && e.flow() > 0)
				StdOut.println(" " + e);
	StdOut.println("Max flow value = " + maxflow.value());
	}
	
}