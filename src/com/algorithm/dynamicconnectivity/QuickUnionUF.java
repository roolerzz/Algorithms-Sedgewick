package com.algorithm.dynamicconnectivity;

public class QuickUnionUF{

	// Solving the problem of Dynamic connectivity of N Objects. Objects are modeled as 
	// numbers from 0 to N-1, for each object, value in the array depicts its connection to other objects. 
	// Array represents a set of trees, where each tree is a connected component set. value for an ID represents its parent

	public int[] id;

	QuickUnionUF(int n){
		id = new int[n];
		for (int i=0; i<n;i++){
			id[i]=i;
		}
	}

	// Find if element p is connected to element q. O(n) worst case complexity if the tree is linear.
	public boolean find(int p, int q){
		return root(p)==root(q);
	}

	public int root(int root){
		int length = id.length;
		while((root>0 && root<length) && root != id[root]){
		root = id[root];
		}
		return root;
	}

	// make a connection from p to q.
	public void union(int p, int q){
	// Change the value of all the connected components from P to value at Q.
		id[root(p)] = id[root(q)];
		printArray();
	}

	public void printArray(){
		System.out.println();
		int length = id.length;	
		for(int i=0;i<length;i++){
			System.out.print(id[i]+ ":");
		}
	}


}