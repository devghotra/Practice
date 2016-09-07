package com.practice.interviewbit.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RepeatMissingArrayNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> repeatedNumber(final List<Integer> a) {
		
		int arraySize = a.size();
		BigInteger arrSum = BigInteger.ZERO;
		BigInteger arrSumSq = BigInteger.ZERO;
		
		BigInteger idxSum = BigInteger.ZERO;
		BigInteger idxSumSq = BigInteger.ZERO;
		
		for(int i = 0; i < arraySize; i++){
			
			int num = a.get(i);
			arrSum = arrSum.add(BigInteger.valueOf(num));
			arrSumSq = arrSumSq.add(BigInteger.valueOf(num).multiply(BigInteger.valueOf(num)));
			
			BigInteger idxPos = BigInteger.valueOf(i).add(BigInteger.ONE);
			idxSum = idxSum.add(idxPos);
			idxSumSq = idxSumSq.add(idxPos.multiply(idxPos));
			
		}
		
		BigInteger ypx = idxSumSq.subtract(arrSumSq).divide(idxSum.subtract(arrSum));
		BigInteger ymx = idxSum.subtract(arrSum);
		
		
		BigInteger y = ypx.add(ymx).divide(BigInteger.valueOf(2));
		BigInteger x = ypx.subtract(y);
		
		List<Integer> b  = new ArrayList<>();
		b.add(x.intValue());
		b.add(y.intValue());
		
		return b;
	}
	
	

}
