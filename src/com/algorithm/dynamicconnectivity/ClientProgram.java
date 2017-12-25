package com.algorithm.dynamicconnectivity;

import com.dataStructures.MyLinkedList;

public class ClientProgram {
	public static void main(String[] args){
	MyLinkedList list= new MyLinkedList();
	System.out.println(list);
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);
	list.add(50);
	list.add(60);
	list.add(70);
	list.add(80);
	list.insetAtEnd(1);
	list.deleteFromBegining();
	list.deleteFromEnd();
	System.out.println(list);
	}
}