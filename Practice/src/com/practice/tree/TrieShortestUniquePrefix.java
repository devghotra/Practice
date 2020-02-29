package com.practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Another approach - http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
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
		/*
		for (String word : words) {
			trie.insert(word);
		}
		
		System.out.println(trie.search("bearcat"));
		*/
		System.out.println(trie.prefix(words));
	}

	TrieNode root = new TrieNode(' ');

	public ArrayList<String> prefix(ArrayList<String> words) {
		ArrayList<String> result = new ArrayList<>();

		for (String word : words) {
			insert(word);
		}

		for (String word : words) {
			result.add(getShortestUniquePrefix(word));
		}

		return result;
	}

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

    private String getShortestUniquePrefix(String word) {
        TrieNode current = root;

        int lastSharedIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = current.childMap.get(c);
            if (child != null && child.childMap.size() > 1) {
                lastSharedIndex = i;
            }
            current = child;
        }

        return lastSharedIndex == -1 ? word.substring(0, 1) : word.substring(0, lastSharedIndex + 2);
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

    class TrieNode {
        char c;
        Map<Character, TrieNode> childMap;

        public TrieNode(char c) {
            this.c = c;
            childMap = new HashMap<>();
        }
    }

}