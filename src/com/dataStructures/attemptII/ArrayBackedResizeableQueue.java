package com.dataStructures.attemptII;

import java.util.NoSuchElementException;

public class ArrayBackedResizeableQueue<Item> {

    private Item[] elem;

    private int head;

    private int tail;

    public ArrayBackedResizeableQueue() {
        elem = (Item[])new Object[1];
    }

    public void enque(Item data) throws IllegalArgumentException{
        if (data == null) throw new IllegalArgumentException();
        if (tail-head == elem.length) resize(2*elem.length);
        else if (tail == elem.length) moveToFront();
        elem[tail++] = data;
    }

    public Item deque() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException();
        if(tail-head <= (elem.length/4)) {
            moveToFront();
            resize(elem.length/2);
        }
        Item elemToReturn = elem[head];
        elem[head++] = null;
        if(isEmpty()){
            head = 0;
            tail = 0;
        }

        return elemToReturn;

    }

    public boolean isEmpty() {
        return tail == head ;
    }

    public void moveToFront() {
        int noOfElem = tail - head;
        for (int i = 0 ; i < noOfElem; i++) {
            elem[i] = elem[head + i];
            elem[head+i] = null;
        }
        head = 0;
        tail = noOfElem;
    }

    public void resize(int newCap) {
//        moveToFront();
        Item[] newElem =   (Item[])new Object[newCap];
        int noOfElem = tail-head;
        System.out.println("Resizing array from " +  elem.length + " to " + newCap + "because it only has : " + noOfElem);
        for(int i = 0; i < noOfElem; i++) {
            newElem[i] = elem[head + i];
        }
        elem = newElem;
        head = 0;
        tail = noOfElem;
    }

    public void print(){
        System.out.println();
        for (int i = head; i < tail; i++) {
            System.out.print(elem[i] + " -> " );
        }
    }

    public static void main(String[] args) {
        ArrayBackedResizeableQueue<String> q = new ArrayBackedResizeableQueue<String>();
        try {
            q.deque();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        q.enque("FIRST");
        q.print();
        q.enque("SECOND");
        q.print();
        q.enque("THIRD");
        q.print();
        q.enque("FOUR");
        q.print();
        q.enque("FIFTH");
        q.print();
        q.enque("SIXTH");
        q.print();
        q.deque();
        q.print();
        q.deque();
        q.print();
        q.deque();
        q.print();
        q.deque();
        q.print();
    }
}
