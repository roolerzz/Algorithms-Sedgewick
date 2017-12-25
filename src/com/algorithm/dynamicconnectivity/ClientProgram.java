package com.algorithm.dynamicconnectivity;

import com.algorithm.searching.BinarySearchInSortedArray;

public class ClientProgram {
	public static void main(String[] args){

	BinarySearchInSortedArray bs = new BinarySearchInSortedArray();
	System.out.println("Number of elements in array : " + bs.getArray().length);
	bs.findKey(212);	
	bs.findKey(-253);
	}
}