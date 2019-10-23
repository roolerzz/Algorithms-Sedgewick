package com.dataStructures;

public class ResizeableArrayBasedQueueOfStrings {
	// Earlier we needed to provide the size of the array before hand, to
	// initialize, which is kind of the restriction in cases, where client
	// does not know what is number of elements its gonno insert in the stack. To
	// work with that limitation, we need to resize the array.
	// Everytime in case of push operation, if the stack is full, create a new array
	// with double the size, copy the existing contents onto the new
	// and return the array. In case of pop, operation, to optimize that alot of
	// space is not wasted, everytime the array is 1/4 of its size full,
	// create a new array with half the size and move elements to that.

	private String[] arr;

	private int head = 0;

	private int tail = 0;

	public ResizeableArrayBasedQueueOfStrings() {
		arr = new String[1];
	}

	public void enqueue(String obj) {
		int length = arr.length;
		if ((tail - head) == length) {
			resize(2 * length);
		} else if (tail == length) {
			moveArrayBack();
		}
		arr[tail++] = obj;

	}

	private void moveArrayBack() {
		System.out.println("Array Moved Back");
		int counter = head;
		int numelem = tail - head;
		for (int i = 0; i < (numelem); i++) {
			arr[i] = arr[counter];
			arr[counter] = null;
			counter++;
		}
		head = 0;
		tail = head + numelem;
	}

	private void resize(int newlen) {
		moveArrayBack();
		System.out.println("Resizing the array from : " + arr.length + " to :" + newlen);
		String[] newArray = new String[newlen];
		for (int i = 0; i < tail; i++) {
			newArray[i] = arr[i];
		}
		arr = newArray;
	}

	// edge case, taking care of head when there's only 1 element.
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return;
		}
		if ((tail - head) <= arr.length / 4) {
			resize(arr.length / 2);
		}
		System.out.print(arr[head] + " ");
		arr[head++] = null;
		if (isEmpty()) {
			head = 0;
			tail = 0;
		}
	}

	public boolean isEmpty() {
		return (tail - head) == 0;
	}

	public void printArray() {
		System.out.println("Head is : " + head);
		System.out.println("Tail is : " + tail);
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.print(arr[arr.length - 1]);
		System.out.println("]");
	}
}

/*public class ClientProgram {
	public static void main(String[] args) {
		ResizeArrayQueue queue = new ResizeArrayQueue();
		queue.enqueue("to");
		queue.printArray();
		queue.enqueue("be");
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.enqueue("to");
		queue.printArray();
		queue.enqueue("or");
		queue.printArray();
		queue.enqueue("not");
		queue.printArray();
		queue.enqueue("to");
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.enqueue("be");
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		System.out.println("Before inserting that");
		queue.enqueue("that");
		queue.printArray();
		System.out.println("After inserting that");
		queue.dequeue();
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.enqueue("is");
		queue.printArray();
		queue.dequeue();
		queue.printArray();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.printArray();
	}
}*/