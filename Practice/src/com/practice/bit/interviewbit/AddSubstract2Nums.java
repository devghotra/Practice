package com.practice.bit.interviewbit;

//http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
public class AddSubstract2Nums {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		
		System.out.println(~a+1);
		
		System.out.println(subtract(a, b));

	}

	public static int add(int x, int y) {
		while (y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y; // calculates carry 1 or 0

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;

			// Carry is shifted by one so that adding it to x gives the required sum
			y = carry << 1;
		}

		return x;
	}
	
	public static int subtract(int x, int y) {
		while (y != 0) {
			// borrow contains common set bits of y and unset bits of x
			int borrow = (~x) & y;

			// Subtraction of bits of x and y where at least one of the bits is not set
			x = x ^ y;
			
			// Borrow is shifted by one so that subtracting it from x gives the required sum
			y = borrow << 1;
		}

		return x;
	}
}
