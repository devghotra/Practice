package com.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

	static class Interval {
		int start;
		int end;

		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(3, 5));

		System.out.println(merge(intervals).toString());
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<>();
		
		if(intervals.isEmpty())
			return res;
		
		Comparator<Interval> comparator = (i1, i2) -> new Integer(i1.start).compareTo(new Integer(i2.start));
		Collections.sort(intervals, comparator);
		
		res.add(intervals.get(0));
		
		for (int i = 1; i < intervals.size(); i++) {
			Interval pi = res.get(res.size()-1);
			Interval ci = intervals.get(i);
			
			if(ci.start <= pi.end){
				pi.start = Math.min(pi.start, ci.start);
				pi.end = Math.max(pi.end, ci.end);
			} else{
				res.add(ci);
			}
		}
		
		return res;
	}

}
