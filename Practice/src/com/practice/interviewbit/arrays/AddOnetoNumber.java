package com.practice.interviewbit.arrays;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOnetoNumber {

	public static void main(String[] args) {
		Integer[] arr = {0};
		List<Integer> a = Arrays.asList(arr);
		
		
		List<Integer> b = plusOne(a);
		System.out.println(b);
		
	}
	
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
	
	/*
	 * 
	 * boolean start = false;
		for(int i=0; i < a.size(); i++){
			
			if(!start && a.get(i) == 0){
				continue;
			}
			
			start = true;
			
			int pow = a.size() - 1 - i;
			BigDecimal divideBy = new BigDecimal(Math.pow(10, pow), MathContext.DECIMAL128);
			
			BigInteger digit = number.divide(divideBy.toBigInteger());
			
			b.add(digit.intValue());
			
			
			number = number.remainder(divideBy.toBigInteger());
		}
		
		if(!b.isEmpty() && b.get(0) == 10){
			b.set(0, 0);
			b.add(0, 1);
		}
	 */

}
