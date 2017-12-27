package com.algorithm.sorting;

public class SelectionSort {

	private int noOfComparisons=0;
	
	private int noOfExchanges=0;
	
	public void sort(Comparable[] arr) {
		// For each index i, look from i+1 till Nth element and find index with smallest
		// element.
		// exchange a[i] with a[min] and repeat until N. (N^2)/2 comparisons and N
		// exchanges for any time of data.
		int N = arr.length;
		for (int i = 0; i < N ; i++) {
			int min = i;
			for (int j = i + 1 ; j < N; j++) {
				noOfComparisons++;
				if (SortUtil.less(arr[j], arr[min])) {
					min = j;
				}
			}
			noOfExchanges++;
			SortUtil.exchange(arr, i, min);
		}
		System.out.println("Comparisons Selection Sort : " + noOfComparisons);
		System.out.println("Exchanges Selection Sort : " + noOfExchanges);
	}
}
