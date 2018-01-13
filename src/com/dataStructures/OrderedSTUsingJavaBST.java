package com.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class OrderedSTUsingJavaBST<Key extends Comparable<Key> , Value>{

	private TreeMap<Key, Value> st;
	
	public OrderedSTUsingJavaBST() {
		st = new TreeMap<Key,Value>();
	}
	
	public int size() {
		return st.size();
	}
	
	public boolean isEmpty() {
		return size() == 0 ;
	}
	
	public boolean contains(Key key) {
		return st.containsKey(key);
	}
	
	public void put(Key key, Value val) {
		if(key==null) throw new IllegalArgumentException("argument to put() is null");
		if(val==null) st.remove(key);
		else st.put(key, val);
	}
	
	public Value get(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to get() is null");
		return st.get(key);
	}
	
	public void delete(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to get() is null");
		st.remove(key);
	}
	public Iterable<Key> keys(){
		return st.keySet();
	}
	public Iterator<Key> iterator(){
		return st.keySet().iterator();
	}
	public Key min() {
		if(isEmpty()) throw new NoSuchElementException("calls min() with empty ST");
		return st.firstKey();
	}
	
	public Key max() {
		if(isEmpty()) throw new NoSuchElementException("calls max() with empty ST");
		return st.lastKey();
	}
	
	public Key ceiling(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to ceiling() is null");
		Key k = st.ceilingKey(key);
		if(k==null) throw new NoSuchElementException("all keys are less than specified key : " + key);
		return k;
	}
	
	public Key floor(Key key) {
		if(key==null) throw new IllegalArgumentException("argument to floor() is null");
		Key k = st.floorKey(key);
		if(k==null) throw new NoSuchElementException("all keys are greater than specified key : " + key);
		return k;
	}
	
	
}
