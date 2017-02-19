package com.practice.dp.interviewbit;

import java.util.Arrays;
import java.util.List;

public class MaxProfitShares2 {

	public static void main(String[] args) {
		MaxProfitShares2 inst = new MaxProfitShares2();

		Integer[] arr = { 3, 2, 1 };
		System.out.println(inst.maxProfit(Arrays.asList(arr)));
		System.out.println(inst.maxProfitV1(Arrays.asList(arr)));

	}

	public int maxProfit(final List<Integer> a) {
		if (a.size() < 2)
			return 0;
		
		int totalProfit = 0;
		int minPrice = a.get(0);

		for (int i = 1; i < a.size(); i++) {
			// if price has gone down then only calculate profit for current streak (a.get(i - 1) - minPrice)
			if (a.get(i) < a.get(i - 1)) {
				int profit = a.get(i - 1) - minPrice;
				if (profit > 0)
					totalProfit += profit;

				// since this is lower than prev day price - from now onwards this is lowest price
				minPrice = a.get(i);
			}
		}

		// if prices in the end have increased
		int profit = a.get(a.size() - 1) - minPrice;
		if (profit > 0)
			totalProfit += profit;

		return totalProfit;

	}
	
	/*
	 * Another approach - Stores profit for each day in a separate array
	 */
	public int maxProfitV1(final List<Integer> a) {
		if (a == null || a.isEmpty() || a.size() < 2)
			return 0;

		int totalProfit = 0;
		int[] profit = new int[a.size() + 1];

		for (int i = 2; i <= a.size(); i++) {
			int diff = a.get(i - 1) - a.get(i - 2);
			if (diff > 0) {
				profit[i] = profit[i - 1] + diff;
			} else {
				totalProfit = totalProfit + profit[i - 1];
				profit[i] = 0;
			}
		}

		totalProfit = totalProfit + profit[a.size()];

		return totalProfit;

	}

}
