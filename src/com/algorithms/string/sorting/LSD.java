package com.algorithms.string.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 *  The {@code LSD} class provides static methods for sorting an
 *  array of <em>w</em>-character strings or 32-bit integers using LSD radix sort.
**/
public class LSD {
	
	private static final int BITS_PER_BYTE = 8;
	
	private LSD() {}
	
	public static void sort(String[] a , int w) {
		int n = a.length;
		int R = 256;
		String[] aux = new String[n];
		
		for(int d = w-1 ; d >=0 ; d--) {
			int[] count = new int[R+1];
			// compute frequency count of each character at dth position.
			for(int i = 0; i < n ; i++) {
				count[a[i].charAt(d)+1]++;
			}
			// compute cumulates.
			for(int r = 0 ; r < R ; r++) {
				count[r+1] += count[r];
			}
			// move data to auxiliary array.
			for(int i = 0 ; i < n ; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			// copy back to original array strings sorted by dth character in last pass..
			for(int i = 0 ; i < n ; i++) {
				a[i] = aux[i];
			}
		}
		
	}
	
	public static void sort(int[] a) {
		// break each integer into a string of 4 character representations.
		final int bits = 32;
		final int R = 1 << BITS_PER_BYTE;
		final int mask = R-1;
		final int w = bits/BITS_PER_BYTE;
		int n = a.length;
		int aux[] = new int[n];
		
		for(int d = 0; d < w ; d++) {
			// compute the frequency count.
			int count[] = new int[R+1];
			for(int i = 0 ; i < n ; i++) {
				int c = (a[i] >> BITS_PER_BYTE * d) & mask;
				count[c+1]++;
			}
			// find the cumulates.
			for(int r = 0 ; r < R ; r++) {
				count[r+1] += count[r];
			}
			
			// for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }
			
			//move the data
			for(int i = 0 ; i < n ; i++) {
				int c = (a[i]>>BITS_PER_BYTE*d) & mask;
				aux[count[c]++] = a[i];
			}
			for(int i = 0 ; i < n ; i++) {
				a[i]=aux[i];
			}
		}
	}
	 /**
	 * @param args
	 */
	public static void main(String[] args) {
			In in = new In(args[0]);
	        String[] a = in.readAllStrings();
	        int n = a.length;

	        // check that strings have fixed length
	        int w = a[0].length();
	        for (int i = 0; i < n; i++)
	            assert a[i].length() == w : "Strings must have fixed length";

	        // sort the strings
	        sort(a, w);

	        // print results
	        for (int i = 0; i < n; i++)
	            StdOut.println(a[i]);
	
		 
	// int R = 1 << 8;
	// System.out.println(R);
		 
	 }
	
	
}
