package com.practice.heapsmaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LFUCache {
	
	int capacity = 0;
	Map<Integer, Integer> keyValueMap = new HashMap<>();
	Map<Integer, Integer> keyToFreqMap = new HashMap<>();
	TreeMap<Integer, Set<Integer>> freqToKeySortedMap = new TreeMap<>();

	public LFUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(keyValueMap.containsKey(key)){
			// get old freq and remove this key from set of that frequency
			int freq = keyToFreqMap.get(key);
			Set<Integer> set = freqToKeySortedMap.get(freq);
			set.remove(key);
			
			// remove if set is empty so that next lowest frequency become lowest
			if(set.isEmpty()){
				freqToKeySortedMap.remove(freq);
			}
			
			// increment frequency and update in freqToKeySortedMap
			freq++;
			updateFreqToWordsMap(freq, key);
			keyToFreqMap.put(key, freq);
			
			return keyValueMap.get(key);
		}
		
		return -1;
	}

	public void put(int key, int value) {
		
		if (keyToFreqMap.containsKey(key)) {
			// call get to increment the frequency
			get(key);
			// update the new value
			keyValueMap.put(key, value);
		} else {
			if (keyToFreqMap.size() < capacity) {
				// cache has capacity and key has come first time so put it with frequency 1
				keyValueMap.put(key, value);
				keyToFreqMap.put(key, 1);
				updateFreqToWordsMap(1, key);
			} else if(!keyValueMap.isEmpty()){
				// get lowest frequency and remove first key in its set (least recently used)
				// and remove that key from all maps
				int lowestFreq = freqToKeySortedMap.firstKey();
				Set<Integer> set = freqToKeySortedMap.get(lowestFreq);
				Iterator<Integer> iter = set.iterator();
				int leastUsedLowestFreqKey = iter.next();
				set.remove(leastUsedLowestFreqKey);
				
				if(set.isEmpty()){
					freqToKeySortedMap.remove(lowestFreq);
				}

				keyToFreqMap.remove(leastUsedLowestFreqKey);
				keyValueMap.remove(leastUsedLowestFreqKey);
				put(key, value);
			}
		}
	}

	private void updateFreqToWordsMap(int freq, int value) {
		Set<Integer> set = freqToKeySortedMap.get(freq);
		if (set == null) {
			set = new LinkedHashSet<>();
			freqToKeySortedMap.put(freq, set);
		}
		set.add(value);
	}
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(10);
		String input = "10,13&3,17&6,11&10,5&9,10&13&2,19&2&3&5,25&8&9,22&5,5&1,30&11&9,12&7&5&8&9&4,30&9,3&9&10&10&6,14&3,1&3&10,11&8&2,14&1&5&4&11,4&12,24&5,18&13&7,23&8&12&3,27&2,12&5&2,9&13,4&8,18&1,7&6&9,29&8,21&5&6,30&1,12&10&4,15&7,22&11,26&8,17&9,29&5&3,4&11,30&12&4,29&3&9&6&3,4&1&10&3,29&10,28&1,20&11,13&3&3,12&3,8&10,9&3,26&8&7&5&13,17&2,27&11,15&12&9,19&2,15&3,16&1&12,17&9,1&6,19&4&5&5&8,1&11,7&5,2&9,28&1&2,2&7,4&4,22&7,24&9,26&13,28&11,26";
		String[] func = input.split("&");
		
		for (String s : func) {
			if(s.indexOf(',') == -1){
				System.out.println("Get "+s + ": "+lfu.get(Integer.parseInt(s)));
			} else{
				int sp = s.indexOf(',');
				System.out.println("Put "+s.substring(0, sp)+", "+s.substring(sp+1));
				lfu.put(Integer.parseInt(s.substring(0, sp)), Integer.parseInt(s.substring(sp+1)));
			}
		}
	}
	/*
	 * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
		[[2&1,1&2,2&1&3,3&2&3&4,4&1&3&4]]
	 */
}
