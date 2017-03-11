package com.pcln.hotel.dsingh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShortestDistance {

	int distance = Integer.MAX_VALUE;
	int p1 = -1;
	int p2 = -1;
	int startIndex = 0;

	public int find(String filename, String firstWord, String secondWord) {

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				findDistance(words, firstWord, secondWord);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return distance;
	}

	public int findDistance(String[] words, String word1, String word2) {

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				p1 = i;
			} else if (words[i].equals(word2)) {
				p2 = i;
			}

			if (p1 != -1 && p2 != -1) {
				distance = Math.min(distance, Math.abs(p1 - p2 - 1));
			}
		}

		return distance;
	}

}

// for large file
// read file in chunks
// create an array of all words in that chunk
// call findDistance() iteratively, in response we can get 2 indexes and
// shortest distance in that chunk
// for next iteration we can send 2 indexes from previous iteration and
// calculate distance whenever there is a match
// if new distance is smaller than previous then replace

// check your algo now