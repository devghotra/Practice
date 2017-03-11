package com.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {

	public static void main(String[] args) {
		Integer[] bArr = {0,0,1,1};
		System.out.println(bulbs(new ArrayList<>(Arrays.asList(bArr))));

	}
	
	public static int bulbs(ArrayList<Integer> bulbs){
		int state = 0;
		int count = 0;
		
		for (int i = 0; i < bulbs.size(); i++) {
			if (bulbs.get(i) == state) {
				count++;
				state = 1 - state;
			}
		}
		
		return count;
	}
	
	// logically same - implemented by me
	public static int bulbs2(ArrayList<Integer> bulbs){
		boolean switchBulb = false;
		boolean toggle = true;
		int count = 0;
		
		for(int s : bulbs){
			if(s == 1 && !switchBulb)
				continue;
			
			switchBulb = true;
			
			if(s == 0){
				if(toggle){
					count++;
					toggle = !toggle;
				}
			} else if(!toggle){
				count++;
				toggle = !toggle;
			}
			
		}
		
		return count;
	}

}
