package com.practice.stacksqueues.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		Integer[] heights = { 5, 4, 1, 2 };
		System.out.println(largestRectangleArea(new ArrayList<>(Arrays.asList(heights))));
	}

	public static int largestRectangleArea(ArrayList<Integer> heights) {

		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < heights.size()) {
			if (stack.isEmpty() || heights.get(i) > heights.get(stack.peek())) {
				stack.add(i);
				i++;
				continue;
			}

			int p = stack.pop();
			int h = heights.get(p);
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(h * w, maxArea);
		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = heights.get(p);
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(h * w, maxArea);
		}

		return maxArea;
	}
}
