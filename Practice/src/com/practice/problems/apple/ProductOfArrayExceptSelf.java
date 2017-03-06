package com.practice.problems.apple;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] res = productExceptSelf(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;

		int[] product = new int[len];

		// product[i] is product of all left nums before i
		product[0] = 1;
		for (int i = 1; i < len; i++) {
			product[i] = product[i - 1] * nums[i - 1];
		}

		int rightProduct = 1;
		for (int i = len - 1; i >= 0; i--) {
			product[i] *= rightProduct;
			rightProduct *= nums[i];
		}

		return product;
	}
}
