package com.practice.linkedlist.interviewbit;

public class ReverseSingleList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1); 
		ListNode n2 = new ListNode(2); n1.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		
		reverseList(n1);
	}
	
	public static ListNode reverseList(ListNode a) {
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

}
