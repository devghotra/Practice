package com.practice.interviewbit.strings;

public class LengthOfLastWord {

	public static void main(String[] args) {
		LengthOfLastWord inst = new LengthOfLastWord();
		System.out.println(inst.lengthOfLastWord("a  "));

	}

	public int lengthOfLastWord(String s) {
		
		int lastWordLength = 0;
		int currentLength = 0;
		char EMPTY = ' ';

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == EMPTY) {
				// replace lastWordLength  only if currentLength > 0, 
				// in case continuous empty spaces comes don't replace last word length 
				if(currentLength != 0)
					lastWordLength = currentLength;
				
				currentLength = 0;
			} else {
				currentLength++;
			}
		}

		return currentLength > 0 ? currentLength : lastWordLength;
	}
}
