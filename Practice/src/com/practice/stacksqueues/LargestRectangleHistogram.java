package com.practice.stacksqueues;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class LargestRectangleHistogram {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(8, largestRectangleArea(Arrays.asList(5, 4, 1, 2)));
        assertEquals(10, largestRectangleArea(Arrays.asList(2, 1, 5, 6, 2, 3)));
        assertEquals(20, largestRectangleArea(Arrays.asList(2, 3, 5, 4, 2, 8, 6, 5, 7)));
    }

    /**
     * We know that the height of the largest rectangle will be one of the heights of the histogram
     * lets see how this input will be processed - [2, 3, 5, 4, 2, 8, 6, 5, 7]
     *
     * Push index(2) on stack as its empty
     * Push index(3) & index(5) as they're greater than peek of stack,
     *      - it means all these indexes can be part of max rectangle for indexes ahead
     * Now we encounter height 4 which is less than stack.peek 5,
     *      - pop out 5, it means 5 cannot be used for indexes ahead
     *      - so calculate area which includes height 5 but not current height 4
     *      - it will be just one rectangle of 1*5 (w*h)
     *      - next peek is 3 which is smaller than current height so add index(4) on the stack
     * Next we encounter height 2
     *      - Process same as previous step
     *      - As 2 is <= to all previous heights on the stack our program will calculate area for bars 4, 3, 2
     *      - Finally stack will become empty and index(currentHeight of 2) is pushed on stack
     *  Similarly, continue to process
     *      - Main logic is when we encounter height which is <= to stack peek height then we need to remove all
     *      those heights and calculate areas which includes those heights as height of max rectangle
     */

    public int largestRectangleArea(List<Integer> heights) {

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
