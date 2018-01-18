package com.dataStructures.graph;

import edu.princeton.cs.algs4.StdOut;

public class Edge implements Comparable<Edge> {

	private final int v, w;

	private final double weight;

	public Edge(int v, int w, double weight) {
		if (v < 0 || w < 0)
			throw new IllegalArgumentException("Vertex index must be a non negative integer.");
		if (Double.isNaN(weight))
			throw new IllegalArgumentException("weight is NaN");
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	int either() {
		return v;
	}

	int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new IllegalArgumentException("Illegal Endpoint");
	}

	@Override
	public int compareTo(Edge that) {
		return Double.compare(this.weight, that.weight);
	}

	public double weight() {
		return weight;
	}

	public String toString() {
		return String.format("%d-%d %.5f",v,w,weight);
	}
	 
	public static void main(String[] args) {
	        Edge e = new Edge(12, 34, 5.67);
	        StdOut.println(e);
	    }
}
