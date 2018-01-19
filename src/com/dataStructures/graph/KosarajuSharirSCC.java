package com.dataStructures.graph;
// A Directed graph is strongly connected if there is a path b/w all pairs of vertices.
public class KosarajuSharirSCC{

	private boolean[] marked;
	
	private int components;
	
	private int[] scc;
	
	public void StronglyConnectedComponents(Digraph G) {
		marked = new boolean[G.V()];
		scc = new int[G.V()];
		// phase 1.
		
		// Phase 2. Run DFS on original graph on the order of the vertices as returned by reverse post order.
		for(int v = 0 ; v < G.V(); v++) {
			if(!marked[v])
				dfs(G,v);
			//components++;
		}
	}
	
	public int connectedComponents() {
		return components;
	}
	
	public void dfs(Digraph G, int v) {
		marked[v]=true;
	/*	for()*/
	}
	
	public boolean stronglyConnected(int v, int w) {
		GraphHelper.validateVertex(v, marked.length);
		GraphHelper.validateVertex(w, marked.length);
		return scc[w]==scc[v];
	}
}
