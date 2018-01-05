package com.algorithm.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

import com.dataStructures.BinarySearchTree;

public class SortingClient {

		public static void main(String[] args){
			BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>(); 
			st.put("A", 8);
			st.put("C", 4);
			st.put("E", 12);
			st.put("H", 5);
			st.put("L", 11);
			st.put("M", 9);
			st.put("P", 10);
			st.put("R", 3);
			st.put("S", 0);
			st.put("X", 7);
			st.put("C", 17);
			System.out.println(st.get("Z"));
			System.out.println(st.get("S"));
			System.out.println(st.get("C"));
			System.out.println(st.get("X"));
			System.out.println(st.get("R"));
			Queue<String> q = (PriorityQueue<String>) st.keys("D","Z");
			for (String elem : q) {
				System.out.print(" : " + elem);
			}
			//st.printST();
			try {
			/*st.delete("F");
			st.delete("C");
			st.delete("E");
			st.delete("H");
			st.delete("L");
			st.delete("M");
			st.delete("P");
			st.delete("R");
			st.delete("S");
			st.delete("X");
			st.delete("C");
			st.delete("F");
			st.delete("X");*/
			} catch(Exception e) {
				//e.printStackTrace();
			}
			/*st.printST();*/
		}

}
