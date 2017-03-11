package com.practice.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CareerCup_FB_FindMinSetforTargetRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval target = new Interval(3, 13);

		Interval[] ia = { new Interval(1, 4), new Interval(30, 40), new Interval(20, 91), new Interval(8, 10), new Interval(6, 7), new Interval(3, 9),
				new Interval(9, 12), new Interval(11, 14) };
		smallestIntervalSet(ia, target);

	}

	public static Set<Interval> smallestIntervalSet(Interval[] set, Interval target) {
		// Bottleneck is here. The array is sorted, giving this algorithm
		// O(nlogn) time
		Arrays.sort(set);

		// Create a set to store our ranges in
		Set<Interval> smallSet = new HashSet<Interval>();
		// Create a variable to keep track of the most optimal range, relative
		// to the range before it, at all times.
		Interval bestOfCurr = null;
		// Keep track of the specific number that any given range will need to
		// intersect with. Initialize it to the target-min-value.
		int currBestNum = target.min;
		// Go through each element in our sorted array.
		for (int i = 0; i < set.length; i++) {
			Interval currInterval = set[i];
			// If we have already passed our target max, break.
			if (currBestNum >= target.max)
				break;
			// Otherwise, if the current interval intersects with
			// our currBestNum
			if (currInterval.intersects(currBestNum)) {
				// If the current interval, which intersects currBestNum
				// has a greater max, then our current bestOfCurr
				// Update bestOfCurr to be equal to currInterval.
				if (bestOfCurr == null || currInterval.max >= bestOfCurr.max) {
					bestOfCurr = currInterval;
				}
			}
			// If our range does not intersect, we can assume that the most
			// recently
			// updated bestOfCurr is probably the most optimal new range to add
			// to
			// our set. However, if bestOfCurr is null, it means it was never
			// updated,
			// because there is a gap somewhere when trying to fill our target
			// range.
			// So we must check for null first.
			else if (bestOfCurr != null) {
				// If it's not null, add bestOfCurr to our set
				smallSet.add(bestOfCurr);
				// Update currBestNum to look for intervals that
				// intersect with bestOfCurr.max
				currBestNum = bestOfCurr.max;
				// This line is here because without it, it actually skips over
				// the next Interval, which is problematic if your sorted array
				// has two optimal Intervals next to eachother.
				i--;
				// set bestOfCurr to null, so that it won't run
				// this section of code twice on the same Interval.
				bestOfCurr = null;
			}

		}

		// Now we should just make sure that we have in fact covered the entire
		// target range. If we haven't, then we are going to return an empty
		// list.
		if (currBestNum < target.max)
			smallSet.clear();
		return smallSet;
	}

}

class Interval implements Comparable<Interval> {

	public Interval(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	int min;
	int max;

	boolean intersects(int num) {
		return (min <= num && max >= num);
	}

	@Override
	public int compareTo(Interval o) {
		// TODO Auto-generated method stub
		if (this.min < o.min)
			return -1;

		return 1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "min " + min + " max " + max;
	}
}