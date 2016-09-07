package com.practice.interviewbit.dp;

import java.util.HashMap;
import java.util.Map;

public class ArrangeHorsesInStables {

	public static void main(String[] args) {
		
		/*
		 * BBBBBBWWWBWBBWWBWBBBWBWBWBBWBBWBBWBWBWBWWWW - 27 Ans: 0
		 * WBBWBWBBBWWBBBWWBBWWWWWBBBWWBBWWWWBWBBBBBWW - 17 Ans: 2
		 * BBBWWBWBBBBWBBBBWWBBBWWWBWB - 23 Ans: 0
		 * BWBWBWBWBBWWBBWBBBWWWBBWBBWWBBBBWBWWWBBWBBBBBWB - 17 Ans: 13 
		 * WBWBWWBB - 3 Ans: 4
		 */
		
		
		String str = "BBWBBBWW";
		ArrangeHorsesInStables inst = new ArrangeHorsesInStables();
		
		System.out.println("Rec Score "+inst.arrangeRec(str, 3));
		System.out.println("DP Score "+inst.arrangeDynamic(str, 3));
	}
	
	/*										BBWBBBWW
	 * 								(L5)	dp[8][3]BB,WBBB,WW(3)
                                           /                  \    
                     dp[7][2]BBWBBB,W(5)                     dp[7][3]BB,WBBB,W(3)
                    /           \                       /            \    
          dp[6][1](5)       dp[6][2]BB,WBBB(3)     dp[6][2]    dp[6][3]BB,W,BBB(0)
        /            \        /     \                                /        \
dp[5][0]          dp[5][1] dp[5][1]   dp[5][2]BB,WBB(2)    dp[5][2]BB,WBB(2)    dp[5][3]BB,W,BB(0)
               /      \                /      \                                /        \
            dp[4][0]  dp[4][1]    dp[4][1]  dp[4][2]BB,WB        BB,WB(1)dp[4][2]    dp[4][3]BB,W,B(0)
                                           /      \                                /        \
                                    BBW dp[3][1]  dp[3][2]BB,W            dp[3][2]BB,W  	dp[3][3]
                                                    /        \
                                            BB dp[2][1]    dp[2][2]B,B
                                                          /      \
                                                       dp[1][1]B    dp[1][2]
                                                       
                                                       
                                                       BBW,BBB,WW
	 */
	
	public int arrangeDynamic(String a, int b) {
		Stable[][] memo = new Stable[a.length()+1][b+1];
		
		for(int i=0; i<=a.length(); i++){
			memo[i][0] = new Stable();
			memo[i][1] = new Stable(a.substring(0,i));//countScore(a.substring(0,i));
		}
		
		for(int i=0; i<=b; i++){
			memo[0][i] = new Stable();
		}
		
		for(int i=1; i<=a.length(); i++){
			char currentHorse = a.charAt(i-1);
			for(int j=2; j<=b; j++){
				if(i<j){
					memo[i][j] = new Stable();
					continue;
				}
				
				if(i==j){
					memo[i][j] = new Stable(""+currentHorse);
					continue;
				}
				
				Stable left = memo[i-1][j-1];
				int leftScore = left.val;
				Stable tempLeftStable = new Stable();
				if(currentHorse=='W'){
					tempLeftStable.w += 1; 
				} else{
					tempLeftStable.b += 1;
				}
				tempLeftStable.val = leftScore;
				
				Stable right = memo[i-1][j];
				Stable tempRightStable = new Stable(right.w, right.b);
				if(currentHorse=='W'){
					tempRightStable.w += 1; 
				} else{
					tempRightStable.b += 1;
				}
				int rightScore = right.val - (right.w*right.b) + tempRightStable.calulateAndReturnValue();
				tempRightStable.val = rightScore;
				
				if(tempLeftStable.val < tempRightStable.val){
					memo[i][j] = tempLeftStable;
				} else{
					memo[i][j] = tempRightStable;
				}
				
				/*
				int c1 = memo[i-1][j-1].val;
				int c2 = memo[i-1][j].val + countScore(a.substring(i-2,i));
				
				memo[i][j] = new Stable();
				memo[i][j].val = Integer.min(c1, c2);
				*/
				
			}
		}
		
		return memo[a.length()][b].val;
	}
	
	public int arrangeRec(String a, int b) {
		if(a == null || b > a.length()){
			return -1;
		}
		
		Map<String, Integer> countMap = new HashMap<>();
		int res = arrangeRec(a, b, countMap);
		return res;
	}

	public int arrangeRec(String a, int b, Map<String, Integer> countMap) {
		
		if(b > a.length() || a.length() <= 1){
			countMap.put(a+"-"+b, 0);
			return 0;
		}
		
		if(b==1){
			int score = countScore(a);
			countMap.put(a+"-"+b, score);
			return score;
		}
		
		Integer sum = null;
		for(int i=0; i<a.length();i++){
			for(int j=1;j<=a.length()-1;j++){
				String key1 = a.substring(0, j)+"-"+1;
				Integer s1 = countMap.get(key1);
				if(s1 == null){
					s1 = arrangeRec(a.substring(0, j), 1, countMap);
					countMap.put(key1, s1);
				}
				
				String key2 = a.substring(j)+"-"+(b-1);
				Integer s2 = countMap.get(key2);
				if(s2 == null){
					s2 = arrangeRec(a.substring(j), b-1, countMap);
					countMap.put(key2, s2);
				}
				
				int tempSum = s1+s2;
				if(sum == null || tempSum < sum){
					sum = tempSum;
				}
			}
		}
		
		if(sum == null)
			sum = 0;
		
		return sum;
	}
	
	public int countScore(String a){
		int w=0;
		int b=0;
		char[] arr = a.toCharArray();
		for(char c : arr){
			if(c=='W')
				w++;
			else
				b++;
		}
		
		return w*b;
	}
	
	class Stable{
		int w;
		int b;
		int val;
		
		public Stable() {}
		
		public Stable(int w, int b) {
			super();
			this.w = w;
			this.b = b;
			this.val = w*b;
		}
		
		public Stable(String a) {
			char[] arr = a.toCharArray();
			for(char c : arr){
				if(c=='W')
					w++;
				else
					b++;
			}
			
			val = b*w;
		}
		
		public int calulateAndReturnValue(){
			val = b*w;
			return val;
		}

		@Override
		public String toString() {
			return "Stable [w=" + w + ", b=" + b + ", val=" + val + "]";
		}
		
		
		
	}

}
