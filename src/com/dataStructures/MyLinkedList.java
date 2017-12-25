package com.dataStructures;

public class MyLinkedList {
	
	Node first; 
	
	public MyLinkedList(){
		first = null;
	}


	private class Node {
		Object item;
		Node next;		
	}
	
	public void add(Object obj) {
		insertAtBegining(obj);
	}
	
	public void insertAtBegining(Object obj){
		if(isListEmpty()){
			first = new Node();
			first.item=obj;
			return;
		}
			Node oldFirst = first;
			first = new Node();
			first.item=obj;
			first.next=oldFirst;
	}
	

	public void deleteFromBegining(){
		if(isListEmpty())
			{
			System.out.println("Cannot delete from an empty linked list");
			return;
			}
		first = first.next;
	}

	public void deleteFromEnd(){
		if(isListEmpty())
			{
			System.out.println("Cannot delete from an empty linked list");
			return;
			}
		Node secondLast = findSecondLast();
		secondLast.next = null;
	}

	public void insetAtEnd(Object obj){
		if(isListEmpty()){
			first = new Node();
			first.item=obj;
			return;
		}
		Node oldLast = findLast();
		Node newNode = new Node();
		newNode.item = obj;
		oldLast.next= newNode;
		oldLast= oldLast.next;
	}
	
	public Node findSecondLast(){
		if(isListEmpty())
		{
			System.out.println("Second Last element doesnot exists in an empty list.");	
			return null;
		}
		Node last = first.next;
		Node secondLast = new Node(); 
		while(last.next!=null){
			secondLast = last;
			last = last.next;
		}
		return secondLast;
	}

	public Node findLast(){
		if(isListEmpty())
		{
			System.out.println("Last element doesnot exists in an empty list.");	
			return null;
		}
		Node last = first.next;
		while(last.next!=null){
			last = last.next;
		}
		return last;
	}
	
	public boolean isListEmpty(){
		if(first==null){
			System.out.println("Linked List is empty");
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String textToPrint= "Empty Linked List";
			if (first == null)
				return textToPrint;
			Node traversalNode = first;
			textToPrint = "";
			while(traversalNode.next!=null) {
				textToPrint= textToPrint.concat(traversalNode.item.toString());
				textToPrint = textToPrint.concat(":");
				traversalNode = traversalNode.next;
			}
			textToPrint= textToPrint.concat(traversalNode.item.toString());
			textToPrint = textToPrint.concat(":");
		return textToPrint;
	}
	
	/*public void printList(){
		if(first != null) {
			while(first.next!=null) {
				System.out.println(first.item);
				first
			}
		}
	}*/
	
}
