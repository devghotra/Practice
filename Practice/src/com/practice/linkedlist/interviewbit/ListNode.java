package com.practice.linkedlist.interviewbit;

public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public ListNode reverseList(ListNode a) {
		ListNode node = a;
		ListNode prev = null;
		
		while(node != null){
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		
		return prev;
	}
	
	public String toString() {
		return "[val=" + val + ", next=" + next + "]";
	}
	
	public String toString1() {
		return "[val=" + val+"]";
	}
	
	
}
