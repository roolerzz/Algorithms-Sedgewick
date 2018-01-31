package com.algorithms.string.processing;

public class LCP {

	// Given 2 strings find the logest common prefix of the strings.
	private LCP(){
	}
	
	public static int findLengthLCP(String s1, String s2) {
		if(s1 == null || s2 == null) return 0;
		int length = Math.min(s1.length(), s2.length());
		for(int i = 0 ; i < length; i++)
			if(s1.charAt(i) != s2.charAt(i)) return i;
		return length;
	}
	
	public static void main(String[] args) {
		String s1 = "to be";
		String s2 = "to be or not to be";
		if(findLengthLCP(s1, s2)!=0)
			System.out.println(s1.substring(0,findLengthLCP(s1, s2)));
	}
}
