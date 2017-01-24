package com.practice.interviewbit.linkedlist;

public class SortList {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); 
		ListNode n3 = new ListNode(3); 
		ListNode n4 = new ListNode(4); 
		ListNode n5 = new ListNode(5); 
		ListNode n6 = new ListNode(6); 
		ListNode n7 = new ListNode(7); 
		ListNode n8 = new ListNode(8); 
		
		n6.next = n5;
		n5.next = n3;
		n3.next = n1;
		n1.next = n8;
		n8.next = n7;
		n7.next = n2;
		n2.next = n4;
		
		/*
		n3.next = n2;
		n2.next = n4; */
		
		System.out.println(sortList(n6));

	}

	public static ListNode sortList(ListNode head) {
		
		if(head == null)
			return head;
		
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast.next != null)
			fast = fast.next;
		
		if(slow == fast)
			return slow;
		
		ListNode temp = slow.next;
		slow.next = null;
		
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(temp);
		
		return mergeTwoLists(l1, l2);
	}
	
	public static ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode head = null;
		
		if(a.val <= b.val){
			head = a;
			a = a.next;
		} else{
			head = b;
			b = b.next;
		}
		
		ListNode node = head;
		while(a != null && b != null){
			if(a.val <= b.val){
				node.next = a;
				node = a;
				a = a.next;
			} else{
				node.next = b;
				node = b;
				b = b.next;
			}
		}
		
		if (a == null)
	        node.next = b;
	    else
	        node.next = a;
		
		return head;
	}

}
