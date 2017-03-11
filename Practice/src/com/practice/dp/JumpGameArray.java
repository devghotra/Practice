package com.practice.dp;

import java.util.Arrays;
import java.util.List;

public class JumpGameArray {

	public static void main(String[] args) {
		JumpGameArray intsn = new JumpGameArray();
		
		Integer[] arr = {2,1,1,1,4};
		System.out.println(intsn.canJump(Arrays.asList(arr)));

	}
	
	public int canJump(List<Integer> a) {
		
		int maxIndexReachedSoFar = 0;
		
		for(int i = 0; i < a.size(); i++){
			if(maxIndexReachedSoFar < i){
				return 0;
			}
			
			int possibleJumps = a.get(i);
			
			if(i + possibleJumps > maxIndexReachedSoFar){
				maxIndexReachedSoFar = i + possibleJumps;
			}
				
		}
		
		return 1;
	}

}
