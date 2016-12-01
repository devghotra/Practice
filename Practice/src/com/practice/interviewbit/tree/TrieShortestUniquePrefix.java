package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrieShortestUniquePrefix {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		words.add("zebra");
		words.add("dog");
		words.add("duck");
		words.add("dove");
		words.add("bearcat");
		words.add("bert");

		TrieShortestUniquePrefix trie = new TrieShortestUniquePrefix();
		for (String word : words) {
			trie.insert(word);
		}
		
		System.out.println(trie.search("bearcat"));
	}

	TrieNode root = new TrieNode(' ');

	private void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			TrieNode child = current.childMap.get(c);
			if (child == null) {
				child = new TrieNode(c);
				current.childMap.put(c, child);
			}
			current = child;
		}
	}
	
	private boolean search(String word){
		TrieNode current = root;
		for(char c : word.toCharArray()){
			TrieNode child = current.childMap.get(c);
			if(child == null){
				return false;
			}
			current = child;
		}
		
		return true;
	}

	private String getShortestUniquePrefix(String word) {
		String shortestUniquePrefix = "";
		TrieNode current = root;

		int lastSharedIndex = -1;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			shortestUniquePrefix += c;
			TrieNode child = current.childMap.get(c);
			if (child != null && child.childMap.size() > 1) {
				lastSharedIndex = i;
			}
			current = child;
		}

		return lastSharedIndex == -1 ? shortestUniquePrefix.substring(0, 1) : shortestUniquePrefix.substring(0, lastSharedIndex + 2);
	}

	public ArrayList<String> prefix(ArrayList<String> words) {
		ArrayList<String> res = new ArrayList<>();

		for (String word : words) {
			insert(word);
		}

		for (String word : words) {
			res.add(getShortestUniquePrefix(word));
		}

		return res;
	}

}

class TrieNode {
	char c;
	Map<Character, TrieNode> childMap;

	public TrieNode(char c) {
		this.c = c;
		childMap = new HashMap<>();
	}
}