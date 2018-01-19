package com.dataStructures.graph;

import com.algorithm.dynamicconnectivity.QuickUnionWeightedUF;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
	
	private Queue<Edge> mst;
	
	private double weight;
	
	private static final double FLOATING_POINT_EPSILON = 1E-12;
	
	public KruskalMST(EdgeWeightedGraph G) {
		MinPQ<Edge> pq;
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		QuickUnionWeightedUF uf = new QuickUnionWeightedUF(G.V());
		for(Edge e : G.edges())
			pq.insert(e);
		while(!pq.isEmpty() || mst.size() < G.V()-1)
		{
			Edge e = pq.delMin();
			int v = e.either(); int w = e.other(v);
			if(!uf.find(v, w)) {
				mst.enqueue(e);
				uf.union(v, w);
				weight += e.weight();
			}
		}
	    // check optimality conditions
        assert check(G);
	}
	
	 // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(EdgeWeightedGraph G) {
    	double total = 0.0;
    	for (Edge e : edges()) {
            total += e.weight();
        }
    	if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
            return false;
        }
    	  UF uf = new UF(G.V());
          for (Edge e : edges()) {
              int v = e.either(), w = e.other(v);
              if (uf.connected(v, w)) {
                  System.err.println("Not a forest");
                  return false;
              }
              uf.union(v, w);
          }
          // check that it is a spanning forest
          for (Edge e : G.edges()) {
              int v = e.either(), w = e.other(v);
              if (!uf.connected(v, w)) {
                  System.err.println("Not a spanning forest");
                  return false;
              }
          }
          // check that it is a minimal spanning forest (cut optimality conditions)
          for (Edge e : edges()) {

              // all edges in MST except e
              uf = new UF(G.V());
              for (Edge f : mst) {
                  int x = f.either(), y = f.other(x);
                  if (f != e) uf.union(x, y);
              }
              
              // check that e is min weight edge in crossing cut
              for (Edge f : G.edges()) {
                  int x = f.either(), y = f.other(x);
                  if (!uf.connected(x, y)) {
                      if (f.weight() < e.weight()) {
                          System.err.println("Edge " + f + " violates cut optimality conditions");
                          return false;
                      }
                  }
              }

          }

          return true;
          
    }	
	public Iterable<Edge> edges(){
		return mst;
	}
	// return the total weight of minimum spanning tree.
	public double weight() {
		return weight;
	}
	
	 public static void main(String[] args) {
	        In in = new In(args[0]);
	        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	        KruskalMST mst = new KruskalMST(G);
	        for (Edge e : mst.edges()) {
	            StdOut.println(e);
	        }
	        StdOut.printf("%.5f\n", mst.weight());
	    }

	
}
