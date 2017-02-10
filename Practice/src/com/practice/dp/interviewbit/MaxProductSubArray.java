package com.practice.dp.interviewbit;

import java.util.Arrays;
import java.util.List;

public class MaxProductSubArray {

	public static void main(String[] args) {
		Integer[] arr = {0, -3, 2, -3, 0, -3, -2, 0};
		System.out.println(maxProduct(Arrays.asList(arr)));
	}
	/*
	 * 1. take a number
	 * 2. multiply with current max product 
	 * 3. multiply with prev number
	 * 4. choose current max product  = max(step2,step3)
	 * 5. Also keep track of current negative product, reset to current num if product is zero
	 * 6. at the end of each iteration max product is max of (num, currentNegativeProduct, currentMaxProduct, maxProduct)
	 */
	public static int maxProduct(final List<Integer> a) {
		
		int maxProduct = a.get(0);
		
		int currentMaxProduct = a.get(0);
		int currentNegativeProduct = a.get(0);
		for(int i=1; i<a.size(); i++){
			int num = a.get(i);
			
			int p1 = a.get(i-1) * num;
			int p2 = num * currentMaxProduct;
			
			currentMaxProduct = Integer.max(p1, p2);
			
			currentNegativeProduct = num * currentNegativeProduct == 0 ? num : num * currentNegativeProduct;
			
			maxProduct = Integer.max(Integer.max(num, currentNegativeProduct), Integer.max(currentMaxProduct, maxProduct));
		}
		
		
		return maxProduct;
	}

}
