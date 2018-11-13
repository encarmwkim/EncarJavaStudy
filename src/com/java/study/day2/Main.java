package com.java.study.day2;

public class Main {
	public static void main(String args[]) {
		Main mainClass = new Main();
		mainClass.arrayListTest();
		mainClass.queueTest();
		mainClass.stackTest();
	}
	
	private void arrayListTest() {
		MWArrayList<Integer> array = new MWArrayList<Integer>();
		array.add(10);
		array.add(20);
		array.add(30);
		array.add(40);

		for (int i : array) {
			System.out.println("array iterator : " + i);
		}

		for (int i = 0; i < array.size(); i++) {
			System.out.println("array for : " + array.get(i));
		}
		
		array.forEach((x)->{
			System.out.println("array forEach : " + x);
		});
	}
	
	public void queueTest() {
		MWQueue<String> queue = new MWQueue<>();
		queue.insert("10");
		queue.insert("20");
		queue.insert("30");
		queue.insert("40");

		while (!queue.empty()) {
			System.out.println("queue : " + queue.remove());
		}
	}
	
	public void stackTest() {
		MWStack<String> stack = new MWStack<>();
		stack.push("10");
		stack.push("20");
		stack.push("30");
		stack.push("40");

		while (!stack.empty()) {
			System.out.println("stack : " + stack.pop());
		}
	}
}
