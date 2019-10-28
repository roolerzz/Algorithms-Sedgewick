package com.dataStructures.attemptII;

import com.dataStructures.GenericLinkedListBasedQueue;

public class SeparateChainingST<Key, Value> {

    private class SeparateChainingLinkedList<Key, Value> {

        private Node first;

        int size;

        SeparateChainingLinkedList() {

        }

        public Iterable<Key> keys() {
            GenericLinkedListBasedQueue<Key> queue = new GenericLinkedListBasedQueue<Key>();
            for(Node x= first; x != null; x = x.next){
                queue.enqueue(x.key);
            }
            return queue;
        }

        public Value get(Key key) {
            checkArgumentForNull(key, "key");
            for(Node x = first; x!=null; x = x.next) {
                if (x.key.equals(key)) {
                    return x.val;
                }
            }
            return null;
        }

        private void checkArgumentForNull(Object obj, String objectName) throws IllegalArgumentException {
            if (obj == null)
                throw new IllegalArgumentException(objectName + " can't be null.");
        }

        public boolean contains(Key key) {
            checkArgumentForNull(key, "key");
            return get(key) != null;
        }

        public boolean isEmpty() {
            return size()==0;
        }

        public int size() {
            return size;
        }

        public void put(Key key, Value val) {
            // Null key means they want to delete the element
            checkArgumentForNull(key, "key");
            if (val == null)
            {
                delete(key);
                return;
            }
            for (Node x= first; x != null; x = x.next) {
                if (x.key.equals(key)) {
                    x.val = val;
                    return;
                }
                first = new Node(key, val, first);
            }
            size++;
        }

        public void delete(Key key) {
            first = delete(first, key); // In place deletion w/o two pointers by using recursion to update pointers while coming back.
        }
        private Node delete(Node x, Key key) {
            if (x == null) return null;
            if (x.key.equals(key)) {
                size--;
                return x.next;
            }
            x.next=  delete(x.next, key);
            return x;
        }
        private class Node {
            Key key;
            Value val;
            Node next;
            Node(Key key, Value val, Node next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
    }

    private SeparateChainingLinkedList<Key, Value>[] st;

    private static final int INIT_CAPACITY = 4;

    public SeparateChainingST() {
        this(INIT_CAPACITY);
    }

    private int n;

    private int m;

    public SeparateChainingST(int cap) {
        st = (SeparateChainingLinkedList<Key, Value>[])new SeparateChainingLinkedList[cap];
        for(int i = 0; i < cap; i++) {
            st[i] = new SeparateChainingLinkedList<>();
        }
    }

    private void resize(int newCap) {
        SeparateChainingST<Key, Value> newST = new SeparateChainingST(newCap);
        for(int i = 0; i < m; i++) {
            for(Key key: st[i].keys()){
                newST.put(key, st[i].get(key));
            }
        }
        this.m = newST.m;
        this.n = newST.n;
        this.st = newST.st;
    }

    public int hash(Key key) {
        int hash = (key.hashCode() & 0x7fffffff) % m;
        return hash;
    }

    public void put(Key key, Value val) {
        checkArgumentForNull(key, "key");
        if(val == null){
            delete(key);
            return;
        }
        if(n == 10 * m) resize(2*m);
        int i = hash(key);
        if(!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    public void delete(Key key) {
        checkArgumentForNull(key, "key");
        int i = hash(key);
        if(st[i].contains(key)) n--;
        st[i].delete(key);
        // Average length of the list is 2, shrink the hashmap and rehash the keys.
        if (n < INIT_CAPACITY && n <= 2*m){
            resize(m/2); // resize is automatically gonna take care of rehashing.
        }
    }
    private void checkArgumentForNull(Object obj, String objectName) throws IllegalArgumentException {
        if (obj == null)
            throw new IllegalArgumentException(objectName + " can't be null.");
    }

}
