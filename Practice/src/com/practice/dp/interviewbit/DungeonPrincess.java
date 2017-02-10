package com.practice.dp.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DungeonPrincess {

	public static void main(String[] args) {
		Integer[] arr1 = {1,-3,3};
		List<Integer> r1 = Arrays.asList(arr1);
		
		Integer[] arr2 = {0,-2,0};
		List<Integer> r2 = Arrays.asList(arr2);
		
		Integer[] arr3 = {-3,-3,-3};
		List<Integer> r3 = Arrays.asList(arr3);
		
		List<List<Integer>> a = new ArrayList<>();
		a.add(r1);
		a.add(r2);
		a.add(r3);

		DungeonPrincess inst = new DungeonPrincess();
		System.out.println(inst.calculateMinimumHP(a));
	}

	public int calculateMinimumHP(List<List<Integer>> a) {
		int rows = a.size();
		int cols = a.get(0).size();
		KnightsHealth[][] dp = new KnightsHealth[rows][cols];
		
		for(int i=0; i<rows; i++){
			List<Integer> row = a.get(i);
			for(int j=0; j<cols; j++){
				int power = row.get(j);
				int minimum = 0;
				int current = 0;
				
				// left
				KnightsHealth leftKnightHealth = (j-1 < 0) ? null : dp[i][j-1];
				
				// up
				KnightsHealth upKnightHealth = (i-1 < 0) ? null : dp[i-1][j];
				
				KnightsHealth minKnightHealth = leftKnightHealth;
				if(upKnightHealth != null){
					if(minKnightHealth == null){
						minKnightHealth = upKnightHealth;
					} else{
						int leftCost = leftKnightHealth.minimum - (leftKnightHealth.current+power <=0 ? leftKnightHealth.current+power-1 : 0);
						int upCost = upKnightHealth.minimum - (upKnightHealth.current+power <=0 ? upKnightHealth.current+power-1 : 0);
						
						if(leftCost == upCost){
							minKnightHealth = leftKnightHealth.current > upKnightHealth.current ? leftKnightHealth : upKnightHealth;
						} else{
							minKnightHealth = leftCost < upCost ? leftKnightHealth : upKnightHealth;
						}
					}
				}
				
				if(power >= 0){
					current = minKnightHealth != null ? minKnightHealth.current + power : power+1;
					minimum = minKnightHealth != null ? minKnightHealth.minimum : 1;
					
				} else{
					if(minKnightHealth != null){
						int diff = minKnightHealth.current + power;
						if(diff <= 0){
							current = 1;
							minimum = minKnightHealth.minimum-diff+1;
						} else{
							current = minKnightHealth.current + power;
							minimum = minKnightHealth.minimum;
						}
					} else{
						current = 1;
						minimum = 1 - power;
					}
				}
				
				dp[i][j] = new KnightsHealth(minimum, current);
			}
		}
		
		return dp[rows-1][cols-1].minimum;
	}
	
	

}

class KnightsHealth{
	int minimum;
	int current;
	
	public KnightsHealth(int minimum, int current) {
		super();
		this.minimum = minimum;
		this.current = current;
	}

	@Override
	public String toString() {
		return "KnightsHealth ["+minimum+"/"+current+"]";
	}
	
	
	
}