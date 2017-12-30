package com.algorithm.sorting;

public class SortUtil{

	public static void exchange(Comparable[] arr, int i, int j){
		Comparable obj = arr[i];
		arr[i] = arr[j];
		arr[j] = obj;
	}
	
	public static boolean less(Comparable a, Comparable b){
		// A's compareTo method should throw exception in case of incompatible objects.
		return a.compareTo(b) < 0;
	}	
	public static void printArrayComparable(Comparable[] arr) {
		int len = arr.length;
		System.out.println();
		for(int i=0; i<len;i++) {
			System.out.print(":" + arr[i]);
		}
	}
	public static void printArray(Student[] arr) {
		int len = arr.length;
		System.out.println();
		for(int i=0; i<len;i++) {
			System.out.print(" Name :" + arr[i].getName() + " Roll :" + arr[i].getRollNo() + " DOB :" + arr[i].getDob());
		}
		System.out.println();
	}
	
}