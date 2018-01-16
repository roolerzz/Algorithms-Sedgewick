package com.dataStructures.graph;

import edu.princeton.cs.algs4.Stack;

public class BipartiteUndirected {

	private boolean bipartite;

	private boolean[] marked;

	private int[] edgeTo;

	private boolean[] color;

	private Stack<Integer> cycle;

	public BipartiteUndirected(AdjacencyListGraph G) {
		bipartite = true;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		color = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}
		assert check(G);
	}

	public boolean color(int v) {
		GraphHelper.validateVertex(v, marked.length);
		if (!bipartite)
			throw new UnsupportedOperationException("graph is not bipartite");
		return color[v];
	}

	public void dfs(AdjacencyListGraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (cycle != null)
				return;

			if (!marked[w]) {
				edgeTo[w] = v;
				color[w] = !color[v];
				dfs(G, w);
			} else if (color[v] == color[w]) {
				bipartite = false;
				cycle = new Stack<Integer>();
				cycle.push(w);
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
			}
		}
	}

	public boolean isBipartite() {
		return bipartite;
	}

	public Iterable<Integer> oddCycle() {
		return cycle;
	}

	private boolean check(AdjacencyListGraph G) {
		if (bipartite) {
			for (int v = 0; v < G.V(); v++) {
				for (int w : G.adj(v)) {
					if (color[w] == color[v]) {
						System.out.printf("edge %d-%d with %d and %d in same side of bipartition\n", v, w, v, w);
						return false;
					}
				}
			}
		} else {
			// verify cycle
			int first = -1, last = -1;
			for (int v : oddCycle()) {
				if (first == -1)
					first = v;
				last = v;
			}
			if (first != last) {
				System.out.printf("cycle begins with %d and ends with %d\n", first, last);
				return false;
			}
		}
		return true;
	}
	
}
