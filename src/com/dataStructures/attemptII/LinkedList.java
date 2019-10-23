package com.dataStructures.attemptII;

import java.util.NoSuchElementException;

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
            throw new NoSuchElementException();
        Node elem = head;
        head = head.next;
        return elem.data;
    }

    public void print() {
        if (head == null)
            System.out.println("No element to print in the linked list.");
        Node current = head;
        while (current != null && current.next != null ) {
            System.out.println(current.data);
            current = current.next;
        }
        if (current != null) {
            System.out.println(current.data);
        }
    }




    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.print();
        myList.removeFirst();
        myList.add(10);
        myList.print();
        myList.removeFirst();
        myList.add(20);
        myList.print();
        myList.removeFirst();
        myList.add(30);
        myList.print();
        myList.removeFirst();
        myList.add(40);
        myList.print();
        myList.removeFirst();
        myList.add(50);
        myList.print();
        myList.removeFirst();
    }

}
