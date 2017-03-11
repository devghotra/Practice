package com.practice.dp;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance inst = new EditDistance();

		System.out.println(inst.minDistance("aac", "abac"));

	}

	public int minDistance(String from, String to) {

		int dp[][] = new int[from.length() + 1][to.length() + 1];

		// 1st base case EMPTY -> TO
		for (int i = 1; i <= to.length(); i++) {
			dp[0][i] = i;
		}

		// 2nd base case FROM -> EMPTY
		for (int i = 1; i <= from.length(); i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= from.length(); i++) {
			for (int j = 1; j <= to.length(); j++) {
				if (from.charAt(i - 1) == to.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int replaceCost = dp[i - 1][j - 1] + 1;
					int insertCost = dp[i][j - 1] + 1;
					int deleteCost = dp[i - 1][j] + 1;

					dp[i][j] = Math.min(replaceCost, Math.min(insertCost, deleteCost));
				}
			}
		}

		return dp[from.length()][to.length()];
	}
}
