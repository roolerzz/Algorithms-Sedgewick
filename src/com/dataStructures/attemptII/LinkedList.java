package com.dataStructures.attemptII;

import java.util.NoSuchElementException;
//import java.util.Stack;

public class LinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void add(int data) {
        Node tmpHead = head;
        head = new Node(data);
        head.next = tmpHead;
    }

    public int removeFirst() {
        if (head == null)
        {
            throw new NoSuchElementException();
//            sSystem.out.println("No element to print in the linked list.");
//            return -1;

        }

        Node elem = head;
        head = head.next;
        return elem.data;
    }

    public void print() {
        if (head == null)
        {
            System.out.println("No element to print in the linked list.");
            return;
        }
        Node current = head;
        while (current != null && current.next != null ) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        if (current != null) {
            System.out.print(current.data);
        }
        System.out.println("");
    }




    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        System.out.println("Printing empty list");
        myList.print();
//        myList.removeFirst();
        myList.add(10);

        System.out.println("Printing 1 element list");
        myList.print();
//        myList.removeFirst();
        myList.add(20);
        System.out.println("Printing 2 element list");
        myList.print();
//        myList.removeFirst();
        myList.add(30);
        System.out.println("Printing 3 element list");
        myList.print();
//        myList.removeFirst();
        myList.add(40);
        System.out.println("Printing 4 element list");
        myList.print();
        myList.removeFirst();
        myList.add(50);
        System.out.println("Printing 4 element list 50 instead of 40 though.");
        myList.print();
        myList.removeFirst();
    }

}
