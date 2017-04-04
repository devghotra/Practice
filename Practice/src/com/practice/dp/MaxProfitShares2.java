package com.practice.dp;

import java.util.Arrays;
import java.util.List;

public class MaxProfitShares2 {

	public static void main(String[] args) {
		MaxProfitShares2 inst = new MaxProfitShares2();

		Integer[] arr = { 3, 2, 1 };
		System.out.println(inst.maxProfit(Arrays.asList(arr)));

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

}
