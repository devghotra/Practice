package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		// Set<String> palindromes = new HashSet<>();
		// pp.palindromes("missisippi", palindromes);
		// System.out.println(palindromes);

		ArrayList<ArrayList<String>> partitions = pp.partition("aabb");
		for (List<String> p : partitions) {
			System.out.println(p);
		}
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), s, 0);
		return list;
	}

	public void backtrack(ArrayList<ArrayList<String>> list, List<String> tempList, String s, int start) {
		if (start == s.length())
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindrome(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					backtrack(list, tempList, s, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}
}
