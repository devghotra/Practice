package com.practice.stacksqueues.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	public static void main(String[] args) {
		Integer[] arr = {4,4};
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(arr));
		System.out.println(prevSmaller(nums));

	}

	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(Integer num : arr){
			while(!stack.isEmpty() && stack.peek() >= num){
				stack.pop();
			}
			
			if(stack.isEmpty())
				result.add(-1);
			else
				result.add(stack.peek());
			
			stack.push(num);
		}
		
		return result;
	}

}
