package com.practice.interviewbit.dp;

public class CountPermutationsofBST {

	int[][] pascals;

	public static void main(String[] args) {
		CountPermutationsofBST inst = new CountPermutationsofBST();
		
		System.out.println(inst.countAllBST(4, 2));

	}

	public int countAllBST(int n, int h) {
		//populatePascals(n);

		int[][] dp = new int[n + 1][h + 1];
		dp[1][0] = 1;

		for (int i = 2; i <= n; i++) {
			System.out.println("processing "+i);
			for (int j = 1; j <= h && j < i; j++) {
				for (int k = 1; k <= i; k++) {
					int leftCount = dp[k-1][j-1];
					int rightCount = dp[i-k][j-1];
					
					if(leftCount == 0 && rightCount == 0){
						continue;
					}
					
					if(leftCount == 0 || rightCount == 0){
						leftCount = leftCount == 0 ? 1 : leftCount;
						rightCount = rightCount == 0 ? 1 : rightCount;
						dp[i][j] += leftCount*rightCount;
					} else{
						leftCount = leftCount == 0 ? 1 : leftCount;
						rightCount = rightCount == 0 ? 1 : rightCount;
						dp[i][j] += fac(i-1)*leftCount*rightCount;
					}					
				}
			}
		}
		
		return dp[n][h];
	}

	private int fac(int n){
		int fac = 1;
		for(int i=1; i<=n; i++){
			fac *= i;
		}
		
		return fac;
	}
	
	private void populatePascals(int n) {
		pascals = new int[n + 1][n + 1];
		pascals[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			pascals[i][0] = 1;
			for (int j = 1; j <= n; j++) {
				pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
			}
		}

	}

}
