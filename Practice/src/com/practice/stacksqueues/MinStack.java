package com.practice.stacksqueues;

import java.util.Stack;

public class MinStack {
	/** initialize your data structure here. */
	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		
		if(minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}

	public void pop() {
		int x = stack.pop();
		if(x == minStack.peek())
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}