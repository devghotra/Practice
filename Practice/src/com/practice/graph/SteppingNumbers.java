package com.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {
	
	public static void main(String[] args) {
		SteppingNumbers sn = new SteppingNumbers();
		System.out.println(sn.stepnum(100, 200));
	}

	public ArrayList<Integer> stepnum(int l, int h) {
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i <= 9; i++) {
			bfs(i, l, h, result);
		}

		Collections.sort(result);
		return result;
	}

	private void bfs(int n, int l, int h, ArrayList<Integer> result) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(n);

		while (!Q.isEmpty()) {
			Integer num = Q.poll();
			if (num >= l && num <= h) {
				result.add(num);
			}

			if (num == 0 || num > h)
				continue;

			int lastDigit = num % 10;
			int num1 = num * 10 + (lastDigit - 1);
			int num2 = num * 10 + (lastDigit + 1);

			if(lastDigit == 0)
				Q.add(num2);
			else if(lastDigit == 9)
				Q.add(num1);
			else{
				Q.add(num1);
				Q.add(num2);
			}
		}
	}

}
