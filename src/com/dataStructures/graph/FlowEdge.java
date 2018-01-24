package com.dataStructures.graph;

public class FlowEdge {

	private final int v,w;
	
	private final double capacity;
	
	private double flow;
	
	public FlowEdge(int v, int w, double capacity, double flow) {
		if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (w < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(capacity)) throw new IllegalArgumentException("capacity is NaN");
		this.v = v;
		this.w = w;
		this.capacity= capacity;
		this.flow = flow;
	}
	
	public FlowEdge(int v, int w, double capacity) {
		this(v,w,capacity,0.0);
	}
	
	public String toString() {
		return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public int other(int vertex) {
		if(this.v == vertex) return w;
		else if (this.w == vertex) return v;
		else throw new RuntimeException("Not a valid vertex");
	}
	
	public double residualCapacityTo(int vertex) {
		if (this.v == vertex) return flow;
		else if (this.w == vertex) return capacity-flow;
		else throw new IllegalArgumentException("Not a valid endpoint");
	}
	
	public void addResidualFlowTo(int vertex, double delta) {
		if (this.v == vertex)  flow -= delta;
		else if (this.w == vertex) flow += delta;
		else throw new IllegalArgumentException("Not a valid endpoint.");
	}
	
	public double capacity() {
		return capacity;
	}
	public double flow() {
		return flow;
	}
	
}
