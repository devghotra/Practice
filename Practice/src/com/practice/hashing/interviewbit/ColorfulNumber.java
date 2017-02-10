package com.practice.hashing.interviewbit;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

	public static void main(String[] args) {
		ColorfulNumber cn = new ColorfulNumber();
		System.out.println(cn.colorful(23));

	}

	public int colorful(int num) {
		String numStr = "" + num;
		char[] digitsArr = numStr.toCharArray();
		
		Set<Integer> productSet = new HashSet<>();
		for (int i = 0; i < digitsArr.length; i++) {
			int digit1 = Integer.valueOf(""+digitsArr[i]);
			int product = digit1;
			
			if(productSet.contains(product))
				return 0;
			
			productSet.add(digit1);
			
			for (int j = i+1; j < digitsArr.length; j++) {
				int digit2 = Integer.valueOf(""+digitsArr[j]);
				product = digit2*product;
				
				if(productSet.contains(product))
					return 0;
				else
					productSet.add(product);
			}
		}

		return 1;
	}

}
