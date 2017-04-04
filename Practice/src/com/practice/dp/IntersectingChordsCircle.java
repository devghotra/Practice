package com.practice.dp;

import java.math.BigInteger;

public class IntersectingChordsCircle {

	public static void main(String[] args) {
		IntersectingChordsCircle inst = new IntersectingChordsCircle();
		System.out.println(inst.chordCnt(3));

	}

	public int chordCnt(int A) {
		if(A == 0)
			return 0;
		
		BigInteger modOf = new BigInteger("1000000007");
		
		BigInteger[] counts = new BigInteger[A+1];
		counts[0] = BigInteger.ONE;
		counts[1] = BigInteger.ONE;
		
		for(int i=2; i<=A; i++){
			int points = 2*i;
			counts[i] = BigInteger.ZERO;
			for(int j=2;j<=points;j=j+2){
				counts[i] = counts[i]
							.add(counts[(j-2)/2].multiply(counts[(points-j)/2])
							.mod(modOf)).mod(modOf);
				
				// dp[i] = dp[i] + dp[(j-2)/2] * dp[(points-j)/2];
			}
		}
		
		
		return counts[A].intValue();
	}

}
