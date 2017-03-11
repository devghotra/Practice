package com.practice.stacksqueues;

import java.util.List;
import java.util.Stack;

public class RainWaterTrap {

	public static void main(String[] args) {
		int[] h = {5,2,1,2,1,5};
		//System.out.println(trap(h));
	}
	
	public static int trap(final List<Integer> A) {

		if (A == null)
			return 0;
		
		Stack<Integer> s = new Stack<Integer>();
		
		int i = 0, maxWater = 0, maxBotWater = 0;
		
		while (i < A.size()) {
			if (s.isEmpty() || A.get(i) <= A.get(s.peek())) {
				s.push(i++);
			} else {
				int bot = s.pop();
				if(!s.isEmpty()){
				    maxBotWater = (Math.min(A.get(s.peek()), A.get(i)) - A.get(bot)) * (i - s.peek() - 1);
				} else{
				    maxBotWater = 0;
				}
				maxWater += maxBotWater;
			}
		}
		return maxWater;

	}

}
