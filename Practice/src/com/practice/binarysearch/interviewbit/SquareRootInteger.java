package com.practice.binarysearch.interviewbit;

import java.math.BigInteger;

public class SquareRootInteger {

	public static void main(String[] args) {
		System.out.println(sqrt(11));

	}

	public static int sqrt(int a){
		if(a==0)
			return 0;
		
		int low = 1;
		int high = 2;
		int maxHigh = Integer.MAX_VALUE;
		
		BigInteger num = BigInteger.valueOf(a);
		while(low <  high){
			BigInteger sqLow = BigInteger.valueOf(low).multiply(BigInteger.valueOf(low));
			BigInteger sqHigh = BigInteger.valueOf(high).multiply(BigInteger.valueOf(high));
			
			if(sqLow.equals(num))
				return low;
			
			if(sqHigh.equals(num))
				return high;
			
			if(num.compareTo(sqHigh) == 1){
				low = high;
				high = high*2 < maxHigh ? high*2 : maxHigh;
			} else{
				maxHigh = high;
				high = (low+high)/2;
			}
		}
		
		return low;
	}
}
