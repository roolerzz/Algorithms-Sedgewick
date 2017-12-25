package com.dataStructures;

public class ArrayBasedStackOfStrings{

	private String[] arr = null;

	private int top=0;

	public ArrayBasedStackOfStrings(int n){
		arr = new String[n];
	}
	
	public void push(String obj){
		int length = arr.length;
		if(top<length){
		arr[top++] = obj;}
		else {
		System.out.println("Stack Overflow");
		}
	}
	

	public void pop(){
		if(isEmpty()) {System.out.println("Stack Underflow"); return;}
		System.out.print(arr[--top] + " ");
		arr[top] = null;
	}
	
	public boolean isEmpty(){
		return top==0;
	}

}


/*public class ClientProgram {
	public static void main(String[] args){
	ArrayStackOfStringsstack = new ArrayStackOfStrings();
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