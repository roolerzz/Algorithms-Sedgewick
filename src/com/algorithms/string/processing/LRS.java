package com.algorithms.string.processing;

import java.util.Arrays;

public class LRS {

	// given a string find the Longest repeated substring.
	
	private LRS() {
		
	}
	public static String lrs(String s) {
		// Create suffix array for the strings.
		String lrs = "";
		int N = s.length();
		String suffix[] = new String[N];
		for(int i = 0 ; i < N ; i++) {
			suffix[i] = s.substring(i, N);
		}
		// Sort the suffixes array 
		Arrays.sort(suffix);
		// find the repeatest stings by computing Longest common prefixes for pairs of consecutive string in the sorted suffixes array.
		int i =1;
		while(i<N)
		{
			int lcp = LCP.findLengthLCP(suffix[i], suffix[i-1]);
			if( lrs.length() < lcp) {
				lrs = suffix[i].substring(0, lcp);
			}
			i++;
		}
		return lrs;
	}
	
	public static void main(String[] args) {
		String s = "acaagtttacaagc";
		String s2 = "it was the best of times it was the";
		System.out.println(lrs(s));
		System.out.println(lrs(s2));
	}
}
