package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		//Set<String> palindromes = new HashSet<>();
		//pp.palindromes("missisippi", palindromes);
		//System.out.println(palindromes);
		
		ArrayList<ArrayList<String>> partitions = pp.partition("aabb");
		for(List<String> p : partitions){
			System.out.println(p);
		}
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		int length = s.length();
		
		ArrayList<ArrayList<String>> partitions = new ArrayList<>();
		
		if(isPalindrome(s)){
			ArrayList<String> p = new ArrayList<>();
			p.add(s);
			partitions.add(p);
		}
		
		for(int i=1; i<length; i++){
			String s1 = s.substring(0,i);
			String s2 = s.substring(i);
			
			// if s1 is palindrome then get partitions for s2, no need to check partitions of s1 as its alredy processed in previous iteration
			if(isPalindrome(s1)){
				ArrayList<ArrayList<String>> p2 = partition(s2);
				for(List<String> p : p2){
					// append s1 at beginning to all partitions returned for s2
					p.add(0, s1);
				}
				
				partitions.addAll(p2);
			}
		}
		
		sort(partitions);
		return partitions;
	} 
	
	private ArrayList<ArrayList<String>> sort(ArrayList<ArrayList<String>> partitions){
		Comparator<ArrayList<String>> comparator = new Comparator<ArrayList<String>>() {

			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {
				int loops = o1.size() < o2.size() ? o1.size() : o2.size();
				for(int i=0; i<loops; i++){
					if(o1.get(i).length() == o2.get(i).length()){
						continue;
					} else if(o1.get(i).length() < o2.get(i).length()){
						return -1;
					} else{
						return 1;
					}
				}
				return 0;
			}
			
		};
		
		Collections.sort(partitions, comparator);
		return partitions;
	}

	public boolean isPalindrome(String s) {
		int l = 0;
		int h = s.length()-1;
		while(l<h){
			if (s.charAt(l) != s.charAt(h)) {
				return false;
			}
			l++;
			h--;
		}

		return true;
	}
	
	// find all substring palindromes in given string
	public void palindromes(String s, Set<String> palindromes) {
		if (s == null || s.length() == 0)
			return;

		int length = s.length();
		if (length == 1) {
			palindromes.add(s);
			return;
		}

		for (int i = 0; i < length; i++) {
			String s1 = s.substring(0, length - i);
			if (isPalindrome(s1)) {
				palindromes.add(s1);
			}

			palindromes(s.substring(1), palindromes);
		}
	}
}
