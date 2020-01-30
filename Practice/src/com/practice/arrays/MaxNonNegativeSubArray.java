package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		Integer[] arr = {1967513926, 1540383426, -1303455736, -521595368 };
		System.out.println(maxset(Arrays.asList(arr)));
	}
	
	public static List<Integer> maxset(List<Integer> a) {
        int maxSumStartIndex = -1;
        int maxSumEndIndex = -1;
        long maxSum = 0;

        long sum = 0;
        int start = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < 0) {
                sum = 0;
                start = i + 1;
                continue;
            } else {
                sum = sum + a.get(i);
            }

            if (sum == maxSum && (i - start > maxSumEndIndex - maxSumStartIndex)) {
                maxSumStartIndex = start;
                maxSumEndIndex = i;
            } else if (sum > maxSum) {
                maxSum = sum;
                maxSumStartIndex = start;
                maxSumEndIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (maxSumStartIndex != -1) {
            result.addAll(a.subList(maxSumStartIndex, maxSumEndIndex + 1));
        }

        return result;
	}

}
