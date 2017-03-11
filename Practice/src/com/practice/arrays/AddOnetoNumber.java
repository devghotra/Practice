package com.practice.arrays;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOnetoNumber {

	public static void main(String[] args) {
		Integer[] arr = {9, 9, 9, 9, 9};
		List<Integer> a = Arrays.asList(arr);
		
		
		List<Integer> b = plusOne(a);
		System.out.println(b);
		
		b = plusOneV1(a);
		System.out.println(b);
		
	}
	
	/*accepted by interview bit*/
	public static List<Integer> plusOneV1(List<Integer> a) {
		if(a == null || a.isEmpty())
			return a;
		
		Integer[] b = new Integer[a.size()];
		
		int carry = 1;
		for(int i=a.size()-1; i >= 0; i--){
			int digit = a.get(i);
			
			int sum = digit+carry;
			if(sum == 10){
				b[i] = 0;
				carry = 1;
			} else{
				b[i] = sum;
				carry = 0;
			}
		}
		
		List<Integer> resultList = new ArrayList<>();
		if(carry == 1){
			resultList.add(1);
			for(int i=0; i < b.length; i++){
				resultList.add(b[i]);
			}
		} else{
			boolean removeZero = true;
			for(int i=0; i < b.length; i++){
				if(b[i] != 0 || !removeZero){
					removeZero = false;
					resultList.add(b[i]);
				}
			}
		}
		
		return resultList;
		
	}
	
	/* correct solution but not accepted by interview bit*/
	public static List<Integer> plusOne(List<Integer> a) {
		
		if(a == null || a.isEmpty())
			return a;
		
		ArrayList<Integer> b = new ArrayList<>();
		
		BigInteger number = BigInteger.ZERO;
		for(int i=0; i < a.size(); i++){
			int digit = a.get(i);
			int pow = a.size() - 1 - i;
			
			BigDecimal multipleBy = new BigDecimal(Math.pow(10, pow), MathContext.DECIMAL128);
			number = number.add(BigInteger.valueOf(digit).multiply(multipleBy.toBigInteger()));
		}
		
		number = number.add(BigInteger.ONE);
		
		String strNum = number.toString();
		for(int i =0 ; i<strNum.length(); i++){
			b.add(Integer.parseInt(""+strNum.charAt(i)));
		}
		
		
		return b;
	}

}
