package com.algorithm.dynamicconnectivity;

public class ClientProgram {
	public static void main(String[] args){
		QuickUnionWeightedUF obj = new QuickUnionWeightedUF(10);
		obj.printArray(obj.id);
		System.out.println("Print Size");
		obj.printArray(obj.size);	
		obj.union(4,3);
		obj.union(3,8);
		obj.union(6,5);
		obj.union(9,4);
		obj.union(2,1);
		System.out.println("1st Print");
		obj.printArray(obj.id);
		System.out.println(obj.find(8,9));
		System.out.println(obj.find(5,0));
		obj.union(5,0);
		obj.union(7,2);
		obj.union(6,1);
		obj.union(7,3);
		System.out.println("2nd Print");
		obj.printArray(obj.id);	
		System.out.println("Print Size");
		obj.printArray(obj.size);
	}
}