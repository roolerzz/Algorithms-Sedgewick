package com.algorithm.sorting;

public class QuickSelect{

	private static final QuickSort QSINSTANCE = new QuickSort(); 

	public Comparable selectKthSmallest(Comparable[] arr, int k){
		return quickSelect(arr,k-1,0,arr.length-1);
	}	

	public Comparable quickSelect(Comparable[] arr, int k ,int lo, int hi){
		int pivot = QSINSTANCE.partition(arr,lo,hi);
		if(pivot == k){
			return arr[k];
		}
		else if (pivot > k){
			return quickSelect(arr,k,lo,pivot-1);
		}
		else 
			return quickSelect(arr,k,pivot+1,hi);
	}

}