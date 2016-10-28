package com.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams ang = new Anagrams();
		ArrayList<String> input = new ArrayList<>();
        input.add("cat");
        input.add("dog");
        input.add("god");
        input.add("tca");
        input.add("cas");
        input.add("sac");
        input.add("tca");
		System.out.println(ang.anagrams(input));

	}

	public ArrayList<ArrayList<Integer>> anagrams(List<String> input) {
		ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

		Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
		for (int i = 1; i <= input.size(); i++) {
			String word = input.get(i-1);
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			StringBuilder sb = new StringBuilder();
			for (char c : chars) {
				sb.append(c);
			}

			String sortedWord = sb.toString();
			if (map.containsKey(sortedWord)) {
				ArrayList<Integer> l = map.get(sortedWord);
				l.add(i);
				map.put(sortedWord, l);
			} else {
				ArrayList<Integer> l = new ArrayList<>();
				l.add(i);
				map.put(sortedWord, l);
			}
		}
		
		for(String s : map.keySet()){
			resultList.add(map.get(s));
		}

		return resultList;
	}

}
