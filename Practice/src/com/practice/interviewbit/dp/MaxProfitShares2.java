package com.practice.interviewbit.dp;

import java.util.Arrays;
import java.util.List;

public class MaxProfitShares2 {

	public static void main(String[] args) {
		MaxProfitShares2 inst = new MaxProfitShares2();
		
		Integer[] arr = {3, 2, 1};
		System.out.println(inst.maxProfit(Arrays.asList(arr)));

	}
	
	public int maxProfit(final List<Integer> a) {
		if(a == null || a.isEmpty() || a.size() < 2)
			return 0;
		
		int totalProfit = 0;
		int[] profit = new int[a.size()+1];
		
		for(int i=2; i<=a.size();i++){
			int diff = a.get(i-1) - a.get(i-2);
			if(diff > 0){
				profit[i] = profit[i-1] + diff;
			} else{
				totalProfit = totalProfit + profit[i-1];
				profit[i] = 0;
			}
		}
		
		totalProfit = totalProfit + profit[a.size()];
		
		return totalProfit;
		
	}

}
