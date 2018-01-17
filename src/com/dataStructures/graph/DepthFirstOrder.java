package com.dataStructures.graph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {

	private boolean[] marked;
	
	private int[] pre;
	
	private int[] post; 
	
	private Queue<Integer> preOrder;
	
	private Queue<Integer> postOrder;
	
	private int precounter;
	
	private int postCounter;
	
	public DepthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		pre = new int[G.V()];
		post = new int [G.V()];
		postOrder = new Queue<>();
		preOrder = new Queue<>();
		for(int v = 0 ; v < G.V(); v++)
			if(!marked[v]) 
				dfs(G,v);
	}
	
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		preOrder.enqueue(v);
		pre[v] = precounter++;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
		postOrder.enqueue(v);
		post[v] = postCounter++;
	}
	
	public int pre(int v) {
		GraphHelper.validateVertex(v, marked.length);
		return pre[v];
	}
	
	public int post(int v) {
		GraphHelper.validateVertex(v, marked.length);
		return post[v];
	}
	
	public Iterable<Integer> preOrder(){
		return preOrder;
	}
	public Iterable<Integer> postOrder(){
		return postOrder;
	}
	
	public Iterable<Integer> reversePostOrder(){
		Stack<Integer> reversePost = new Stack<Integer>();
		for(int ele : postOrder) 
			reversePost.push(ele);
		return reversePost;
	}
	/* public static void main(String[] args) {
	   In in = new In(args[0]);
       Digraph G = new Digraph(in);

       DepthFirstOrder dfs = new DepthFirstOrder(G);
       StdOut.println("   v  pre post");
       StdOut.println("--------------");
       for (int v = 0; v < G.V(); v++) {
           StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
       }

       StdOut.print("Preorder:  ");
       for (int v : dfs.pre()) {
           StdOut.print(v + " ");
       }
       StdOut.println();

       StdOut.print("Postorder: ");
       for (int v : dfs.post()) {
           StdOut.print(v + " ");
       }
       StdOut.println();

       StdOut.print("Reverse postorder: ");
       for (int v : dfs.reversePost()) {
           StdOut.print(v + " ");
       }
       StdOut.println();
   }*/
	
}
