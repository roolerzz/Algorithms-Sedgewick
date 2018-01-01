package com.dataStructures;

import com.algorithm.sorting.SortUtil;

public class BinaryHeapMaxPriorityQueue<Key extends Comparable<Key>>{

	Key[] key;
	
	private static final int ROOT = 1;

	private int top=1;
	
	public BinaryHeapMaxPriorityQueue(int N){
		key = (Key[]) new Comparable[N + 1];
	}

	public boolean isEmpty(){
		return top==1;
	}

	public int size(){
		return top-1;
	}

	public void insert(Key item){
		if(top==key.length) {
			System.out.println("Deleting Maximum element before inserting into priority Queue.");
			delMax();
		}
		key[top] = item;
		swim(top);
		top++;
	}

	private void swim(int k){
		while (k > ROOT && SortUtil.greater(key[k],key[k/2])){
				SortUtil.exchange(key,k,k/2);
				k = k/2;
		}
	}

	// I need to start doing/thinking handling for edge cases, like deletion on empty array, or insertion on a full array etc.
	public Key delMax(){
		//Exchange Root max elem key[1] with last element and Sink new root to its correct position such that heap is ordered.
		// Give special attention to indices of SortUtil exchange compare to the priority queue internal data structure array.
		if(top==1) {
			throw new UnsupportedOperationException("Deletion Not supported on an empty priority queue.");
		}
		Key item = key[ROOT];
		SortUtil.exchange(key, ROOT, top-1);
		sink(ROOT);
		top--;
		return item;
	}
	
	private void sink(int k){
		while(2*k <= top){
			int j = 2*k;
			if (j < top && SortUtil.less(key[j],key[j+1])) {
				j++;
			}
			if(!SortUtil.less(key[k],j)) {break;}
				SortUtil.exchange(key, k, j);
				k = j;
		}
		
	}
	
	public void printQueue(){
		for(Comparable item : key) {
			System.out.print(" : " + item + " : ");
		}
	}

}