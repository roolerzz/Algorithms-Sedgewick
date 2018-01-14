package com.dataStructures.graph;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphClient {

	    public static void main(String[] args) {
	        File f = new File("tinyG.txt");
	        if(f.exists()) {
	        	System.out.println("File found");
	        }
	    	In in = new In(args[0]);
	        AdjacencyListGraph G = new AdjacencyListGraph(in);
	        StdOut.println(G);
	    }
}
