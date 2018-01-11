package com.algorithm.dynamicconnectivity;

import com.dataStructures.GenericLinkedListBasedStack;

public class ClientProgram {
	public static void main(String[] args){
		GenericLinkedListBasedStack<String> stack = new GenericLinkedListBasedStack<String>();
	System.out.println(stack);
	stack.push("to");
	stack.push("be");
	stack.push("or");
	stack.push("not");
	stack.push("to");
	/*stack.pop();*/
	stack.push("be");
	/*stack.pop();
	stack.pop();*/
	stack.push("that");
	/*stack.pop();
	stack.pop();
	stack.pop();*/
	stack.push("is");
	for(String s : stack) {
		System.out.println("String is : " + s);
	}
	System.out.println(stack);
	}
}