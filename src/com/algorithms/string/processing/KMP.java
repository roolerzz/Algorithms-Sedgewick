package com.algorithms.string.processing;

import edu.princeton.cs.algs4.StdOut;

public class KMP {

	private final int R;
	
	private int[][] dfa;
	
	private char[] pattern;
	
	private String pat;
	
	public KMP(String pat) {
		this.R = 256;
		this.pat = pat;
		//build DFA from pattern
		int m = pat.length();
		dfa = new int[R][m];
		dfa[pat.charAt(0)][0] = 1;
		for (int x = 0, j = 1; j < m; j++) {
			for(int c = 0 ; c < R ; c++) {
				dfa[c][j] = dfa[c][x]; // copy mismatch cases.
			}
			dfa[pat.charAt(j)][j] = j + 1;
			x = dfa[pat.charAt(j)][x]; // update the restart state.
			// X is the state at any point in time, where DFA would be if it was simulated on ,
			// the string pat[1..j-1], and any mismatch character would be in the DFA would be in the same state,
			// as if the mismatch character came at state X.
		}
	}
	
	public KMP(char[] pattern, int R) {
		this.R = R; 
		this.pattern = new char[pattern.length];
		// initialize the copy of the array. 
		for (int j = 0 ; j < pattern.length ; j++) {
			this.pattern[j] = pattern[j];
		}
		// build DFA from pattern.
		int m = pattern.length;
		dfa = new int[R][m];
		dfa[pattern[0]][0] = 1;
		for(int x = 0 , j = 1 ; j < m ; j++) {
			for(int c = 0 ; c < R ; c++) {
				dfa[c][j] = dfa[c][x];
			}
			dfa[pattern[j]][j] = j+1 ;
			x = dfa[pattern[j]][x];
		}
	}
	
	public int search(String txt) {
		int m = pat.length();
		int n = txt.length();
		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) 
			j = dfa[txt.charAt(i)][j];
		if (j == m) 
			return i-m;
		return n;	// not found. returned the index = length of the string, 1 position after the last character in the string.
	}
	
	public int search(char[] text) {
		int m = pattern.length;
		int n = text.length;
		int i,j;
		for(i=0,j=0; i<n && j<m ; i++) 
			j = dfa[text[i]][j];
		if(j==m) 
			return i-m;
		return n;
	}
	
	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		char[] pattern = pat.toCharArray();
		char[] text = txt.toCharArray();
		
		KMP kmp1 = new KMP(pat);
		int offset1 = kmp1.search(txt);
		
		KMP kmp2 = new KMP(pattern,256);
		int offset2 = kmp2.search(text);
		// print results
        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            StdOut.print(" ");
        StdOut.println(pat);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset2; i++)
            StdOut.print(" ");
        StdOut.println(pat);
	}
	
	
}
