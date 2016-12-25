package com.practice.interviewbit.arrays;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {

	/**
	 * 
	 * Distance between 2 points in a grid can be calculated by considering both x and y coordinates on same level
	 * and then take max of absolute difference between x coordinates and y coordinates
	 */

	// X and Y co-ordinates of the points in order.
	// Each point is represented by (X.get(i), Y.get(i))
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		
		if (X == null || Y == null || X.size() < 2)
			return 0;

		int steps = 0;
		for (int i = 0; i < X.size() - 1; i++) {
			steps = steps + Math.max(Math.abs(X.get(i) - X.get(i + 1)), Math.abs(Y.get(i) - Y.get(i + 1)));
		}

		return steps;
	}
}