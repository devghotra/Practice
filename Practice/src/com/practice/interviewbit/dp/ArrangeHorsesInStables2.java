package com.practice.interviewbit.dp;

public class ArrangeHorsesInStables2 {
	
	public static void main(String[] args) {
		ArrangeHorsesInStables2 inst = new ArrangeHorsesInStables2();
		System.out.println(inst.arrange("BBWBBBWW", 3));
	}

	public int arrange(String A, int B) {
		// C(m, k) = P (j to m) + C(j, k - 1)
		int[][] dp = new int[A.length() + 1][B + 1];
		if (A.length() < B)
			return -1;
		for (int i = 1; i <= A.length(); i++) {
			dp[i][1] = product(A, 0, i - 1);
		}

		// Product
		for (int k = 2; k <= B; k++) {
			for (int j = k; j <= A.length(); j++) {
				int min = Integer.MAX_VALUE;
				for (int i = k - 1; i <= j - 1; i++) {
					dp[j][k] = Math.min((dp[i][k - 1] + product(A, i, j - 1)), min); //i = 2 j = 4
					min = dp[j][k];
				}
			}
		}

		return dp[A.length()][B];

	}

	public int product(String A, int start, int end) {
		int W = 0, B = 0;
		for (int i = start; i <= end; i++) {
			if (A.charAt(i) == 'W')
				W++;
			else if (A.charAt(i) == 'B')
				B++;
		}
		return W * B;
	}

}
