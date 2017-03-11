package com.practice.strings;

public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(1));
	}

	public String countAndSay(int n) {
		String prevStr = "1";
		
		for (int i = 1; i < n; i++) {
			char lastChar = prevStr.charAt(0);
			int count = 1;
			// iterate previous string and create current string based on counts of characters in previous
			StringBuilder currentStr = new StringBuilder();
			for (int j = 1; j < prevStr.length(); j++) {
				char currentChar = prevStr.charAt(j);
				
				if(currentChar==lastChar){
					count++;
				} else{
					currentStr.append(count).append(lastChar);
					lastChar = currentChar;
					count = 1;
				}
			}
			
			currentStr.append(count).append(lastChar);
			prevStr = currentStr.toString();
			
		}

		return prevStr;
	}

}
