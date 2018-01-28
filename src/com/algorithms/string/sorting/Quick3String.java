package com.algorithms.string.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3String {
	// cutoff to insertion sort, when size of sub-array goes less than 15.
	private static final int CUTOFF = 15;
	
	public static void sort(String[] a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1,0);
		assert isSorted(a);
	}
	
	private static void sort(String[] a, int lo, int hi, int d) {
		
		// cutoff to insertion sort
		if(hi < lo + CUTOFF) {
			insertion(a,lo,hi,d);
			return;
		}
		
		  int lt = lo, gt = hi;
		  int v = charAt(a[lo],d);
		  int i = lo + 1;
		  while(i < gt) {
			  int t = charAt(a[i],d);
			  if(t<v) exch(a,lt++,i++);
			  else if (t>v) exch (a,i,gt--);
			  else i++;
		  }
		  
		  sort(a,lo,lt-1,d);
		  if(v>=0) sort(a,lt,gt,d+1);
		  sort(a,gt+1,hi,d);
	}
	
	private static void insertion(String[] a, int lo, int hi, int d) {
		for(int i = lo ; i <= hi ; i++) {
			for(int j = i; j > lo && less(a[j],a[j-1],d) ; j--) {
				exch(a,j,j-1);
			}
		}
	}
	
	private static boolean less(String s1,String s2, int d) {
		assert s1.substring(0, d).equals(s2.substring(0, d));
		for(int i = d; i < Math.min(s1.length(), s2.length()); i++) {
			if(s1.charAt(i) < s2.charAt(i)) return true;
			else if (s1.charAt(i)> s2.charAt(i)) return false;
		}
		return s1.length() < s2.length();
	}
	private static boolean isSorted(String[] a) {
		for(int i = 1 ; i < a.length ; i++) {
			if(a[i].compareTo(a[i-1]) < 0)
				return false;
		}
		return true;
	}
	private static void exch(String[] s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j]=temp;
		
	}
	private static int charAt(String s, int d) {
		assert d>0 && d <= s.length();
		if(d == s.length()) return -1;
		else return s.charAt(d);
	}
	
	   public static void main(String[] args) {
	        // read in the strings from standard input
			In in = new In(args[0]);
		  	String[] a = in.readAllStrings();
	        int n = a.length;
	        // sort the strings
	        sort(a);
	        // print the results
	        for (int i = 0; i < n; i++)
	            StdOut.println(a[i]);
	    }
	
}
