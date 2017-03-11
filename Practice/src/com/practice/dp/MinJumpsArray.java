package com.practice.dp;

import java.util.Arrays;
import java.util.List;

public class MinJumpsArray {

	public static void main(String[] args) {
		MinJumpsArray intsn = new MinJumpsArray();
		Integer[] arr = { 1,2,1,2,6,4,2,1 };
		System.out.println(intsn.jumpGreedy(Arrays.asList(arr)));
	}

	public int jumpGreedy(List<Integer> a) {

		int maxIndexReached = 0;
		int jumpsCountedTill = 0;
		int jumps = 0;

		for (int i = 0; i < a.size(); i++) {
			if (i > maxIndexReached)
				return -1;
			
			if (i > jumpsCountedTill){
				jumpsCountedTill = maxIndexReached;
				jumps++;
			}
			
			if (i + a.get(i) > maxIndexReached) {
				maxIndexReached = i + a.get(i);
			}
		}

		return jumps;
	}
	
	/*
	 * Populate each level which can be reached from current level and increment number of ways
	 * Also find min steps needed to reach to all those levels
	 * At the end of each iteration min steps for final level is found
	 * 
	 * Solution failed in time complexity
	 */

	public int jumpDynamicN2(List<Integer> a) {

		if (a == null || a.size() == 0 || (a.get(0) == 0 && a.size() > 1))
			return -1;

		if (a.size() == 1)
			return 0;

		int[] minJumps = new int[a.size()];
		minJumps[0] = 0;

		for (int i = 0; i < a.size() - 1; i++) {
			int maxSteps = a.get(i);

			if (maxSteps == 0) {
				continue;
			}

			int maxStepsPossible = Integer.min(maxSteps, a.size() - 1 - i);

			for (int j = 1; j <= maxStepsPossible; j++) {
				int currentMinJumps = minJumps[i + j];
				if (currentMinJumps == 0 || currentMinJumps > minJumps[i] + 1) {
					minJumps[i + j] = minJumps[i] + 1;
				}

				if (minJumps[a.size() - 1] > 0) {
					return minJumps[a.size() - 1];
				}
			}

		}

		return -1;

	}
}
