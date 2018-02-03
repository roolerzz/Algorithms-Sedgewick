package com.algorithms.string.processing;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class NFA {

	private Digraph graph; // digraph of epsilon transitions.
	
	private String regexp; // regular expression.
	
	private final int m; // no of characters in regular expression
	
	public NFA(String regexp) {
		this.regexp = regexp;
		this.m = regexp.length();
		Stack<Integer> ops = new Stack<>();
		graph = new Digraph(m+1);
		for(int i = 0; i<m ; i++) {
			int lp = i;
			if(regexp.charAt(i)=='(' || regexp.charAt(i) == '|') {
				ops.push(i);
			}
			else if (regexp.charAt(i)==')') {
				int or = ops.pop();
				if(regexp.charAt(or)=='|') {
					lp = ops.pop();
					graph.addEdge(lp, or+1);
					graph.addEdge(or, i);
				}
				else if (regexp.charAt(or)=='(')
					lp = or;
				else assert false;
			}
			if(i<m-1 && regexp.charAt(i+1)=='*') {
				graph.addEdge(lp, i+1);
				graph.addEdge(i+1,lp);
			}
			if(regexp.charAt(i)=='(' || regexp.charAt(i)=='*' || regexp.charAt(i)==')') {
				graph.addEdge(i, i+1);
			}
		}
		if(ops.size()!=0)
			throw new IllegalArgumentException("Invalid Regular Expression.");
	}
	
	public boolean recognizes(String txt) {
		DirectedDFS dfs = new DirectedDFS(graph, 0);
		Bag<Integer> pc = new Bag<>();
		for(int v = 0 ; v < graph.V(); v++) {
			if(dfs.marked(v)) pc.add(v);
		}
		// compute possible NFA state for txt[i+1]
		for(int i = 0 ; i < txt.length(); i++) {
			if(txt.charAt(i)=='|' || txt.charAt(i)=='*' || txt.charAt(i) == '(' || txt.charAt(i) == ')')
				throw new IllegalArgumentException("Text contains meta characters.");
			Bag<Integer> match = new Bag<>();
			for(int v : pc) {
				if(v==m)continue;
				if(regexp.charAt(v)==txt.charAt(i)|| regexp.charAt(v)=='.') 
					match.add(v+1);
			}
			dfs = new DirectedDFS(graph,match);
			pc = new Bag<>();
			for(int v = 0 ; v < graph.V();v++) 
				if(dfs.marked(v))pc.add(v);
			//optimization if no states are reachable.
			if(pc.size()==0) return false;
		}
		for(int v : pc)
			if(v==m)return true;
		return false;
	}
	
    public static void main(String[] args) {
        String regexp = "(" + args[0] + ")";
        String txt = args[1];
        NFA nfa = new NFA(regexp);
        StdOut.println(nfa.recognizes(txt));
    }
	
}
