package com.algorithm.sorting;

public class BottomUpMergeSort{

	private static MergeSort instance = new MergeSort(); 

	public void sort(Comparable[] arr){
		int N = arr.length;
		System.out.println();
		Comparable[] aux = new Comparable[N];
		for(int sz = 1 ; sz <2*N ; sz = 2*sz){
			for(int j = 0; j<N ; j = j + sz){
				int low = j;
				int high = Math.min(j+sz-1, N-1);
				int mid = low + (high-low)/2;
				
				System.out.println("Merging Low : "+ low + " Mid : " + mid + " high : " + high);
				instance.merge(arr,aux,low,mid,high);
			}		
		}
	}
}