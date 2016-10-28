package com.practice.interviewbit.binarysearch;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class PaintersPartition {
	
	/* http://articles.leetcode.com/the-painters-partition-problem-part-ii/ */

	public static void main(String[] args) {
		PaintersPartition pp = new PaintersPartition();
		Integer[] arr = { 1000000, 1000000  };
		System.out.println(pp.paint(1, 1000000, Arrays.asList(arr)));

	}

	public int paint(int numPainters, int timePerUnit, List<Integer> boards) {
		int lowestUnitsToPaintPerPainter = getMax(boards);
		int highestUnitsToPaintPerPainter = getSum(boards);

		while (lowestUnitsToPaintPerPainter < highestUnitsToPaintPerPainter) {
			int mid = lowestUnitsToPaintPerPainter + (highestUnitsToPaintPerPainter-lowestUnitsToPaintPerPainter) / 2;
			
			int paintersReq = getPaintersRequired(boards, mid);
			if(paintersReq <= numPainters){
				highestUnitsToPaintPerPainter = mid;
			} else{
				lowestUnitsToPaintPerPainter = mid+1;
			}
		}

		BigInteger minTime = BigInteger.valueOf(lowestUnitsToPaintPerPainter).multiply(BigInteger.valueOf(timePerUnit));
		return minTime.mod(BigInteger.valueOf(10000003)).intValue();
		
	}

	public int getPaintersRequired(List<Integer> boards, int unitsToPaintPerPainter) {
		int paintersRequired = 1;
		int sum = 0;
		for (Integer board : boards) {
			sum += board;
			if (sum > unitsToPaintPerPainter) {
				paintersRequired++;
				sum = board;
			}
		}

		return paintersRequired;
	}

	public int getMax(List<Integer> boards) {
		int max = Integer.MIN_VALUE;
		for (Integer board : boards) {
			if (board > max) {
				max = board;
			}
		}

		return max;
	}

	public int getSum(List<Integer> boards) {
		int sum = 0;
		for (Integer board : boards) {
			sum += board;
		}

		return sum;
	}
	
}

/*
 How about this part of the problem “you are also given how much time a painter takes to paint 1 unit of board”, 
 which implies that each painter may paint the same section of boards with different time? In other words, painter j (0<=j<k) can paint at Tj hours / unit. 
 I think the solution here and the DP solution in part I only solve the special case of the original problem where all Tj's are equal.

When Tj's are different, the binary search may still apply, but now
. lo = max(Ai) * min(Tj)
. hi = sum(Ai) * max(Tj)
However finding x is much more difficult. I think we can safely sort Tj's and use the smallest ones, 
and reduce finding x to a different sub problem. I haven't thought through and get the complexity though.
 */
