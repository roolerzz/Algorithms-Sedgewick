package com.algorithm.sorting;

public class MergeSort {

	public void sort(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		sort(arr, aux , 0, arr.length-1);
	}

	private void sort(Comparable[] arr, Comparable[] aux ,int low, int high) {
		int mid = low + (high - low) / 2;
		if (low >= high)
			return;
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

}