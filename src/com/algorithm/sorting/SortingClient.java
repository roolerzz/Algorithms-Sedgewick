package com.algorithm.sorting;

import java.util.Arrays;

public class SortingClient {

		public static void main(String[] args){
			Student[] arr = new Student[20];
			String[] random = {"C","S","D","Z","T","C","S","D","Z","T","C","S","D","Z","T","C","S","D","Z","T"};
			for(int i=0;i<20;i++) {
				ComparableDate dob = new ComparableDate(1991,(i+1),1);
				Student student = new Student((i+1), random[i]+(i+1),dob);
				arr[i] = student;
			}
			
			System.out.println("Comparing DOB");
			Arrays.sort(arr, Student.DOB_COMPARATOR);
			SortUtil.printArray(arr);
			System.out.println("Comparing Names");
			Arrays.sort(arr,Student.NAME_COMPARATOR);
			SortUtil.printArray(arr);
			System.out.println("Comparing Roll Numbers");
			Arrays.sort(arr,Student.ROLL_COMPARATOR);
			SortUtil.printArray(arr);
			
		}

}
