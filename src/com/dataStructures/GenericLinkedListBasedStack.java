package com.dataStructures;

import java.util.Iterator;

public class GenericLinkedListBasedStack<Item> implements Iterable<Item>{
	
	public class ListIterator implements Iterator<Item> {
		
		private Node current = first;
			
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}


	private Node first;

	private class Node {
		Item item;
		Node next;		
	}
	
	public void push(Item obj){
// Redundant Code.
//		if(isEmpty()){
//			first = new Node();
//			first.item=obj;
//			return;
//		}
			Node oldFirst = first;
			first = new Node();
			first.item=obj;
			first.next=oldFirst;
	}
	

	public void pop(){
		if(isEmpty())
			{
			System.out.println("Cannot delete from an empty Stack. Stack Underflow");
			return;
			}
		System.out.print(first.item + " ");
		first = first.next;
	}
	
	public boolean isEmpty(){
		return first==null;
	}


	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	/*@Override
	public String toString() {
		String textToPrint= "Empty Stack";
			if (first == null)
				return textToPrint;
			Node traversalNode = first;
			textToPrint = "";
			while(traversalNode.next!=null) {
				textToPrint= textToPrint.concat(traversalNode.item.toString());
				textToPrint = textToPrint.concat(" ");
				traversalNode = traversalNode.next;
			}
			textToPrint= textToPrint.concat(traversalNode.item.toString());
		return textToPrint;
	}*/
}

/*public class ClientProgram {
	public static void main(String[] args){
		GenericLinkedListBasedStack<String> stack = new GenericLinkedListBasedStack<String>();
	System.out.println(stack);
	stack.push("to");
	stack.push("be");
	stack.push("or");
	stack.push("not");
	stack.push("to");
	stack.pop();
	stack.push("be");
	stack.pop();
	stack.pop();
	stack.push("that");
	stack.pop();
	stack.pop();
	stack.pop();
	stack.push("is");
	for(String s : stack) {
		System.out.println("String is : " + s);
	}
	System.out.println(stack);
	}
}*/