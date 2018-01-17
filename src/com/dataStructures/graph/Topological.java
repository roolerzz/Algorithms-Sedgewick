package com.dataStructures.graph;

public class Topological {

	private Iterable<Integer> order;
	
	private int[] rank;
	
	public Topological(Digraph G) {
		DirectedCycle finder = new DirectedCycle(G); 
		if(!finder.hasCycle()) {
			rank = new int[G.V()];
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePostOrder();
			int i = 0;
			for(int v : order) 
				rank[v]=i++;
		}
	}
	
	 public boolean isDAG() {
	        return hasOrder();
	    }
	
	public int rank(int v) {
		GraphHelper.validateVertex(v, rank.length);
		if(hasOrder())return rank[v];
		return -1;
	}
	
	public boolean hasOrder() {
		return order != null;
	}
	
	public Iterable<Integer> order(){
		return order;
	}
	
	/*public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
        Topological topological = new Topological(sg.digraph());
        for (int v : topological.order()) {
            StdOut.println(sg.nameOf(v));
        }
    }*/

	
}
