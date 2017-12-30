package com.algorithm.sorting;

public class SortingClient {

		public static void main(String[] args){
			Integer[] deck = new Integer[10];
			int len=deck.length;
			for(int i=0; i<len ; i++){
				deck[i] =(i+1);
			}
			
			Shuffling shuffling = new Shuffling();
			SortUtil.printArray(deck);
			shuffling.knuthShuffle(deck);
			SortUtil.printArray(deck);
			MergeSort merge = new MergeSort();
			merge.sort(deck);
			SortUtil.printArray(deck);
		}

}
