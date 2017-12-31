package com.dataStructures;

import com.algorithm.sorting.SortUtil;

public class MaxPriorityQueueUnorderedArray<Key extends Comparable<Key>>{

	Comparable[] key;

	int top=0;
	
	public MaxPriorityQueueUnorderedArray(int N){
		key = new Comparable[N];
	}
	
	public boolean isEmpty(){
		return top==0;
	}

	public void insert(Comparable val){
		if(top==key.length-1) {
			System.out.println("Removing items before inserting. ");
			delMax();
		}
		key[top++] = val;
	}

	public Comparable delMax(){
		if(isEmpty()) {
			System.out.println("Cannot delete from an empty Priority Queue.");
			return null;
		}
		int maxInd = 0;
		for(int i=1; i < top; i++){
			if(SortUtil.less(key[maxInd], key[i])){
				maxInd = i;
			}
		}
		SortUtil.exchange(key,maxInd,top-1);
		//System.out.println("Max Element Removed : " + key[top-1]);
		Comparable maxKey = key[top-1];
		key[--top] = null;
		return maxKey;
	}
}

/*Integer arr[] = {1,2,3,4,4,5,2,2,3,1};

Integer arr[] = new Integer[10];


for(int i=0;i<10;i++) {
	arr[i]=i+1;
}
Shuffling shuffle = new Shuffling();
shuffle.knuthShuffle(arr);
SortUtil.printArrayComparable(arr);
MaxPriorityQueueUnorderedArray<Integer> pq = new MaxPriorityQueueUnorderedArray<>(5);
for(int i=0;i<10;i++) {
	pq.insert(arr[i]);
}
System.out.println();
System.out.println(pq.delMax());
System.out.println(pq.delMax());
System.out.println(pq.delMax());
System.out.println(pq.delMax());
System.out.println(pq.delMax());*/


