package com.practice.dp;

import java.util.Arrays;
import java.util.List;

public class MaxProductSubArray {

	public static void main(String[] args) {
		Integer[] arr = { 0, -3, 2, -3, 0, -3, -2, 0 };
		System.out.println(maxProduct(Arrays.asList(arr)));
	}

	public static int maxProduct(final List<Integer> a) {

		int maxProduct = a.get(0);
		int continousProduct = a.get(0);
		int continousPositiveProduct = a.get(0) > 0 ? a.get(0) : 1;

		for (int i = 1; i < a.size(); i++) {
			int num = a.get(i);

			if (num == 0) {
				continousProduct = 1;
				continousPositiveProduct = 1;
				maxProduct = Math.max(maxProduct, num); // if all nums are negative and 1 zero somewhere between
			} else if (num > 0) {
				continousPositiveProduct *= num;
				continousProduct *= num;
				maxProduct = Math.max(Math.max(maxProduct, num), Math.max(continousPositiveProduct, continousProduct));
			} else {
				continousProduct *= num;
				maxProduct = Math.max(Math.max(maxProduct, num), Math.max(continousProduct, num * a.get(i - 1)));
				continousPositiveProduct = 1; // reset positive product to 1 when negative num is encountered
			}
		}

		return maxProduct;
	}

	/* OLD Approach
	 * 1. take a number
	 * 2. multiply with current max product
	 * 3. multiply with prev number
	 * 4. choose current max product = max(step2,step3)
	 * 5. Also keep track of current negative product, reset to current num if
	 * product is zero
	 * 6. at the end of each iteration max product is max of (num,
	 * currentNegativeProduct, currentMaxProduct, maxProduct)
	 */
	public static int maxProductV1(final List<Integer> a) {

		int maxProduct = a.get(0);

		int currentMaxProduct = a.get(0);
		int currentNegativeProduct = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			int num = a.get(i);

			int p1 = a.get(i - 1) * num;
			int p2 = num * currentMaxProduct;

			currentMaxProduct = Integer.max(p1, p2);

			currentNegativeProduct = num * currentNegativeProduct == 0 ? num : num * currentNegativeProduct;

			maxProduct = Integer.max(Integer.max(num, currentNegativeProduct), Integer.max(currentMaxProduct, maxProduct));
		}

		return maxProduct;
	}

}
