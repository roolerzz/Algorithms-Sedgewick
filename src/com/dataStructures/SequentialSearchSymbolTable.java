package com.dataStructures;

public class SequentialSearchSymbolTable<Key, Value>{
	private Node first;

	private int size = 0;

	public SequentialSearchSymbolTable() {
	// Initializing empty symbol table.
	}

	private class Node{
		Key key;
		Value value;
		Node next;

		Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return key.toString() + " : " +  value.toString();
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

	public Value get(Key k){
		  if (k == null) throw new IllegalArgumentException("argument to get() is null"); 
		  for(Node x = first; x!=null; x=x.next) {
			if(k.equals(x.key))
				return x.value;
		  }
		  return null;
	}
	
	public void put(Key k, Value v){
		if (k == null) throw new IllegalArgumentException("first argument to put() is null"); 	
		if (v == null) {
            delete(k);
            return;
        }
		  for (Node x = first; x != null; x = x.next) {
	            if (k.equals(x.key)) {
	                x.value = v;
	                return;
	            }
	        }
	      first = new Node(k, v, first);
	      size++;
		}


		public void delete(Key k){ 
			 if (k == null) throw new IllegalArgumentException("argument to delete() is null"); 
		        first = delete(first, k);
			
		}
		
		private Node delete(Node x, Key key) {
	        if (x == null) return null;
	        if (key.equals(x.key)) {
	            size--;
	            return x.next;
	        }
	        x.next = delete(x.next, key);
	        return x;
	    }

		public Iterable<Key> keys()  {
	        GenericLinkedListBasedQueue<Key> queue = new GenericLinkedListBasedQueue<Key>();
	        for (Node x = first; x != null; x = x.next)
	            queue.enqueue(x.key);
	        return queue;
	    }
		
		public void printST() {
			System.out.println("Printing Symbol Table");
			if (isEmpty()) {
				System.out.println("Symbol table is empty. ");
			}
			for (Node temp = first; temp != null; temp = temp.next) {
				System.out.println("Key :" + temp.key + " Value : " + temp.value);
			}
		}
		
	}
