package com.algorithm.sorting;

import java.util.Random;

public class Shuffling {

	public void shuffle(Comparable[] arr){
		int N = arr.length;
		Random generator = new Random();
		Integer[] rand = new Integer[N];
		for(int i=0;i<N;i++){
			rand[i]= generator.nextInt(N+1);
		}
		shuffleSort(arr,rand);
	}

	// Used insertion sort to sort an array of randomly generated numbers and accordingly shuffled the normal deck of cards.
	private void shuffleSort(Comparable[] arr,Comparable[] rand){
		int len = arr.length;
		/*System.out.println("Before Shuffling");*/
		printArrays(arr, rand, len);
		for(int k = 0; k<len-1 ; k++){
			for(int j = k+1; j>0; j--){
				if(SortUtil.less(rand[j],rand[j-1])){
					SortUtil.exchange(rand,j,j-1);
					SortUtil.exchange(arr,j,j-1);
				}
			}
		}
		/*System.out.println("After Shuffling");*/
		printArrays(arr, rand, len);
	}

	private void printArrays(Comparable[] arr, Comparable[] rand, int len) {
		/*for(int i=0;i<len;i++) {
			System.out.print(": " + rand[i]);
		}*/
		System.out.println();
		for(int i=0;i<len;i++) {
			System.out.print(": " + arr[i]);
		}
		
	}
}