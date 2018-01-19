package com.algorithm.dynamicconnectivity;

import java.util.Arrays;

public class QuickUnionWeightedUF{

	// Solving the problem of Dynamic connectivity of N Objects. Objects are modeled as 
	// numbers from 0 to N-1, for each object, value in the array depicts its connection to other objects. 
	// Array represents a set of trees, where each tree is a connected component set. value for an ID represents its parent. 
	// Different from QuickUnion in terms of how trees are maintained. Trying to balance tree, such that, depth of the tree 
	// goes to maximum of lg(n). To do this, we need to additionally track number of objects in each tree, such that whenever we 
	// need to connect two objects, find the root of both, take the root(which has less objects) and connect to other 1. 
	// For tracking of size of trees, we maintain another array sz[], where sz[i] represent the size of the tree rooted at i.

	public int[] id;
	public int[] size;
	public QuickUnionWeightedUF(int n){
		id = new int[n];
		size = new int[n];
		for (int i=0; i<n;i++){
			id[i]=i;
		}
		Arrays.fill(size,1);
	}

	// Find if element p is connected to element q. O(lg n) Time complexity as the trees is balanced.
	public boolean find(int p, int q){
		return root(p)==root(q);
	}

	public int root(int i){
		while(i != id[i]){
			i = id[i];
		}
		return i;
	}

	// make a connection from p to q.
	public void union(int p, int q){
	// Change the value of all the connected components from P to value at Q.
		int rootP = root(p);
		int rootQ = root(q);
		if(size[rootP] < size[rootQ]){
			size[rootQ]+=size[rootP];
			id[rootP] = id[rootQ];
		}
		else {
			size[rootP]+=size[rootQ];
			id[rootQ] = id[rootP];	
		}	
		printArray(id);
	}

	public void printArray(int[] arr){
	System.out.println();
		int length = arr.length;	
		for(int i=0;i<length;i++){
			System.out.print(arr[i]+ ":");
		}
	}


}