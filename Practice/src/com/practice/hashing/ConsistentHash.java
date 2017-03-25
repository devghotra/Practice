package com.practice.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.common.hash.Hashing;

public class ConsistentHash<T> {
	private final int numberOfVirtualNodeReplicas;
	private final SortedMap<Long, T> circle = new TreeMap<Long, T>();
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public static void main(String[] args) {
		ArrayList<String> nodes = new ArrayList<>();
		nodes.add("1");
		nodes.add("2");
		nodes.add("3");
		// nodes.add("4");
		ConsistentHash<String> ch = new ConsistentHash<>(8, nodes);
		System.out.println(ch.get("saurabh"));
		System.out.println(ch.get("kakar"));
		System.out.println(ch.get("ryan"));
		System.out.println(ch.get("geet"));
		System.out.println(ch.get("kakar"));
		System.out.println(ch.get("ryan"));
		System.out.println(ch.get("atul2222"));
		System.out.println(ch.get("del"));
		ch.remove("3");
		System.out.println("--------Removed Node 3-------");
		System.out.println(ch.get("saurabh"));
		System.out.println(ch.get("kakar"));
		System.out.println(ch.get("ryan"));
		System.out.println(ch.get("geet"));
		System.out.println(ch.get("kakar"));
		System.out.println(ch.get("ryan"));
		System.out.println(ch.get("atul2222"));
		System.out.println(ch.get("del"));
		ch.add("4");
		System.out.println("--------After Added Node 4-------");
		System.out.println(ch.get("saurabh"));
		System.out.println(ch.get("kakar"));
		System.out.println(ch.get("ryan"));
		System.out.println(ch.get("geet"));
		System.out.println(ch.get("kakar"));
		System.out.println(ch.get("ryan"));
		System.out.println(ch.get("atul2222"));
		System.out.println(ch.get("del"));
	}

	public ConsistentHash(int numberOfVirtualNodeReplicas, List<T> nodes) {
		this.numberOfVirtualNodeReplicas = numberOfVirtualNodeReplicas;
		add(nodes);
	}

	public synchronized void add(T node) {
		w.lock();
		try {
			addNode(node);
		} finally {
			w.unlock();
		}
	}

	public synchronized void add(List<T> nodes) {
		w.lock();
		try {
			for (T node : nodes) {
				addNode(node);
			}
		} finally {
			w.unlock();
		}
	}

	public synchronized void remove(List<T> nodes) {
		w.lock();
		try {
			for (T node : nodes) {
				removeNode(node);
			}
		} finally {
			w.unlock();
		}
	}

	public synchronized void remove(T node) {
		w.lock();
		try {
			removeNode(node);
		} finally {
			w.unlock();
		}
	}

	public T get(Object key) {
		if (circle.isEmpty()) {
			return null;
		}
		long hash = getKetamaKey(key.toString()) % 20;
		r.lock();
		try {
			if (!circle.containsKey(hash)) {
				SortedMap<Long, T> tailMap = circle.tailMap(hash);
				hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
			}
			return circle.get(hash);
		} finally {
			r.unlock();
		}
	}

	private void addNode(T node) {
		for (int i = 0; i < numberOfVirtualNodeReplicas / 4; i++) {
			byte[] digest = md5(node + "-" + i);
			for (int h = 0; h < 2; h++) {
				Long key = getKetamaKey(digest, h) % 20;
				circle.put(key, node);
			}
		}
	}

	private void removeNode(T node) {
		for (int i = 0; i < numberOfVirtualNodeReplicas / 4; i++) {
			byte[] digest = md5(node.toString() + "-" + i);
			for (int h = 0; h < 4; h++) {
				circle.remove(getKetamaKey(digest, h) % 20);
			}
		}
	}

	public static byte[] md5(String text) {
		return Hashing.md5().hashBytes(text.getBytes()).asBytes();
	}

	public static long[] getKetamaKeys(String text) {
		long[] pairs = new long[4];
		byte[] digest = md5(text);
		for (int h = 0; h < 4; h++) {
			pairs[h] = getKetamaKey(digest, h);
		}
		return pairs;
	}

	public static long getKetamaKey(final String k) {
		byte[] digest = md5(k);
		return getKetamaKey(digest, 0) & 0xffffffffL;
	}

	public static Long getKetamaKey(byte[] digest, int h) {
		return ((long) (digest[3 + h * 4] & 0xFF) << 24) | ((long) (digest[2 + h * 4] & 0xFF) << 16) | ((long) (digest[1 + h * 4] & 0xFF) << 8)
				| (digest[h * 4] & 0xFF);
	}
}
