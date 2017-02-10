package com.practice.dp.interviewbit;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance inst = new EditDistance();
		
		System.out.println(inst.minDistance("000123", "123"));

	}
	
	public int minDistance(String from, String to){
		int[][] ed = new int[to.length()+1][from.length()+1];
		
		for(int i=0; i<=to.length(); i++){
			for(int j=0; j<=from.length();j++){
				
				// base case - fill 1st row
				if(i==0){
					ed[i][j] = j;
					continue;
				}
				
				
				// base case - fill 1st col
				if(j==0){
					ed[i][j] = i;
					continue;
				}
				
				char toChar = to.charAt(i-1);
				char fromChar = from.charAt(j-1);
				
				if(fromChar == toChar){
					ed[i][j] = ed[i-1][j-1];
				} else{
					int replace = ed[i-1][j-1] + 1;
					int delete = ed[i][j-1] + 1;
					int insert = ed[i-1][j] + 1;
					ed[i][j] = Integer.min(replace, Integer.min(delete, insert));
				}
				
			}
		}
		
		return ed[to.length()][from.length()];
	}
}
