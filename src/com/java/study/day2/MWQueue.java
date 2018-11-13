package com.java.study.day2;

public class MWQueue<T> {
    private QueueNode head;
    private QueueNode tail;
    
    public boolean empty(){
        return (tail == null);
    }
    
    public void insert(T item){
        QueueNode newNode = new QueueNode();
        newNode.object = item;
        newNode.nextNode = null;
        
        if(empty()) {
        	head = newNode;
        	tail = newNode;
        } else {
        	head.nextNode = newNode;
        	head = newNode;
        }
    }
    
    public T peek(){
        
        if(empty()) {
        	throw new ArrayIndexOutOfBoundsException();
        }
        
        return tail.object;
    }
    
    public T remove(){
        QueueNode newNode = new QueueNode();
        T result = peek();
        newNode = tail;
        tail = tail.nextNode;
        newNode = null;
        
        return result;
    }
    
    private class QueueNode {
		T object;
		QueueNode nextNode;
	}
}
