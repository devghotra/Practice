package com.practice.backtracking.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {
	
	static Map<String, String> digitToLettersMap = new HashMap<>();
	
	public static void main(String[] args) {
		if(digitToLettersMap.isEmpty())
			populateMap();
		System.out.println(letterCombinations("22").toString()); 
	}
	
	public static ArrayList<String> letterCombinations(String digits){
		ArrayList<String> combinations = new ArrayList<>();
		
		if(digits.length() == 0)
			return combinations;
		
		if(digits.length() == 1){
			String lettersForNum = digitToLettersMap.get(digits);
			String[] letters = lettersForNum.split("");
			for(String letter : letters){
				combinations.add(letter);
			}
			return combinations;
		}
		
		String firstDigit = digits.substring(0, 1);
		String remainingDigits = digits.substring(1);
		
		List<String> partialCombinations = letterCombinations(remainingDigits);
		
		// append all letters for 1st digit one by one to partial combinations
		String lettersForDigit = digitToLettersMap.get(firstDigit);
		String[] letters = lettersForDigit.split("");
		for(String partialComb : partialCombinations){
			for(String letter : letters){
				combinations.add(letter+partialComb);
			}
		}
		
		Collections.sort(combinations);
		return combinations;
	}
	
	public static void populateMap(){
		digitToLettersMap.put("0", "0");
		digitToLettersMap.put("1", "1");
		digitToLettersMap.put("2", "abc");
		digitToLettersMap.put("3", "def");
		digitToLettersMap.put("4", "ghi");
		digitToLettersMap.put("5", "jkl");
		digitToLettersMap.put("6", "mno");
		digitToLettersMap.put("7", "pqrs");
		digitToLettersMap.put("8", "tuv");
		digitToLettersMap.put("9", "wxyz");
	
	}

}
