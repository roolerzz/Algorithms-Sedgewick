package com.dataStructures.graph;

public class ConnectedComponents {

	private boolean[] marked;
	
	private int[] cc; 
	
	private int[] size;
	
	private int count;
	
	public ConnectedComponents(AdjacencyListGraph G) {
		int V = G.V();
		marked = new boolean[V];
		size = new int[V];
		cc = new int[V];
		for(int v = 0; v <V ; v++) {
			if(!marked[v]) {
				connectviaDFS(G,v);
				count++;
			}
		}
	}
	
	private void connectviaDFS(AdjacencyListGraph G, int v) {
		marked[v] = true;
		cc[v] = count;
		size[count]++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				connectviaDFS(G,w);
			}
		}
	}
	
	private void validateVertex(int v) {
		int V = marked.length;
		if(v<0 || v >= V) throw new IllegalArgumentException("Vertex : " + v + " is not b/w 0 and " +  (V-1));
	}
	
	   public int id(int v) {
	        validateVertex(v);
	        return cc[v];
	    }
	   // Returns the number of vertices in the connected component containing vertex
	   public int size(int v) {
	        validateVertex(v);
	        return size[cc[v]];
	    }
	   public int count() {
		   return count;
	   }
	// Contant time operation once the graph is pre-processed to efficiently support connected components.
	public boolean isConnected(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return cc[v] == cc[w];
	}
}

/*public static void main(String[] args) {
    In in = new In(args[0]);
    Graph G = new Graph(in);
    CC cc = new CC(G);

    // number of connected components
    int m = cc.count();
    StdOut.println(m + " components");

    // compute list of vertices in each connected component
    Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
    for (int i = 0; i < m; i++) {
        components[i] = new Queue<Integer>();
    }
    for (int v = 0; v < G.V(); v++) {
        components[cc.id(v)].enqueue(v);
    }

    // print results
    for (int i = 0; i < m; i++) {
        for (int v : components[i]) {
            StdOut.print(v + " ");
        }
        StdOut.println();
    }
}*/
