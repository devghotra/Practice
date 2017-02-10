package com.practice.stacksqueues.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreater {

	public static void main(String[] args) {
		Integer[] nums = {39, 27, 11, 4, 24, 32, 32, 1};
		System.out.println(nextGreater(new ArrayList<>(Arrays.asList(nums))));
	}

	public static ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = a.size()-1; i >= 0; i--) {
			int num = a.get(i);
			while(!stack.isEmpty() && num >= stack.peek()){
				stack.pop();
			}
			
			if(stack.isEmpty()){
				result.add(0, -1);
			} else{
				result.add(0, stack.peek());
			}
			
			stack.add(num);
		}
		
		return result;
	}

}
