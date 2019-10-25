package com.algorithm.sorting;

public class MergeSort {

	public void sort(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		sort(arr, aux , 0, arr.length-1);
	}

	private void sort(Comparable[] arr, Comparable[] aux ,int low, int high) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;
		sort(arr, aux, low, mid);
		sort(arr, aux ,mid + 1, high);
		merge(arr, aux ,low, mid, high);
	}

	public void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
		// copying to auxilliary array before merging.
		int i = low;
		int j = mid + 1;
		for(int k = low; k<=high ; k++) {
			aux[k] = arr[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid)
				arr[k] = aux[j++];
			else if (j > high)
				arr[k] = aux[i++];
			else if (SortUtil.less(aux[j], aux[i]))
				arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}

	}

	public static void main(String[] args) {
		Comparable[] arr = {4, 6, 10, 3, 7, 9, 2, 1};
		MergeSort ms = new MergeSort();
		System.out.println("Array before sorting");
		printArray(arr);
		ms.sort(arr);
		System.out.println("Array after sorting");
		printArray(arr);

	}

	public static void printArray(Comparable[] arr){
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " -> ");
		}
	}

}