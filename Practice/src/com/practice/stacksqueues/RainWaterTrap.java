package com.practice.stacksqueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RainWaterTrap {

    public static void main(String[] args) {
        System.out.println(trap(Arrays.asList(5, 1, 0, 3, 0, 1, 5)));
    }

    public static int trap(final List<Integer> A) {

        if (A == null)
            return 0;

        Stack<Integer> stack = new Stack<>();

        int i = 0, maxWater = 0, maxBotWater = 0;

        while (i < A.size()) {
            if (stack.isEmpty() || A.get(i) <= A.get(stack.peek())) {
                stack.push(i++);
            } else {
                int bot = stack.pop();
                if (!stack.isEmpty()) {
                    maxBotWater = (Math.min(A.get(stack.peek()), A.get(i)) - A.get(bot)) * (i - stack.peek() - 1);
                } else {
                    maxBotWater = 0;
                }
                maxWater += maxBotWater;
            }
        }
        return maxWater;

    }

}
