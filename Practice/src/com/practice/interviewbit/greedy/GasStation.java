package com.practice.interviewbit.greedy;

import java.util.List;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 6, 1, 4, 3, 5 };
		int[] cost = { 3, 8, 2, 4, 2 };

		System.out.println(canCompleteCircuit(gas, cost));

	}

	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {

		int startingIndex = -1;
		int totalGas = 0;
		int totalCost = 0;

		int gasSoFar = 0;
		int costSoFar = 0;

		for (int i = 0; i < gas.size(); i++) {

			totalGas += gas.get(i);
			totalCost += cost.get(i);

			gasSoFar += gas.get(i);
			costSoFar += cost.get(i);

			if (gasSoFar < costSoFar) {
				gasSoFar = 0;
				costSoFar = 0;
				startingIndex = -1;
			} else if (startingIndex == -1) {
				startingIndex = i;
			}

		}

		int diff = totalGas - totalCost;
		return diff >= 0 ? startingIndex : -1;
	
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {

		int startingIndex = -1;
		int totalGas = 0;
		int totalCost = 0;

		int gasSoFar = 0;
		int costSoFar = 0;

		for (int i = 0; i < gas.length; i++) {

			totalGas += gas[i];
			totalCost += cost[i];

			gasSoFar += gas[i];
			costSoFar += cost[i];

			if (gasSoFar < costSoFar) {
				gasSoFar = 0;
				costSoFar = 0;
				startingIndex = -1;
			} else if (startingIndex == -1) {
				startingIndex = i;
			}

		}

		int diff = totalGas - totalCost;
		return diff >= 0 ? startingIndex : -1;
	}
}
