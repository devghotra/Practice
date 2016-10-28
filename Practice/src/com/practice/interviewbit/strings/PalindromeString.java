package com.practice.interviewbit.strings;

import java.util.regex.Pattern;

public class PalindromeString {

	public static void main(String[] args) {
		PalindromeString ps = new PalindromeString();
		System.out.println(ps.isPalindrome("a bccba"));

	}
	
	public int isPalindrome(String input){
		int l = 0;
		int h = input.length()-1;
		
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		
		while(l<h){
			if(p.matcher(""+input.charAt(l)).find()){
				l++;
				continue;
			}
			
			if(p.matcher(""+input.charAt(h)).find()){
				h--;
				continue;
			}
			
			if(Character.toLowerCase(input.charAt(l)) != Character.toLowerCase(input.charAt(h))){
				return 0;
			}
			l++;
			h--;
		}
		
		return 1;
	}

}
