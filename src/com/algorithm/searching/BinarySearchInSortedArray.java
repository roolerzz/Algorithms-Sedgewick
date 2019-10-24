package com.algorithm.searching;

public class BinarySearchInSortedArray{

	private int[] arr;

	public int[] getArray(){
		return arr;
	}	

	public BinarySearchInSortedArray(){
		arr = new int[] {10,35,51,75,81,89,123,149,189,200,211,253};	
	}
	
	public boolean findKey(int key){
		int lowInd = 0;
		int highInd = arr.length-1;
		int iterations= 0;
		while(lowInd<=highInd){
			iterations++;
			int midInd = lowInd + (highInd-lowInd)/2;
			if(arr[midInd]==key){
			System.out.println("Key : "+key + " Found");
			System.out.println("Iterations if key found:" + iterations);
			return true;
			}
			else if (key<arr[midInd]){
			highInd = midInd -1;
			}
			else {
			lowInd = midInd + 1;
			}			
		}	
		System.out.println("Key : " + key + " not present in the array.");
		System.out.println("Iterations if key not found:" + iterations);
		return false;
	}

	public static void main(String[] args) {
		BinarySearchInSortedArray barr = new BinarySearchInSortedArray();
		barr.findKey(20);
		barr.findKey(10);
		barr.findKey(123);
	}
}