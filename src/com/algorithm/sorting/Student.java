package com.algorithm.sorting;

import java.util.Comparator;

public class Student {

	public static final Comparator<Student> NAME_COMPARATOR = new NameComparator();
	public static final Comparator<Student> DOB_COMPARATOR = new RollNoComparator();
	public static final Comparator<Student> ROLL_COMPARATOR = new AgeComparator();
	
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
	
	public Student(int rollNo, String name, ComparableDate dob) {
		this.rollNo = rollNo;
		Name = name;
		this.dob = dob;
	}
	
	private static class NameComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.Name.compareTo(o2.Name);
		}
	}
	private static class AgeComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.dob.compareTo(o2.dob);
		}
	}
	private static class RollNoComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.rollNo-o2.rollNo;
		}
	}
	
	
}
