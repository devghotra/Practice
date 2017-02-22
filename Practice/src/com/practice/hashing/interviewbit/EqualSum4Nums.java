package com.practice.hashing.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSum4Nums {

	public static void main(String[] args) {
		EqualSum4Nums inst = new EqualSum4Nums();
		// Integer[] input = { 3, 4, 7, 1, 2, 9, 8 };
		// Integer[] input = { 1,2,4,6,2,1,1,2 };
		Integer[] input = { 9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5 };
		System.out.println(inst.equal(Arrays.asList(input)));

	}

	public ArrayList<Integer> equal(List<Integer> input) {
		ArrayList<Integer> result = null;

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < input.size(); i++) {
			int num1 = input.get(i);
			for (int j = i + 1; j < input.size(); j++) {
				int num2 = input.get(j);
				int sum = num1 + num2;

				if (map.containsKey(sum)) {
					ArrayList<Integer> l = map.get(sum);
					if (l.contains(i) || l.contains(j)) {
						continue;
					}
					ArrayList<Integer> l2 = new ArrayList<>();
					l2.addAll(l);
					l2.add(i);
					l2.add(j);
					if (result == null || hasSmallerIndexes(result, l2)) {
						result = l2;
					}
				} else {
					ArrayList<Integer> l = new ArrayList<>();
					l.add(i);
					l.add(j);
					map.put(sum, l);
				}

			}
		}

		return result;
	}

	public boolean hasSmallerIndexes(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		if (l2.get(0) < l1.get(0) || l2.get(1) < l1.get(1)) {
			return true;
		} else {
			return false;
		}

	}
}
