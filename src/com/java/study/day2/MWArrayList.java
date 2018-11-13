package com.java.study.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MWArrayList<T> implements Iterable<T>{

	private Node header;
	
	public void add(T object) {
		Node addNode = new Node();
		addNode.object = object;
		addNode.nextNode = null;
		
		Node lastNode = header;

		if(lastNode == null) {
			header = addNode;
			return;
		}
		
		if(lastNode.nextNode == null) {
			header.nextNode = addNode;
			return;
		}

		while(lastNode.nextNode != null) {
			lastNode = lastNode.nextNode;
		}
		
		lastNode.nextNode = addNode;
	}
	
	public void remove(int index) {
		Node node = header;

		if(node == null) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index == 0) {
			header = node.nextNode;
			node = null;
			return;
		}

		int size = 0;
		
		while(node != null) {
			Node prevNode = node;
			Node removeNode = node.nextNode;
			
			if(index -1 == size && removeNode != null) {
				Node removeNextNode = removeNode.nextNode;
				prevNode.nextNode = removeNextNode;
				removeNode = null;
				return;
			}
			
			node = node.nextNode;
			size++;
		}
		
		throw new IndexOutOfBoundsException();
	}
	
	public T get(int index) {
		Node node = header;
		int size = 0;
		
		while(node != null) {
			if(index == size) {
				return node.object;
			}
			
			node = node.nextNode;
			size++;
		}
		
		throw new IndexOutOfBoundsException();
	}
	
	public int size() {
		Node node = header;
		int size = 0;
		
		while(node != null) {
			node = node.nextNode;
			size++;
		}
		
		return size;
	}
	
	public void clear() {
		header = null;
	}
	
	private class Node {
		T object;
		Node nextNode;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MWIterator(header);
	}
	
    private class MWIterator implements
                    Iterator<T> {
    	private Node header;

        public MWIterator(Node header) {
            this.header = header;
        }

        public boolean hasNext() {
            return header != null;
        }

        public T next() {
            if(!this.hasNext()) {
            	throw new NoSuchElementException();
            }

            Node currentNode = header;
            
        	header = header.nextNode;
        	
            return currentNode.object;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
