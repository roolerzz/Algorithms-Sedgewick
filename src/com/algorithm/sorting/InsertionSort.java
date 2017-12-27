package com.algorithm.sorting;

public class InsertionSort {

	private int noOfComparisons=0;
	
	private int noOfExchanges=0;
	
	public void sort(Comparable[] arr){
		// Invarient: Everything to the left of the pointer(and including it) is sorted out of elements seen. Elements on the right are not seen. 
		// For next element seen from right, compare with element to left, if less, swap to maintain order, up until everything seen comes back to order.
		int N = arr.length;
		for(int i = 0 ; i < N ; i++){
			for(int j = i ; j>0 ; j--){
				noOfComparisons++;
				if(SortUtil.less(arr[j],arr[j-1])){
					noOfExchanges++;
					SortUtil.exchange(arr,j,j-1);
				}
				else break;
			}
		}
		System.out.println("Comparisons Insertion Sort : " + noOfComparisons);
		System.out.println("Exchanges Insertion Sort  : " + noOfExchanges);

	}
	
}