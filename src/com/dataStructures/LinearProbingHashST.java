package com.dataStructures;

import java.util.PriorityQueue;
import java.util.Queue;

public class LinearProbingHashST<Key,Value>{

	private static final int INIT_CAPACITY = 4;
	
	private int n;
	private int m;
	private Key[] keys;
	private Value[] vals;
	
	public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}
	
	public LinearProbingHashST(int m) {
		this.m = m;
		this.n=0;
		keys = (Key[])new Object[m];
		vals = (Value[])new Object[m];
	}
	
	// number of keys in the symbol table
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	public boolean contains(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key)!=null;
	}
	public Value get(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to contains() is null");
		for(int z =  hash(key); keys[z]!=null; z=(z+1)%m)
			if(key.equals(keys[z])) 
				return vals[z];

		return null;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff)%m;
	}
	
	private void resize(int capacity) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);
		for(int z=0; z<m;z++) {
			if(keys[z] !=null) {
				temp.put(keys[z],vals[z]);
			}
		}
		keys = temp.keys;
		vals = temp.vals;
		m = temp.m;
	}
	
	public void put(Key key, Value val) {
		if(key==null) throw new IllegalArgumentException("argument to contains() is null");
		if (val == null) {
			delete(key);
			return;
		}
		// double table size if 50% full
        if (n >= m/2) resize(2*m);
        int i;
        for(i=hash(key);keys[i]!=null; i=i+1%m) {
        	if(key.equals(keys[i])) {
        		vals[i]=val;
        		return;
        	}
        }
        keys[i] = key;
        vals[i] = val;
        n++;
	}
	
	public void delete(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to contains() is null");
		if (!contains(key)) return;
		int i = hash(key);
		while(!key.equals(keys[i])) {
			i = (i+1)%m;
		}
		keys[i]=null;
		vals[i]=null;
		i = (i + 1) % m;
	       while (keys[i] != null) {
	            // delete keys[i] an vals[i] and reinsert
	            Key   keyToRehash = keys[i];
	            Value valToRehash = vals[i];
	            keys[i] = null;
	            vals[i] = null;
	            n--;
	            put(keyToRehash, valToRehash);
	            i = (i + 1) % m;
	        }
	       n--;
	       // halves size of array if it's 12.5% full or less
	        if (n > 0 && n <= m/8) resize(m/2);
	}
	
	  public Iterable<Key> keys() {
	        Queue<Key> queue = new PriorityQueue<Key>();
	        for (int i = 0; i < m; i++)
	            if (keys[i] != null) queue.add(keys[i]);
	        return queue;
	    }
	
}
