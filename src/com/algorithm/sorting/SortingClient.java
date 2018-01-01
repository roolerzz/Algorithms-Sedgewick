package com.algorithm.sorting;

import com.dataStructures.BinaryHeapMaxPriorityQueue;
import com.dataStructures.MinPriorityQueueOrderedArray;

public class SortingClient {

		public static void main(String[] args){
			/*StudentComparator[] arr = new StudentComparator[20];
			String[] random = {"C","S","D","Z","T","C","S","D","Z","T","C","S","D","Z","T","C","S","D","Z","T"};
			for(int i=0;i<20;i++) {
				ComparableDate dob = new ComparableDate(1991,(i+1),1);
				StudentComparator student = new StudentComparator((i+1), random[i]+(i+1),dob);
				arr[i] = student;
			}*/
			
			/*System.out.println("Comparing DOB");
			Arrays.sort(arr, StudentComparator.DOB_COMPARATOR);
			SortUtil.printArray(arr);
			System.out.println("Comparing Names");
			Arrays.sort(arr,StudentComparator.NAME_COMPARATOR);
			SortUtil.printArray(arr);
			System.out.println("Comparing Roll Numbers");
			Arrays.sort(arr,StudentComparator.ROLL_COMPARATOR);
			SortUtil.printArray(arr);*/
		
			Integer arr[] = {11,12,13,14,15,16,17,18,19,20};
			
			/*Integer arr[] = new Integer[10];
			
			
			for(int i=0;i<10;i++) {
				arr[i]=i+1;
			}*/
			Shuffling shuffle = new Shuffling();
			shuffle.knuthShuffle(arr);
			/*SortUtil.printArrayComparable(arr);*/
			BinaryHeapMaxPriorityQueue<Integer> pq = new BinaryHeapMaxPriorityQueue<>(10);
			for(int i=0;i<10;i++) {
				pq.insert(arr[i]);
				System.out.println("Printing after inserting : " + arr[i] );
				pq.printQueue();
			}
			System.out.println();
			pq.insert(22);
			pq.insert(25);
			pq.insert(27);
			/*System.out.println(pq.delMin());
			System.out.println(pq.delMin());
			System.out.println(pq.delMin());
			System.out.println(pq.delMin());
			System.out.println(pq.delMin());*/
			pq.printQueue();
			
			/*QuickSort quick = new QuickSort();
			quick.threeWaySort(arr);
			System.out.println("Printing final array");
			SortUtil.printArrayComparable(arr);*/
			/*Random rand = new Random();
			int k = rand.nextInt(arr.length) + 1;
			System.out.println(" ##" + k + " Smallest element : " + arr[k-1]);
			SortUtil.printArrayComparable(arr);
			shuffle.knuthShuffle(arr);
			SortUtil.printArrayComparable(arr);
			QuickSelect quickS = new QuickSelect();
			System.out.println(" ##" + k + " Smallest element : " + quickS.selectKthSmallest(arr, k));
			SortUtil.printArrayComparable(arr);*/
		}

}
