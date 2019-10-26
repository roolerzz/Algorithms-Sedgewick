package com.algorithm.sorting.attemptII;
import com.algorithm.sorting.MergeSort;

import java.util.Arrays;

public class BottomUpMergeSort {

    public MergeSort instance = new MergeSort();

    public void bottomUpMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
//        int arr2[] = null ;
//        Comparable[] aux = Arrays.copyOf(arr, arr.length);
//        for(int i = i ; i < arr.length ; i++) {
//
//        }
        for (int sz = 1; sz < arr.length; sz=2*sz) {
            for (int lo = 0 ; lo < arr.length; lo = lo + 2*sz) {
                int hi = lo + 2*sz -1 ;
                int mid = lo + (hi-lo)/2;
                instance.merge(arr, aux,  lo, mid, hi);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = {4, 6, 10, 3, 7, 9, 2, 1};
        BottomUpMergeSort ms = new BottomUpMergeSort();
        System.out.println("Array before sorting");
        printArray(arr);
        ms.bottomUpMergeSort(arr);
        System.out.println("Array after sorting");
        printArray(arr);

    }

    public static void printArray(Comparable[] arr){
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " -> ");
        }
    }
}
