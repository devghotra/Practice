package com.practice.hashing.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {

	public static void main(String[] args) {
		LargestContinuousSequenceZeroSum inst = new LargestContinuousSequenceZeroSum();
		Integer[] input = {1, 0,-2, 2, 3, -3, 0,4 };
		System.out.println(inst.getLargestSequenceZeroSum(Arrays.asList(input)));

	}

	public ArrayList<Integer> getLargestSequenceZeroSum(List<Integer> input) {
		Map<Integer, Integer> sumToIndexMap = new HashMap<>();
		int startIndex = -1;
		int endIndex = -1;
		int length = 0;
		sumToIndexMap.put(0, -1);

		int sum = 0;
		for (int currentIndex = 0; currentIndex < input.size(); currentIndex++) {
			int num = input.get(currentIndex);
			sum += num;

			Integer sameSumPreviousIndex = sumToIndexMap.get(sum);
			if (sameSumPreviousIndex == null) {
				sumToIndexMap.put(sum, currentIndex);
			} else if (currentIndex - sameSumPreviousIndex > length) {
				startIndex = sameSumPreviousIndex + 1;
				endIndex = currentIndex;
				length = currentIndex - sameSumPreviousIndex;
			}

		}

		ArrayList<Integer> result = new ArrayList<>();
		if(length > 0){
			for (int i = startIndex; i <= endIndex; i++) {
				result.add(input.get(i));
			}
		}

		return result;
	}
}
