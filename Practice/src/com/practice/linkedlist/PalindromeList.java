package com.practice.linkedlist;

public class PalindromeList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1); 
		ListNode n2 = new ListNode(4); n1.next = n2;
		ListNode n3 = new ListNode(2); n2.next = n3;
		ListNode n4 = new ListNode(1); n3.next = n4;
		
		/*
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		ListNode n6 = new ListNode(6); n5.next = n6;
		ListNode n7 = new ListNode(7); n6.next = n7;
		ListNode n8 = new ListNode(8); n7.next = n8;
		ListNode n9 = new ListNode(9); n8.next = n9;
		*/
		
		System.out.println(lPalin(n1));
	}
	
	public static int lPalin(ListNode A) {
		
		ListNode slow=A;
		ListNode fast=A;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast.next != null)
			fast = fast.next;
		
		if(slow.next != null){
			reverseList(slow.next);
			slow.next = fast;
		}
		
		while(slow.next != null){
			slow = slow.next;
			if(A.val != slow.val){
				return 0;
			}
			A = A.next;
		}
		
		return 1;
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
