package com.practice.interviewbit.stacksqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		String[] tokens = {"0","3","/"};
		System.out.println(evalRPN(new ArrayList<>(Arrays.asList(tokens))));

	}
	
	public static int evalRPN(ArrayList<String> tokens) {
		Stack<Integer> stack = new Stack<>();

		for(String token : tokens){
			
			if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
				stack.push(Integer.parseInt(token));
				continue;
			}
			
			Integer n2 = stack.pop();
			Integer n1 = stack.pop();
			
			switch (token) {
				case "+":
					stack.push(n1+n2);
					break;
				case "-":
					stack.push(n1-n2);
					break;
				case "*":
					stack.push(n1*n2);
					break;
				case "/":
					stack.push(n1/n2);
					break;
			}
			
		}
		
		return stack.pop();
	}

}
