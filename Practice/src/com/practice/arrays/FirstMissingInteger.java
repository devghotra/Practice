package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingInteger {

    public static void main(String[] args) {
        Integer[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(new ArrayList<>(Arrays.asList(nums))));

    }

    // for IB - same logic as below method
    // CRUX - maximum number of positive numbers you can keep in array of size N is N
    // so we need to remove -ve and out of range +ive nums and swap elements until element finds its correct position, in the end array will be sorted
    // first NULL will give us missing number else all +ive nums are present till N so answer would be (N+1)
    public static int firstMissingPositive(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); ) {
            int num = nums.get(i);
            if (num != i + 1) {
                if (num > nums.size() || num <= 0 || num == nums.get(num - 1)) {
                    nums.set(i, -1);
                } else {
                    int temp = nums.get(num - 1);
                    nums.set(num - 1, num);
                    nums.set(i, temp);
                    continue;
                }
            }
            i++;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == -1) {
                return i + 1;
            }
        }

        return nums.size() + 1;
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < nums.length; ) {
            if (nums[i] != i + 1) {

                if (nums[i] <= 0 || nums[i] > len || nums[i] == nums[nums[i] - 1]) {
                    nums[i] = Integer.MAX_VALUE;
                } else {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                    continue;
                }
            }

            i++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE)
                return i + 1;
        }

        return len + 1;
    }

}
