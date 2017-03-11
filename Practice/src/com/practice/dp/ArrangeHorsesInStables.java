package com.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class ArrangeHorsesInStables {

	public static void main(String[] args) {
		ArrangeHorsesInStables inst = new ArrangeHorsesInStables();

		/*
		 * BBBBBBWWWBWBBWWBWBBBWBWBWBBWBBWBBWBWBWBWWWW - 27 Ans: 0
		 * WBBWBWBBBWWBBBWWBBWWWWWBBBWWBBWWWWBWBBBBBWW - 17 Ans: 2
		 * BBBWWBWBBBBWBBBBWWBBBWWWBWB - 23 Ans: 0
		 * BWBWBWBWBBWWBBWBBBWWWBBWBBWWBBBBWBWWWBBWBBBBBWB - 17 Ans: 13
		 * WBWBWWBB - 3 Ans: 4
		 * BWBBBBWWWBWBWBWBWBBBWBWBWBBBWBBWWBWWBBBBWWB - 11 Ans: 26
		 * BBWBBBWW - 3 Ans: 2
		 */

		String horses = "BWBWBWBWBBWWBBWBBBWWWBBWBBWWBBBBWBWWWBBWBBBBBWB";
		int stables = 13;
		
		System.out.println("Rec Score " + inst.arrangeRec(horses, stables));
		System.out.println("DP Score "+inst.arrangeDynamic(horses, stables));
	}

	public int arrangeDynamic(String horses, int stables) {
		if (horses == null || stables > horses.length()) {
			return -1;
		}
		
		int[][] dp = new int[stables + 1][horses.length() + 1];

		for (int h = 1; h <= horses.length(); h++) {
			dp[1][h] = countScore(horses, 1, h);
		}

		for (int s = 2; s <= stables; s++) {
			for (int h = s + 1; h <= horses.length(); h++) {
				dp[s][h] = Integer.MAX_VALUE;
				for (int c = h; c >= s; c--) {
					int thisScore = dp[s - 1][c - 1] + countScore(horses, c, h);
					dp[s][h] = Math.min(dp[s][h], thisScore);
				}
			}
		}

		return dp[stables][horses.length()];
	}

	public int countScore(String horses, int start, int end) {
		int w = 0;
		int b = 0;

		for (int i = start; i <= end; i++) {
			char c = horses.charAt(i - 1);
			if (c == 'W')
				w++;
			else
				b++;
		}

		return w * b;
	}

	/* Recursive solution - accepted on IB */
	public int arrangeRec(String horses, int stables) {
		if (horses == null || stables > horses.length()) {
			return -1;
		}

		Map<String, Integer> countMap = new HashMap<>();
		int res = arrangeRec(horses, stables, countMap);
		return res;
	}

	public int arrangeRec(String horses, int stables, Map<String, Integer> countMap) {

		if (stables > horses.length() || horses.length() <= 1) {
			countMap.put(horses + "-" + stables, 0);
			return 0;
		}

		if (stables == 1) {
			int score = countScore(horses, 1, horses.length());
			countMap.put(horses + "-" + stables, score);
			return score;
		}

		Integer sum = null;
		for (int j = 1; j <= horses.length() - 1; j++) {
			String key1 = horses.substring(0, j) + "-" + 1;
			Integer s1 = countMap.get(key1);
			if (s1 == null) {
				s1 = arrangeRec(horses.substring(0, j), 1, countMap);
				countMap.put(key1, s1);
			}

			String key2 = horses.substring(j) + "-" + (stables - 1);
			Integer s2 = countMap.get(key2);
			if (s2 == null) {
				s2 = arrangeRec(horses.substring(j), stables - 1, countMap);
				countMap.put(key2, s2);
			}

			int tempSum = s1 + s2;
			if (sum == null || tempSum < sum) {
				sum = tempSum;
			}
		}

		if (sum == null)
			sum = 0;

		return sum;
	}
}
