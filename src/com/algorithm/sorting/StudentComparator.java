package com.algorithm.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class StudentComparator {

	public static final Comparator<StudentComparator> NAME_COMPARATOR = new NameComparator();
	public static final Comparator<StudentComparator> DOB_COMPARATOR = new RollNoComparator();
	public static final Comparator<StudentComparator> ROLL_COMPARATOR = new AgeComparator();
	
	private int rollNo;
	
	private String Name;
	
	private ComparableDate dob;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ComparableDate getDob() {
		return dob;
	}
	public void setDob(ComparableDate dob) {
		this.dob = dob;
	}
	
	public StudentComparator(int rollNo, String name, ComparableDate dob) {
		this.rollNo = rollNo;
		Name = name;
		this.dob = dob;
	}
	
	private static class NameComparator implements Comparator<StudentComparator>{
		@Override
		public int compare(StudentComparator o1, StudentComparator o2) {
			return o1.Name.compareTo(o2.Name);
		}
	}
	private static class AgeComparator implements Comparator<StudentComparator>{
		@Override
		public int compare(StudentComparator o1, StudentComparator o2) {
			return o1.dob.compareTo(o2.dob);
		}
	}
	private static class RollNoComparator implements Comparator<StudentComparator>{
		@Override
		public int compare(StudentComparator o1, StudentComparator o2) {
			return o1.rollNo-o2.rollNo;
		}
	}
	/*public class SortingClient {

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
			
		}*/
	
}
