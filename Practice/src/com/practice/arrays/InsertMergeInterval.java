package com.practice.arrays;

import java.util.ArrayList;
import java.util.List;

import com.practice.arrays.MergeOverlappingIntervals.Interval;

public class InsertMergeInterval {

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		//intervals.add(new Interval(3, 3));
		//intervals.add(new Interval(6, 11));
		
		System.out.println(insert(intervals, new Interval(2,7)));

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> res = new ArrayList<>();
		res.add(newInterval);

		if (intervals.isEmpty()) {
			return res;
		}
		
		for (int i = 0; i < intervals.size(); i++) {
			Interval ci = intervals.get(i);
			
			if(ci.end < newInterval.start){
				res.add(res.size() - 1, ci);
			} else if (ci.start > newInterval.end){
				res.add(ci);
			} else{
				res.get(res.size()-1).start = Math.min(ci.start, newInterval.start);
				res.get(res.size()-1).end = Math.max(ci.end, newInterval.end);
			}
			
		}

		return res;

	}
}
