package com.algorithms.string.processing;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class TrieST<Value>{

	private Node root = new Node();
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private static final int R = 256;
	
	private int n;
	
	public void put(String key, Value val) {
		// check for key and value.
		if(key == null) throw new IllegalArgumentException("Argument to put() is null");
		if(val == null) {
			delete(key);
			return;
		}
		put(root, key, val, 0);
		// BUG everytime on put size of ST is not increasing in case of value replacement.
//		n++;
	}
	
	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			 if (x.value == null) n++;
			x.value = val;
			return x;
		}

        char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	public boolean contains(String key) {
		if(key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}
	
	public Value get(String key){
		if(key == null) throw new IllegalArgumentException("argument to get() is null");
		Node x =  get(root, key, 0);
		if(x==null)return null;
		return (Value) x.value;
	}
	
	private Node get(Node x,String key, int d) {
		if(x==null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c],key,d+1);
	}
	
	public void delete(String key) {
		if(key == null) throw new IllegalArgumentException("argument to delete() is null");
		//if(!contains(key)) return;
		root = 	delete(root,key,0);
		//n--;
	}
	
	private Node delete(Node x, String key, int d) {
		if(x==null) return null;
		if(d == key.length()) 
			{
				if(x.value !=null) n--;
				x.value=null;
			}
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c],key,d+1);
		}
		
		if (x.value !=null) return x;
		// How to check if all the links @ x are null
		for(int r = 0 ; r < R ; r++) {
			if(x.next[r]!=null) return x;
		}
		return null;
	}
	
	private static class Node{
		private Object value;
		private Node[] next = new Node[R];
	}
	
	public boolean isEmpty() {
		return size() == 0;
		
	}
	
	public int size() {
		return n;
	}
	
	/*public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		
	}*/
	
	public Iterable<String> keys(){
		return keysWithPrefix("");
	}
	
	public Iterable<String> keysWithPrefix(String prefix){
		Queue<String> results = new Queue<String>();
		Node x = get(root,prefix,0);
		collect(x, new StringBuilder(prefix),results);
		return results;
	}
	
	private void collect(Node x , StringBuilder prefix, Queue<String> results) {
		if(x==null) return;
		if(x.value !=null) results.enqueue(prefix.toString());
		for(char c = 0 ; c < R ; c++) {
			prefix.append(c);
			collect(x.next[c],prefix,results);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	 public Iterable<String> keysThatMatch(String pattern) {
	        Queue<String> results = new Queue<String>();
	        collect(root, new StringBuilder(), pattern, results);
	        return results;
	    }


	    private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
	        if (x == null) return;
	        int d = prefix.length();
	        if (d == pattern.length() && x.value != null)
	            results.enqueue(prefix.toString());
	        if (d == pattern.length())
	            return;
	        char c = pattern.charAt(d);
	        if (c == '.') {
	            for (char ch = 0; ch < R; ch++) {
	                prefix.append(ch);
	                collect(x.next[ch], prefix, pattern, results);
	                prefix.deleteCharAt(prefix.length() - 1);
	            }
	        }
	        else {
	            prefix.append(c);
	            collect(x.next[c], prefix, pattern, results);
	            prefix.deleteCharAt(prefix.length() - 1);
	        }
	    }

	
	public static void printTrieST() {
		//System.out.println(root);
	}
	
	public static void main(String[] args) {
		TrieST<Integer> st = new TrieST<>();
		In in = new In(args[0]);
		  for (int i = 0; !in.isEmpty(); i++) {
	            String key = in.readString();
	            st.put(key, i);
	        }
		System.out.println(st.get("sea"));
		System.out.println(st.contains("sells"));
		//st.put("", 2);
		//printTrieST();
		
	      

	        // print results
	        if (st.size() < 100) {
	            StdOut.println("keys(\"\"):");
	            for (String key : st.keys()) {
	                StdOut.println(key + " " + st.get(key));
	            }
	            StdOut.println();
	        }

	       /* StdOut.println("longestPrefixOf(\"shellsort\"):");
	        StdOut.println(st.longestPrefixOf("shellsort"));
	        StdOut.println();

	        StdOut.println("longestPrefixOf(\"quicksort\"):");
	        StdOut.println(st.longestPrefixOf("quicksort"));
	        StdOut.println();*/

	        StdOut.println("keysWithPrefix(\"shor\"):");
	        for (String s : st.keysWithPrefix("shor"))
	            StdOut.println(s);
	        StdOut.println();

	        StdOut.println("keysThatMatch(\".he.l.\"):");
	        for (String s : st.keysThatMatch(".he.l."))
	            StdOut.println(s);
	}
	
}
