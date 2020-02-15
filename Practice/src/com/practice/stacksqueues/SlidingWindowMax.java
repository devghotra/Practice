package com.practice.stacksqueues;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class SlidingWindowMax {

    @Test
    public void test() {
        assertEquals(1, 1);
        //System.out.println(slidingMaximum(Arrays.asList(9, 10, 9, -7, -4, -8, 2, -6), 5));
        System.out.println(slidingMaximum(Arrays.asList(1, 3, -1, 2, 1, 3, 6, 7), 3));

    }

    // Using DeQueue - time complexity is O(N)
    public static ArrayList<Integer> slidingMaximum(final List<Integer> arr, int w) {

        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> deQueue = new LinkedList<>();

        for (int i = 0; i < arr.size(); i++) {

            int num = arr.get(i);

            // if queue contain out of window range index - remove its
            while (!deQueue.isEmpty() && deQueue.peek() < i - w + 1) {
                deQueue.poll();
            }

            // remove all nums smaller than current num
            while (!deQueue.isEmpty() && arr.get(deQueue.peekLast()) < num) {
                deQueue.pollLast();
            }

            // q contains index
            deQueue.add(i);

            if (i >= w - 1) {
                result.add(arr.get(deQueue.peek()));
            }

        }

        return result;
    }

    // Using Max Heap(priority Q) time complexity is O(NlogN) - less optimal
    public static ArrayList<Integer> slidingMaximum2(final List<Integer> arr, int w) {

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((Integer n1, Integer n2) -> n1.compareTo(n2) * -1);

        for (int i = 0; i < arr.size(); i++) {
            if (i < w - 1) {
                pQueue.add(arr.get(i));
                continue;
            }

            if (i >= w)
                pQueue.remove(arr.get(i - w));

            pQueue.add(arr.get(i));
            result.add(pQueue.peek());
        }

        return result;
    }

}
