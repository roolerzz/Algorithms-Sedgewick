package com.algorithm.sorting;

public class ComparableDate implements Comparable<ComparableDate>{
	
	private int year;
	private int month;
	private int day;
	
	public ComparableDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int compareTo(ComparableDate obj){
		if(this.year < obj.year) return -1;		
		if(this.year > obj.year) return 1;
		if(this.month < obj.month) return -1;		
		if(this.month > obj.month) return 1;
		if(this.day < obj.day) return -1;		
		if(this.day > obj.day) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return month+"/"+day+"/"+year;
	}
	
}