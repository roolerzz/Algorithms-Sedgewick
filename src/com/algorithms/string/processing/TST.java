package com.algorithms.string.processing;

public class TST<Value>{
	// implementation of Data structure Ternary Search Tree.
	
	private Node<Value> root;
	
	// size of the tree. 
	private int n;

	private static class Node<Value>{
		private Value value;
		
		private char c; 
		
		private Node left, middle, right;
	}
	
	public TST() {
	}
	
	public boolean contains(String key) {
		if(key == null) throw new IllegalArgumentException("Argument to contains() is null");
		return get(key) != null;
	}
	
	public Value get(String key){
		if(key == null) throw new IllegalArgumentException("Argument to get() is null");
		if(key.length() == 0) throw new IllegalArgumentException("Key must have a length >= 1");
		Node<Value> x = get(root,key,0);
		if(x == null) return null;
		else return x.value;
	}
	
	private Node get(Node x, String key, int d) {
		if(x == null) return null;
		char c = key.charAt(d);
		if(c < x.c) return get(x.left,key,d);
		else if (c > x.c) return get(x.right,key,d);
		else if (d < key.length() - 1)return get(x.middle,key,d+1);
		else return x;
		
	}
	
	public void put(String key,Value val) {
		if(key == null) throw new IllegalArgumentException("Argument to put() is null");
		/*if(val == null) {
			delete(key);
			return;
		}*/
		if (!contains(key)) n++;
		root = put(root,key,val,0);
	}
	
	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if(x == null) {
			x = new Node();
			x.c = c;
		}
		if(c < x.c) x.left = put(x.left,key,val,d);
		else if (c > x.c) x.right = put(x.right,key,val,d);
		else if (d < key.length()-1) x.middle = put(x.middle,key,val,d+1);
		else x.value = val;
		return x;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return n;
	}
	
	/*public void delete(String key) {
		if(key == null) throw new IllegalArgumentException("");
		root = delete(root,key,0);
	}
	
	private Node delete(Node x, String key, int d) {
		return null;
	}
	*/

	
}