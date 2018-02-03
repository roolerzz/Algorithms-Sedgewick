package com.algorithms.string.processing;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GREP {
	private GREP() {
	}
	public static void main(String[] args) {
		String regexp = "(.*" + args[0] + ".*)";
		  NFA nfa = new NFA(regexp);
		  In in = new In(args[1]);
	        while (in.hasNextLine()) { 
	            String line = in.readLine();
	            if (nfa.recognizes(line)) {
	                StdOut.println(line);
	            }
	        }
	}
}
