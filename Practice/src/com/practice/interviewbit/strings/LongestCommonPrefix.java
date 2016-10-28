package com.practice.interviewbit.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix scp = new LongestCommonPrefix();
		//List<String> list = Lists.newArrayList("abcdefgh", "abcefgh");
		String[] list = {""};
		System.out.println("-"+scp.longestCommonPrefix(list)+"-");

	}
	
	public String longestCommonPrefix(ArrayList<String> list) {
		if(list.size() == 0)
			return "";
		
		int i = 0;
		
		outer:
		while(true){
			Character commonChar = null;
			for(String s : list){
				if(i == s.length() || (commonChar != null && commonChar.charValue() != s.charAt(i)))
					break outer;
				
				if(commonChar == null){
					commonChar = s.charAt(i);
					continue;
				}
			}
			
			i++;
		}
		
		return list.get(0).substring(0, i);
	}
	
	
	// count common char approach
	public String longestCommonPrefix(String[] list){
		if(list.length == 0)
			return "";
		
		int[] charsCount = new int[256];
		
		int i = 0;
		while(true){
			Character commonChar = null;
			for(String s : list){
				if(i < s.length()){
					commonChar = s.charAt(i);
					charsCount[commonChar]++;
				} else{
					break;
				}
			}
			
			if(commonChar == null || charsCount[commonChar] != list.length)
				break;
			
			
			i++;
			charsCount[commonChar]=0;
		}
		
		return list[0].substring(0, i);
	}

}
