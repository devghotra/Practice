package com.practice.binarysearch;

public class SquareRootInteger {

	public static void main(String[] args) {
		System.out.println(sqrt(2));

	}
	
	public static int sqrt(int x) {
		if (x == 0)
			return 0;
		
		int left = 1, right = x;
		while (true) {
			if (left > x / left )
				return left-1;
			
			// implies (left+right)/2 but this approach will avoid overflow
			int mid = left + (right - left) / 2;
			
			// implies (mid*mid > x) but this approach will avoid overflow
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
	}
	
}
