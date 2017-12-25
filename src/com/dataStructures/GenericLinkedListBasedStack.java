package com.dataStructures;

public class GenericLinkedListBasedStack<Item>{
	
	private Node first = null; 

	private class Node {
		Item item;
		Node next;		
	}
	
	public void push(Item obj){
		if(isEmpty()){
			first = new Node();
			first.item=obj;
			return;
		}
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
	LinkedListStackOfStrings stack = new LinkedListStackOfStrings();
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
	System.out.println(stack);
	}
}*/