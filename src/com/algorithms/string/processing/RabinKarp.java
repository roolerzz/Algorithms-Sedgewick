package com.algorithms.string.processing;

import java.math.BigInteger;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class RabinKarp {

	private String pat;
	
	private long patHash;
	
	private int m;
	
	private long q; // a large prime, small enough to avoid long overflow.
	
	private int R; // radix
	
	private long RM; //R^(M-1) 
	
	public RabinKarp(char[] pattern , int R) {
		
	}
	
	public RabinKarp(String pat) {
		this.pat = pat;
		R = 256;
		m = pat.length();
		q = longRandomPrime();
		RM = 1;
		for(int i = 1; i <= m-1 ; i++) 
			RM = (R*RM) % q;
		patHash = hash(pat,m);
		
	}
	// compute hash for key [0..m-1]
	private long hash(String key, int m) {
		long h = 0;
		for(int j = 0 ; j < m ; j++) 
			h = (R*h + key.charAt(j))%q;
		return h;
	}
	
	 // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
    
    
    private boolean check(String txt,int i) {
    	for(int j =0 ; j < m ; j++)
    		if(pat.charAt(j)!=txt.charAt(i+j))
    			return false;
    	return true;
    }
    
    // Las vegas version as Check;s method is there to avoid false positives by hash function. Probability 1/Q.
    public int search(String txt) {
    	int n = txt.length();
    	if(n<m)return n;
    	long txtHash = hash(txt,m);
    	// check for match @ offset 0.
    	if((patHash==txtHash) && check(txt,0))
    		return 0;
    	for(int i = m; i < n ; i++) {
    		txtHash = (txtHash + q - RM*txt.charAt(i-m)%q)%q; // removing the starting digit.
    		txtHash = (txtHash*R + txt.charAt(i))%q;// adding new digit's hash.
    		int offset = i-m+1;
    		if(patHash == txtHash && check(txt,offset))
    		return offset;
    	}
    	//no match
    	return n;
    }
	
    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        // from brute force search method 1
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
    
}
