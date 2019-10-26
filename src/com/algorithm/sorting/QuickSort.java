package com.algorithm.sorting;

import edu.princeton.cs.algs4.Knuth;

import java.util.Random;

public class QuickSort{

	public void sort(Comparable[] arr){
		sort(arr,0,arr.length-1);
	}
	
	public void threeWaySort(Comparable[] arr){
		threeWaySort(arr,0,arr.length-1);
	}
	
	// Find the position of a random pivot element. Recursively sort on first and 2nd halves. 
	private void sort(Comparable[] arr, int lo, int hi){
		if(lo>=hi) { return;}
		int pivot = partition(arr,lo,hi);
		sort(arr,lo,pivot-1);
		sort(arr,pivot+1,hi);
	}
	
	// Making it public so that other class could re-utilize the code.
	public int partition(Comparable[] arr, int lo, int hi){
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
	
	// Find the position of a random pivot element. Recursively sort on first and 2nd halves. 
	private void threeWaySort(Comparable[] arr, int lo, int hi){
		if(lo>=hi) { return;}
		int[] pivotRange = threeWayPartition(arr,lo,hi);
		System.out.println("Partition Range :" + pivotRange[0] +" : " + pivotRange[1] + " : ");
		threeWaySort(arr,lo,pivotRange[0]-1);
		threeWaySort(arr,pivotRange[1]+1,hi);
	}
	
	// Adjusted indexes compared to old partition method.
	public int[] threeWayPartition(Comparable[] arr, int lo, int hi) {
		Comparable aux[] = new Comparable[arr.length];
		int[] pivotRange = {-1,-1};
		int i=lo+1;
		int lt=lo;
//		int gt=hi+1;
		int gt=hi;
		/*if(i==gt) { return lo;}*/
		Random generator = new Random();
		int r = lo + generator.nextInt(hi-lo+1);
		SortUtil.exchange(arr,r,lo);
		int count = 0;
		for(Comparable item : arr) {
			aux[count++]=item;
		}
		Comparable item = arr[lo];
		while(i<=gt) {
			if(SortUtil.less(arr[i], item)) {
				SortUtil.exchange(arr, i, lt+1);
				i++;
				lt++;
			}
			else if (SortUtil.less(item,arr[i])) {
				SortUtil.exchange(arr, i, gt--);
			}
			else {
				i++;
			}
		}
		SortUtil.exchange(arr, lo, lt);
		System.out.println("Printing after partition : ");
		SortUtil.printArrayComparable(arr);
		pivotRange[0]=lt;
		pivotRange[1]=gt;
		return pivotRange;
	}

	public static void main(String[] args) {
		Comparable[] arr = {1,2,3,4,4,4,5,5,5,6,6,7,7,7,10,11,15,22,36};
		Knuth.shuffle(arr);
		System.out.println("Array After shuffling");
		MergeSort.printArray(arr);
		QuickSort s = new QuickSort();
		s.threeWaySort(arr);
		System.out.println("Array After Sorting");
		MergeSort.printArray(arr);
	}
	
}
