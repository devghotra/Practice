package com.practice.tree.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Google, Airbnb
public class PalindromePairs {

	TrieNode root = new TrieNode(' ');

	public static void main(String[] args) {
		PalindromePairs pp = new PalindromePairs();

		//String[] words = { "a", "" };
		String[] words = { "abcd", "dcba", "lls", "s", "sssll"};
		//String[] words = { "a", "b", "c", "ab", "ac", "aa" };
		List<List<Integer>> result = pp.palindromePairs(words);
		System.out.println(result);
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			insert(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			search(words[i], i, result);
		}

		return result;
	}

	public void search(String word, int i, List<List<Integer>> result) {
		TrieNode current = root;

		for (int j = 0; j < word.length(); j++) {
			char c = word.charAt(j);

			if (current.isEnd && current.index != i && isPalindrome(word, j, word.length() - 1)) {
				result.add(Arrays.asList(i, current.index));
			}

			TrieNode child = current.children.get(c);
			if (child == null) {
				return;
			} else {
				current = child;
			}
		}


		for (Integer j : current.palindroneIndexesSet) {
			if (i != j) {
				result.add(Arrays.asList(i, j));
			}
		}
	
	}

	public void insert(String word, int index) {
		TrieNode current = root;

		for (int i = word.length() - 1; i >= 0; i--) {
			char c = word.charAt(i);
			TrieNode child = current.children.get(c);
			if (child == null) {
				child = new TrieNode(c);
				current.children.put(c, child);
			}
			if (isPalindrome(word, 0, i)) {
				current.palindroneIndexesSet.add(index);
			}
			current = child;
		}

		current.palindroneIndexesSet.add(index);
		current.index = index;
		current.isEnd = true;
	}

	private boolean isPalindrome(String word, int i, int j) {
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--))
				return false;
		}

		return true;
	}

}

class TrieNode {

	char val;
	Set<Integer> palindroneIndexesSet = new HashSet<>();
	Map<Character, TrieNode> children = new HashMap<>();
	int index = -1;
	boolean isEnd;

	public TrieNode(char c) {
		this.val = c;
	}

	public String toString1() {
		return "[val=" + val + ", idxPlnBlw=" + palindroneIndexesSet + ", children=" + children + ", isEndIndex=" + index + "]";
	}

	public String toString() {
		return "[" + val + "]";
	}
}