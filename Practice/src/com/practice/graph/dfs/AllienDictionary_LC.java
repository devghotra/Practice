package com.practice.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AllienDictionary_LC {

	public static void main(String[] args) {
		
		AllienDictionary_LC ad = new AllienDictionary_LC();
		String[] words = {"zy", "zx"};
			//{ "baa", "abcd", "abca", "cab", "cad"};
		System.out.println(ad.alienOrder(words));

	}

	/*
	  	visited[i] = -1. Not even exist.
		visited[i] = 0. Exist. Non-visited.
		visited[i] = 1. Processing.
		visited[i] = 2. Processed.
	 */
	public String alienOrder(String[] words) {
		StringBuilder sb = new StringBuilder();

		int[] status = new int[26];
		List<Character>[] graph = buildGraph(words, status);
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < 26; i++) {
	        if(status[i] == 0) {
	        	char c = (char) ('a'+i);
	            if(!dfs(graph, status, stack, c)) 
	            	return "";
	        }
	    }
		
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}

		return sb.toString();
	}
	
	private boolean dfs(List<Character>[] graph, int[] status, Stack<Character> stack, char smallerChar){
		status[smallerChar-'a'] = 1;
		List<Character> biggerCharList = graph[smallerChar-'a'];
		if(biggerCharList != null){
			for (char biggerChar : biggerCharList) {
				// if processing - then its a cycle -> return false
				if(status[biggerChar-'a'] == 1)
					return false;
				
				// if processing not yet started in this bigger char
				if(status[biggerChar-'a'] == 0){
					if(!dfs(graph, status, stack, biggerChar))
						return false;
				}
			}
		}
		
		// mark smaller char as processed
		status[smallerChar-'a'] = 2;
		stack.push(smallerChar);
		return true;
	}

	private List<Character>[] buildGraph(String[] words, int[] status) {
		Arrays.fill(status, -1); // mark all as non-existing
		List<Character>[] graph = (List<Character>[])new ArrayList[26];
		
		for (int i = 0; i < words.length; i++) {
			for(char c : words[i].toCharArray()) status[c - 'a'] = 0; // mark existing
			
			if(i == 0)
				continue;
			
			String word1 = words[i-1];
			String word2 = words[i];

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					char c1 = word1.charAt(j);
					char c2 = word2.charAt(j);
					
					List<Character> biggerCharList = graph[c1-'a'];
					if(biggerCharList == null){
						biggerCharList = new ArrayList<>();
						graph[c1-'a'] = biggerCharList;
					}
					biggerCharList.add(c2);
					break;
				}
			}
		}
		return graph;
	}
	
	//https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs
	public String alienOrder_bfs_topoSort(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> degree = new HashMap<Character, Integer>();
		String result = "";
		
		if (words == null || words.length == 0)
			return result;
		
		for (String s : words) {
			for (char c : s.toCharArray()) {
				degree.put(c, 0);
			}
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i + 1];
			int length = Math.min(cur.length(), next.length());
			for (int j = 0; j < length; j++) {
				char biggerChar = cur.charAt(j);
				char smallerChar = next.charAt(j);
				if (biggerChar != smallerChar) {
					
					Set<Character> set = null;
					if (map.containsKey(biggerChar))
						set = map.get(biggerChar);
					else{
						set = new HashSet<Character>();
						map.put(biggerChar, set);
					}
					
					if (!set.contains(smallerChar)) {
						set.add(smallerChar);
						degree.put(smallerChar, degree.get(smallerChar) + 1);
					}
					break;
				}
			}
		}
		
		Queue<Character> q = new LinkedList<Character>();
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0)
				q.add(c);
		}
		
		while (!q.isEmpty()) {
			char c = q.remove();
			result += c;
			if (map.containsKey(c)) {
				Set<Character> biggerCharSet = map.get(c);
				for (char c2 : biggerCharSet) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0)
						q.add(c2);
				}
			}
		}
		
		if (result.length() != degree.size())
			return "";
		
		return result;
	}

}
