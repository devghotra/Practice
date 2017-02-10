package com.practice.stacksqueues.interviewbit;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		String str = "((a+b)+(c-d))";
		System.out.println(braces(str));
	}

	public static int braces(String exp) {

		Stack<Character> stack = new Stack<>();
		for (char c : exp.toCharArray()) {
			// only push opening brace and operators on stack
			if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/'){
				stack.push(c);
				continue;
			}
			
			if (c == ')') {
				char p = stack.pop();
				// if first pop'd char is not an operator then there is redundant brace
				if (p == '(') {
					return 1;
				} else {
					while (p != '(') {
						p = stack.pop();
					}
				}
			}
		}

		return 0;
	}
}
