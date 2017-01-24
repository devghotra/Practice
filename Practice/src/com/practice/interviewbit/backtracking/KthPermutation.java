package com.practice.interviewbit.backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KthPermutation {

	static Map<Integer, Integer> factorialMap = new HashMap<>();

	public static void main(String[] args) {
		KthPermutation kp = new KthPermutation();
		System.out.println(kp.getPermutation(4, 2));
	}

	public String getPermutation(int n, int k) {
		populateMap(n);
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		return getPermutation(nums, k);
	}

	public String getPermutation(List<Integer> nums, int k) {
		if (nums.isEmpty())
			return "";

		int batchSize = factorialMap.get(nums.size() - 1);

		int index = 0;
		int currentSize = batchSize;
		while (currentSize < k) {
			index++;
			currentSize += batchSize;
		}

		int n1 = nums.remove(index);
		String s1 = getPermutation(nums, k - index * batchSize);

		return n1 + s1;
	}

	public static void populateMap(int n) {
		int i = 1;
		factorialMap.put(0, 1);
		while (i <= n) {
			factorialMap.put(i, i * factorialMap.get(i - 1));
			i++;
		}
	}
}

/*
 * same solution as above implemented using BigInteger for InterviewBit
 */
class KthPermutationBI{
	static Map<Integer, BigInteger> factorialMap = new HashMap<>();
	
	public String getPermutation(int n, int k) {
		populateMap(n);
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		return getPermutation(nums, k);
	}
	
	public String getPermutation(List<Integer> nums, int k) {
		if (nums.isEmpty())
			return "";

		BigInteger batchSize = factorialMap.get(nums.size() - 1);

		int index = 0;
		BigInteger currentSize = batchSize;
		while (currentSize.compareTo(BigInteger.valueOf(k)) == -1) {
			index++;
			currentSize = currentSize.add(batchSize);
		}
		
		BigInteger remainingK = BigInteger.valueOf(k).subtract(batchSize.multiply(BigInteger.valueOf(index)));

		int n1 = nums.remove(index);
		String s1 = getPermutation(nums, remainingK.intValue());

		return n1 + s1;
	}

	public static void populateMap(int n) {
		int i = 1;
		factorialMap.put(0, BigInteger.ONE);
		while (i <= n) {
			factorialMap.put(i, factorialMap.get(i - 1).multiply(BigInteger.valueOf(i)));
			i++;
		}
	}
}