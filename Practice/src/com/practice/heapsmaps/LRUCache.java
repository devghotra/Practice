package com.practice.heapsmaps;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);

		lru.get(2);
		lru.set(2, 6);
		lru.get(1);
		lru.set(1, 5);
		lru.set(1, 2);
		lru.get(1);
		lru.get(2);

		System.out.println("done");
	}

	private int size = 0;
	private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

	public LRUCache(int size) {
		this.size = size;
	}

	public void set(Integer key, Integer val) {

		if (cache.containsKey(key)) {
			cache.remove(key);
			cache.put(key, val);
			return;
		} else if (cache.size() == size) {
			Iterator<Integer> keySet = cache.keySet().iterator();
			cache.remove(keySet.next());
		}

		cache.put(key, val);
	}

	public Integer get(Integer key) {
		Integer val = cache.get(key);

		if (val == null) {
			return -1;
		} else {
			cache.remove(key);
			cache.put(key, val);
			return val;
		}
	}

}
