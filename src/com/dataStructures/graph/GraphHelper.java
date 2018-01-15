package com.dataStructures.graph;

public class GraphHelper {

	public static void validateVertex(int v, int V) {
		if(v < 0 || v >= V) throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V-1)); 
	}
	
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v))
			degree++ ;
		return degree;
	}
	
	public static int maxDegree(Graph G) {
		int max = 0;
		for(int v = 0 ; v < G.V(); v++) 
			if(degree(G, v)>max)
				max=degree(G,v);
		return max;
	}
	
	public static double averageDegree(Graph G) {
		return 2*G.E()/G.V();
	}
	
	public static int numberOfSelfLoops(Graph G) {
		int count = 0; 
		for(int v = 0; v<G.V();v++) 
			 for(int w : G.adj(v))
				 if(w==v) count++;
		 count/=2;
		 return count;
	}
	
}
