package com.dataStructures;

public class RedBlackBST<Key extends Comparable<Key>,Value>{
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		Key key;
		Value val;
		Node left,right;
		boolean color; // color of the parent link
		int size;
		
		Node(Key key, Value val, Node left, Node right, boolean color, int size){
			this.key=key;
			this.val=val;
			this.size = size;
			this.color = color;
			this.left = left;
			this.right = right;
		}
		
		Node(Key key, Value val,int size){
			this(key,val,null,null,false,size);
		}

		Node(Key key, Value val,boolean color){
			this(key,val,null,null,color,1);
		}
		
	}
	public RedBlackBST() {}
	
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color == RED;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x==null) return 0;
		return x.size;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean contains(Key key) {
		return get(key)!=null;
	}
	
	public Value get(Key key) {
		if(key ==null) throw new IllegalArgumentException("Argument Key to contains() is null");
		return get(root,key);
	}

	private Value get(Node x, Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else return x.val;
	}
	
	public void put(Key key, Value val) {
		if(key ==null) throw new IllegalArgumentException("Argument Key to contains() is null");
		if(val==null) {
			delete(key);
			return;
		}
		root = put(root,key,val);
	}
	
	private Node put(Node h, Key key, Value val) {
		if(h==null) return new Node(key,val,RED);
		int cmp = key.compareTo(h.key);
		if(cmp <0) h.left = put(h.left,key,val);
		else if (cmp>0) h.right = put(h.right,key,val);
		else h.val = val;
		// Once the insertion of key val is done at parent h, 
		// now balance the coloring of the tree rooted at h, upto the root of BST.
		// These extra lines of code, provides perfect balance to the ordinary BST.
		if(isRed(h.right)&& !isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.right) && isRed(h.left)) flipColor(h);
		h.size = 1 + size(h.left) + size(h.right);	
		return h;
	}
	
	public void delete(Key key) {
		if(key == null) throw new IllegalArgumentException("argument to delete() is null");
		if(!contains(key)) return ;
	     if (!isRed(root.left) && !isRed(root.right))
	            root.color = RED;
	     root = delete(root, key);
	     if (!isEmpty()) root.color = BLACK;
	}
	
	private Node delete(Node x, Key key) {
		// Method implementation missing due to its complexity :P .
		return null;	
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right; 
		x.right = h;
		x.color= h.color;
		h.color = RED;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private void flipColor(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color= BLACK;
	}
	
	public void search(Key key){
		
	}
	

	
}
