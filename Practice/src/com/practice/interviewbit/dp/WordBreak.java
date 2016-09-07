package com.practice.interviewbit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

	static String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
            "icecream","and","go","i","like","ice","cream"};
	
	static List<String> dictionaryList = Arrays.asList(dictionary);
	
	public static void main(String[] args) {

	}
	
	public boolean wordBreak(String str){
		
		List<String> matched = new ArrayList<>();
		
		int lastMatch = -1;
		String unmatched = "";
		for(int i=0;i<str.length(); i++){
			String s = str.substring(i, i+1);
			if(dictionaryList.contains(s)){
				lastMatch = i;
				matched.add(s);
			} else{
				for(String m : matched){
					if(dictionaryList.contains(m+s)){
						lastMatch = i;
						matched.add(m+s);
					}
				}
			}
		}
		
		return false;
	}

}
