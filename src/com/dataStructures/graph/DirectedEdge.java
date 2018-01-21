package com.dataStructures.graph;

public class DirectedEdge implements Comparable<DirectedEdge>{

	private final int v,w;
	
	private final double weight;
	
	public DirectedEdge(int v, int w, double weight) {
		if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (w < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }


	public int compareTo(DirectedEdge that) {
		return Double.compare(this.weight,that.weight);
	}
}
