package com.algorithm.sorting;

public class ShellSort {

	public void sort(Comparable[] arr) {
		// Idea is to h-sort an array. meaning, elements 0, h, 2h, 3h are sorted in their subarray, 1, h+1, 2h+1 in theirs. 
		// This shortens the movement in case of worst case scenarios where you could have to move an element N places in insertion Sort.
		int N = arr.length;
		// create a sequence : 3X+1 works well.  
		int h=1;
		int noOfComparisons = 0;
		int noOfExchanges = 0;
		while(h<N) {
			h = 3*h + 1;	
		}
		
		while(h>=1) {
			for(int i=h; i<N ; i++) {
				for(int j=i; j>=h; j-=h) {
					noOfComparisons++;
					if(SortUtil.less(arr[j], arr[j-h])){
						noOfExchanges++;
						SortUtil.exchange(arr, j, j-h);
					}
				}
			}
			h /= 3;
		}
		System.out.println("noOfComparisons : " + noOfComparisons);
		System.out.println("noOfExchanges : "+ noOfExchanges);
	}
	
}
