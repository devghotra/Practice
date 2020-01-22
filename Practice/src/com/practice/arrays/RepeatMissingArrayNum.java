package com.practice.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RepeatMissingArrayNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
	// 3rd solution seems easy to remember but won't work for read only array
	
	public List<Integer> repeatedNumber(final List<Integer> nums) {
		
		int arraySize = nums.size();
		BigInteger arrSum = BigInteger.ZERO;
		BigInteger arrSumSq = BigInteger.ZERO;
		
		BigInteger idxSum = BigInteger.ZERO;
		BigInteger idxSumSq = BigInteger.ZERO;
		
		for(int i = 0; i < arraySize; i++){
			
			int num = nums.get(i);
			arrSum = arrSum.add(BigInteger.valueOf(num));
			arrSumSq = arrSumSq.add(BigInteger.valueOf(num).multiply(BigInteger.valueOf(num)));
			
			BigInteger idxPos = BigInteger.valueOf(i).add(BigInteger.ONE);
			idxSum = idxSum.add(idxPos);
			idxSumSq = idxSumSq.add(idxPos.multiply(idxPos));
			
		}
		
		// sq(a) - sq(b) = (a+b)*(a-b)
		// idxSumSq.subtract(arrSumSq) => sq(a) - sq(b)
		BigInteger apb = idxSumSq.subtract(arrSumSq).divide(idxSum.subtract(arrSum));
		BigInteger amb = idxSum.subtract(arrSum);
		
		
		BigInteger b = apb.add(amb).divide(BigInteger.valueOf(2));
		BigInteger a = apb.subtract(b);
		
		List<Integer> res  = new ArrayList<>();
		res.add(a.intValue());
		res.add(b.intValue());
		
		return res;
	}

    public ArrayList<Integer> repeatedNumber1(final List<Integer> nums) {

        // a2 - b2 = (a+b)(a-b)
        // a - duplicate
        // b - missing num

        long aMinusb = 0;
        long a2Minusb2 = 0;

        for (int i = 0; i < nums.size(); i++) {
            aMinusb += nums.get(i) - (i + 1);
            a2Minusb2 += nums.get(i) * nums.get(i) - (i + 1) * (i + 1);
        }

        long aPlusb = a2Minusb2/aMinusb;

        long a = (aPlusb + aMinusb)/2;
        long b = aPlusb - a;

        ArrayList<Integer> res = new ArrayList<>();
        res.add((int)a);
        res.add((int)b);

        return res;
    }
	
	

}
