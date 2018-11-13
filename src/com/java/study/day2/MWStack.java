package com.java.study.day2;

public class MWStack<T> {

	private StackNode topNode;
	
	public void push(T object) {
		StackNode newNode = new StackNode();
 		newNode.object = object;
 		newNode.nextNode = topNode;
 		
 		topNode = newNode;
 	}

	public T pop() {
		if (empty()) {
 			throw new IndexOutOfBoundsException("empty");
 		} else {
 			T data = peek();
 			topNode = topNode.nextNode;
 			return data;
 		}
	}
	
	public T peek() {
		if (empty()) {
 			throw new IndexOutOfBoundsException();
 		} else {
 			return topNode.object;
 		}
	}

	public boolean empty() {
 		return (topNode == null);
 	}
	
	private class StackNode {
		T object;
		StackNode nextNode;
	}
}
