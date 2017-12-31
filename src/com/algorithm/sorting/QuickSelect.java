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
	
	//Iterative and better version of quick select.
	public  Comparable select(Comparable[] arr, int k) {
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("index is not between 0 and " + arr.length + ": " + k);
        }
        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            int i = QSINSTANCE.partition(arr, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return arr[i];
        }
        return arr[lo];
    }



}