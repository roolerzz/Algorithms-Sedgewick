package com.dataStructures;

import com.algorithm.sorting.SortUtil;

public class MinPriorityQueueOrderedArray<Key extends Comparable<Key>>{

	Comparable[] key;

	int top=0;
	
	public MinPriorityQueueOrderedArray(int N){
		key = new Comparable[N];
	}
	
	public void printQueue(){
		for(Comparable item : key) {
			System.out.print(" : " + item + " : ");
		}
	}
	
	public boolean isEmpty(){
		return top==0;
	}

	public int size(){
		return top-1;
	}

	public void insert(Comparable item){
		if(top==key.length) {
			System.out.println("Removing items before inserting. ");
			delMin();
		}
		// Above snippet ensures there is atleast 1 space for insertion.
		
		int j = top;
		while(j>0){
			if(SortUtil.less(key[j-1],item)){
				key[j]= key[j-1];
				j--;
			}
			else break;
		}
		key[j]=item;
		top++;
	}

	public Comparable delMin(){
		if(isEmpty()) {
			System.out.println("Cannot delete from an empty Priority Queue.");
			return null;
		}
		Comparable item = key[top-1];
		key[top-1] = null;
		top--;
		return item;
	}
}
