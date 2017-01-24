package com.practice.interviewbit.linkedlist;

public class MergeTwoSortedList {
	
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
