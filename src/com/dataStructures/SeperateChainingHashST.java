package com.dataStructures;

import java.util.PriorityQueue;
import java.util.Queue;

import com.dataStructures.SequentialSearchSymbolTable;

public class SeperateChainingHashST<Key,Value>{

	private static final int INIT_CAPACITY = 4;
	// hash table size
	private int m;
	// number of key value pairs
	private int n;
	
	private SequentialSearchSymbolTable<Key, Value>[] st	;
	
	public SeperateChainingHashST() {
		this(INIT_CAPACITY);
	}
	
	public SeperateChainingHashST(int m) {
		this.m = m;
		st = (SequentialSearchSymbolTable<Key,Value>[]) new SequentialSearchSymbolTable[m];
		for(int i=0; i<m ; i++) {
			st[i] = new SequentialSearchSymbolTable<Key,Value>();
		}
	}
	
	private void resize(int chains) {
		System.out.println("Array resized to " + chains + " chains.");
		SeperateChainingHashST<Key, Value> temp = new SeperateChainingHashST<Key,Value>(chains);
		for(int i=0; i<m;i++) {
			for(Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.m = temp.m;
		this.n= temp.n;
		this.st = temp.st;
		
	}
	
	// Returns a 32 bit hash caluculated on the key.
	private int hash(Key key) {
		int hash = (key.hashCode() & 0x7fffffff) % m;
		System.out.println("Hash of Key : " + key + " is : "  + hash);
		return hash;
	}
	
	public void put(Key key, Value val) {
		 if (key == null) throw new IllegalArgumentException("first argument to put() is null");
	        if (val == null) {
	            delete(key);
	            return;
	        }
	     // double table size if average length of list >= 10
	        if (n >= 10*m) resize(2*m);
	        int i = hash(key);
	        if (!st[i].contains(key)) n++;
	        st[i].put(key, val);
	}
	
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		int i = hash(key);
		if (st[i].contains(key)) n--;
		st[i].delete(key);
		// halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public void printSTArray() {
		for(int i=0;i<m;i++)
		System.out.println(st[i]);
	}
	
	public Iterable<Key> keys(){
		Queue<Key> keys = new PriorityQueue<>();
		 for (int i = 0; i < m; i++) {
			  for (Key key : st[i].keys()) {
				  keys.add(key);
			  }
		 }
		return keys;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public Value get(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		int i = hash(key);
		return st[i].get(key);
	}
	
	public Value search(Key key) {
		return null;
	}
	
	
}
