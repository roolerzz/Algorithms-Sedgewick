package com.dataStructures;

public class LinkedListBasedQueueOfStrings{
	//FIFO. Need 2 variables 1 to track first node and 1 to track last. First is where deletion(dequeue) would be done and last is where addition(enqueue).	

	private Node first = null; 

	private Node last = null;

	private class Node {
		String item;
		Node next;		
	}
	
	// insert at the last of the linked list
	public void enqueue(String obj){
		Node oldLast = last;
		last = new Node();
		last.item=obj;
		
		if(isEmpty()){
			first = last;
			}
		else
			oldLast.next=last;
	}
	
	// remove from the start of the queue.
	public void dequeue(){
		if(isEmpty())
			{
			System.out.println("Cannot delete from an empty Queue.");
			return;
			}
		System.out.print(first.item + " ");
		first = first.next;
		if(isEmpty()) {
			last = null;
		}
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
	LinkedListQueueOfStrings queue = new LinkedListQueueOfStrings();
	queue.enqueue("to");
	queue.enqueue("be");
	queue.enqueue("or");
	queue.enqueue("not");
	queue.enqueue("to");
	queue.dequeue();
	queue.enqueue("be");
	queue.dequeue();
	queue.dequeue();
	queue.enqueue("that");
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.enqueue("is");
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	}
}*/