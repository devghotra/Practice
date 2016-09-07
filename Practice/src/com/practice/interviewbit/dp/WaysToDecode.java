package com.practice.interviewbit.dp;

public class WaysToDecode {

	public static void main(String[] args) {
		WaysToDecode inst = new WaysToDecode();
		System.out.println(inst.numDecodings("2611055971756562"));
		//121512719 - 20
		// 121512719739237191221242122134524 - 27040
		// 2611055971756562 - 4
		//5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190
	}

	public int numDecodings(String a) {
		
		if(a == null || a.isEmpty())
			return 0;
		
		int[] dp = new int[a.length()+1];
		
		// if String starts with 0 then just return 0;
		if(a.charAt(0)=='0'){
			return 0;
		} else{
			// If first char is some num then there is 1 way to decode it so set the base cases
			dp[0] = 1;
			dp[1] = 1;
		}
		
		for(int i=2; i<=a.length(); i++){
			// concatenate with previous digit and create a num
			int num = Integer.parseInt(a.charAt(i-2)+""+a.charAt(i-1));
			
			// if num contains 0 and is not 10 or 20 then it cannot be decoded so return 0
			if(num%10 == 0 && num/10 != 1 && num/10 != 2){
				return 0;
			}
			
			if(num == 10 || num == 20){
				// if num is 10 or 20 then its going to consume previous digit so any value added by previous digit is nullified, 
				// hence result is now back to what it was before the previous digit which is dp[i-2]
				dp[i] = dp[i-2];
			} else if(num <= 26 && a.charAt(i-2) != '0'){
				// if num is less then equal to 26 and previous digit was not 0 then result will be addition of previous 2 results
				// if previous digit was 0 then even if number is <= 26 it won't contribute to result
				dp[i] = dp[i-1] + dp[i-2]; 
			} else{
				// else its going to be same
				dp[i] = dp[i-1];
			}
			
			
		}
		
		return dp[a.length()];
	}
}
