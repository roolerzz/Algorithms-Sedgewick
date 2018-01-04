package com.dataStructures;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// Elements ordered in array. So that searching could be reduced to logN time using binary search.
public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> {

	private Key[] keys;

	private Value[] values;

	public BinarySearchSymbolTable(int INIT_CAPACITY) {
		keys = (Key[]) new Comparable[INIT_CAPACITY];
		values = (Value[]) new Comparable[INIT_CAPACITY];
	}

	private int size;

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	// Check for if the key is null.
	public boolean contains(Key k) {
		if (k == null)
			throw new IllegalArgumentException("Null Key enetered");
		return get(k) != null;
	}

	// Check for if the key is null.
	public Value get(Key k) {
		if (k == null)
			throw new IllegalArgumentException("Null Key enetered");
		int i = rank(k);
		if (i < size && keys[i].compareTo(k) == 0)
			return values[i];
		return null;
	}

	private void resize(int newSize) {
		Key[] tempK = (Key[]) new Comparable[newSize];
		Value[] tempV = (Value[]) new Comparable[newSize];
		int sz = size() - 1;
		for (int i = 0; i < sz; i++) {
			tempK[i] = keys[i];
			tempV[i] = values[i];
			i++;
		}
	}

	// Gives the position of the key in the array as the array is ordered.
	public int rank(Key k) {
		int lo = 0;
		int hi = size - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = k.compareTo(keys[mid]);
			// k is less than middle key
			if (cmp < 0) {
				hi = mid - 1;
			}
			// k is greater than middle key
			else if (cmp > 0) {
				lo = mid + 1;
			} else
				return mid;
		}
		return lo;
	}

	// Check for if the key or value is null.
	public void put(Key k, Value v) {
		if (k == null)
			throw new IllegalArgumentException("Null Key enetered");
		if (v == null) {
			delete(k);
			return;
		}
		int i = rank(k);
		if (i < size && keys[i].compareTo(k) == 0) {
			values[i] = v;
			return;
		}
		if (size == keys.length)
			resize(2 * keys.length);
		for (int j = size; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = k;
		values[i] = v;
		size++;
	}

	// Check for if the key is null.
	public void delete(Key k) {

	}

	public Key min() {
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty symbol table");
		return keys[0];
	}

	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty symbol table");
		return keys[size - 1];
	}

	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("called select() with invalid argument: " + k);
		}
		return keys[k];
	}

	// Check for if the key is null.
	public Key floor(Key k) {
		if (k == null)
			throw new IllegalArgumentException("argument to floor() is null");
		int i = rank(k);
		if (i < size && k.compareTo(keys[i]) == 0)
			return keys[i];
		if (i == 0)
			return null;
		else
			return keys[i - 1];
	}

	// Check for if the key is null.
	public Key ceiling(Key k) {
		if (k == null)
			throw new IllegalArgumentException("argument to ceiling() is null");
		int i = rank(k);
		if (i == size)
			return null;
		else
			return keys[i];
	}

	public void deleteMin() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow error");
		delete(min());
	}

	public void deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow error");
		delete(max());
	}

	public Iterable<Key> keys(){
		Queue<Key> queue = new LinkedBlockingQueue();
		for(Key k : keys){
			queue.add(k);
		}
		return queue;
	}

	public Iterable<Value> values(){
		Queue<Value> queue = new LinkedBlockingQueue();
		for(Value k : values){
			queue.add(k);
		}
		return queue;
	}

	public void printST() {
	}

}
