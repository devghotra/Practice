package com.practice.strings.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix scp = new LongestCommonPrefix();
		//List<String> list = Lists.newArrayList("abcdefgh", "abcefgh");
		String[] list = {"abcdefgh", "abcefgh"};
		System.out.println("-"+scp.longestCommonPrefix(new ArrayList<>(Arrays.asList(list)))+"-");

	}
	
	public String longestCommonPrefix(ArrayList<String> list) {
	    
		if(list.size() == 0)
			return "";
		
		int i = 0;
		
		outer:
		while(i < list.get(0).length()){
			Character commonChar = list.get(0).charAt(i);
			for (int j = 1; j < list.size(); j++) {
				String s = list.get(j);
				if(i >= s.length() || commonChar.charValue() != s.charAt(i))
					break outer;
			}
			
			i++;
		}
		
		return list.get(0).substring(0, i);
	
	}

}
