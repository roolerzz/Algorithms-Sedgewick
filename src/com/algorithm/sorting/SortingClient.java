package com.algorithm.sorting;

public class SortingClient {

	public static void main(String[] args) {
		Comparable[] arr = new Comparable[12*31];
		
		int counter = 0;
		for(int i = 12 ; i >= 1 ; i--) {
			for (int j = 31; j >=1 ; j--) {
				ComparableDate date = new ComparableDate(1991,i,j);
				arr[counter++] = date;
			}
		}
		Comparable[] arr2  = new Comparable[12*31];
		int counter2= 0;
		for(int i = 12 ; i >= 1 ; i--) {
			for (int j = 31; j >=1 ; j--) {
				ComparableDate date = new ComparableDate(1991,i,j);
				arr2[counter2++] = date;
			}
		}
		
		InsertionSort insertion = new InsertionSort(); 
		SelectionSort selection= new SelectionSort();
		insertion.sort(arr);
		selection.sort(arr2);
	}

}
