package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MaxPointsOnLine {

	public static void main(String[] args) {
		MaxPointsOnLine mp = new MaxPointsOnLine();
		Point[] points = null;
		int[][] po = { { 84, 250 }, { 0, 0 }, { 1, 0 }, { 0, -70 }, { 0, -70 }, { 1, -1 }, { 21, 10 }, { 42, 90 }, { -42, -230 } };
		// [{-42,-230}, {0,0}, {0,-70}, {0,-70}, {1,0}, {1,-1}, {21,10},
		// {42,90}, {84,250}]
		points = new Point[po.length];
		for (int i = 0; i < po.length; i++) {
			points[i] = new Point(po[i][0], po[i][1]);
		}

		System.out.println(mp.maxPoints(points));

	}
	
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		Point[] points = new Point[a.size()];
		for (int i = 0; i < a.size(); i++){
			points[i] = new Point(a.get(i), b.get(i));
		}
		
		return maxPoints(points);
	}

	public int maxPoints(Point[] points) {
		Comparator<Point> xComparator = (p1, p2) -> Integer.valueOf(p1.x).compareTo(Integer.valueOf(p2.x));
		Arrays.sort(points, xComparator);

		int maxPoints = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> map = new HashMap<>();
			Point p1 = points[i];
			int pointsCount = 1;
			for (int j = i + 1; j < points.length; j++) {
				Point p2 = points[j];

				// if points are same just increment the count, it will be added to all different slopes starting from this point
				if (pointsEqual(p1, p2)) {
					pointsCount++;
				} else {
					Double slope = calculateSlope(p1, p2);
					Integer count = map.get(slope) == null ? 1 + pointsCount : map.get(slope) + 1;
					map.put(slope, count);
				}
			}

			if (!map.isEmpty()) {
				List<Integer> countList = new ArrayList<>(map.values());
				Collections.sort(countList);
				maxPoints = Math.max(maxPoints, countList.get(countList.size() - 1));
			}

			maxPoints = Math.max(maxPoints, pointsCount);

		}

		return maxPoints;
	}

	private Double calculateSlope(Point p1, Point p2) {
		double yy = p2.y - p1.y;
		double xx = p2.x - p1.x;
		// horizontal scope
		if (xx == 0) 
			return 0.0;
		
		// vertical scope
		if (yy == 0) 
			return Double.MAX_VALUE;
		
		return (yy / xx);
	}

	public boolean pointsEqual(Point p1, Point p2) {
		if (p1.x == p2.x && p1.y == p2.y)
			return true;
		else
			return false;
	}

}

class Point {
	int x; int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b;}
}