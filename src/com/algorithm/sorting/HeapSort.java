package com.algorithm.sorting;

public class HeapSort<Key extends Comparable<Key>>{

	Key[] key;
	
	Key[] arr;
	
	private static final int ROOT = 1;

	private int top=0;
	
	public HeapSort(Key[] arr){
		this.arr = arr;
		key = (Key[]) new Comparable[arr.length + 1];
		for(Key item : arr) {
			key[++top] = item;
		}
		bottomUpHeapify();
	}

	public void bottomUpHeapify(){
		if(top<1){return ;}
		int k = top/2;
		while(k >= ROOT){
			sink(k--);
		}
	}

	public Key[] sortAndReturn(){
		int dummyTop = top;
		while(top>1){
			SortUtil.exchange(key, ROOT,top--);
			sink(ROOT);
		}
		for(int i=1; i <= dummyTop ; i++) {
			arr[i-1] = key[i];
		}
		return arr;
	}

	private void swim(int k){
		while (k > ROOT && SortUtil.greater(key[k],key[k/2])){
				SortUtil.exchange(key,k,k/2);
				k = k/2;
		}
	}

	private void sink(int k){
		while(2*k <= top){
			int j = 2*k;
			if (j < top && SortUtil.less(key[j],key[j+1])) {
				j++;
			}
			if(!SortUtil.less(key[k],key[j])) {break;}
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
