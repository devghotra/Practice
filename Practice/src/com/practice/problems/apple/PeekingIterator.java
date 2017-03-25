package com.practice.problems.apple;

import java.util.Iterator;

// Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
// LC Problem - https://leetcode.com/problems/peeking-iterator/?tab=Description
// Apple
public class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> itr;
	private Integer nextVal = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		this.itr = iterator;
		if(itr.hasNext())
			nextVal = itr.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return nextVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int val = nextVal;
	    nextVal = itr.hasNext() ? itr.next() : null;
	    return val;
	}

	@Override
	public boolean hasNext() {
		return nextVal != null;
	}
}
