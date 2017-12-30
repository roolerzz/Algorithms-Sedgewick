package com.algorithm.sorting;

public class BottomUpMergeSort{

	private static MergeSort instance = new MergeSort(); 

	public void sort(Comparable[] arr){
		int N = arr.length;
		System.out.println();
		Comparable[] aux = new Comparable[N];
		for(int sz = 1 ; sz < N ; sz = 2*sz){
			for(int low = 0; low<N-sz ; low = low + 2*sz){
				int mid = low + sz -1;
				int high = Math.min(low + 2* sz-1, N-1);
				System.out.println("Merging Low : "+ low + " Mid : " + mid + " high : " + high);
				instance.merge(arr,aux,low,mid,high);
			}
			System.out.println("Printing after each size");
			SortUtil.printArrayComparable(arr);
		}
	}
}