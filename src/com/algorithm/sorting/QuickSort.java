package com.algorithm.sorting;

import java.util.Random;

public class QuickSort{

	public void sort(Comparable[] arr){
		sort(arr,0,arr.length-1);
	}
	
	// Find the position of a random pivot element. Recursively sort on first and 2nd halves. 
	private void sort(Comparable[] arr, int lo, int hi){
		if(lo>=hi) { return;}
		int pivot = partition(arr,lo,hi);
		sort(arr,lo,pivot-1);
		sort(arr,pivot+1,hi);
	}
	
	private int partition(Comparable[] arr, int lo, int hi){
		int i = lo + 1;
		int j = hi;
		if(i>j) { return lo;}
		Random generator = new Random();
		int r = lo + generator.nextInt(hi-lo+1);
		SortUtil.exchange(arr,r,lo);
		Comparable item = arr[lo];
		while(i<=j){
			if(SortUtil.less(arr[i],item)){ i++ ; }
			else {	SortUtil.exchange(arr,i,j--);	}
		}
		SortUtil.exchange(arr,j,lo);
		return j;
	}
}
