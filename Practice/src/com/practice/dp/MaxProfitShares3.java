package com.practice.dp;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProfitShares3 {

	public static void main(String[] args) {
		MaxProfitShares3 inst = new MaxProfitShares3();

		int[] arr = { 3, 2, 1 };
		System.out.println(inst.maxProfit(arr));

	}

	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int minPrice = prices[0];

		Queue<Integer> highToLowProfits = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));

		for (int i = 1; i < prices.length; i++) {
			// if price has gone down then only calculate profit for current streak (a.get(i - 1) - minPrice)
			if (prices[i] < prices[i - 1]) {
				int profit = prices[i - 1] - minPrice;
				
				// if price has gone down than prev min price then calculate profit and set new min price
				if(prices[i] < minPrice){
					highToLowProfits.add(profit);
					minPrice = prices[i];
				}
			}
		}

		// if prices in the end have increased
		int profit = prices[prices.length - 1] - minPrice;
		if (profit > 0)
			highToLowProfits.add(profit);

		if (highToLowProfits.size() == 0) {
			return 0;
		} else if (highToLowProfits.size() == 1) {
			return highToLowProfits.poll();
		} else {
			return highToLowProfits.poll() + highToLowProfits.poll();
		}

	}

}
