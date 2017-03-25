package com.practice.linkedlist;

public class SwapListNodesInPairs {

	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); 
		ListNode n3 = new ListNode(3); 
		ListNode n4 = new ListNode(4); 
		ListNode n5 = new ListNode(5); 
		ListNode n6 = new ListNode(6); 
		ListNode n7 = new ListNode(7); 
		ListNode n8 = new ListNode(8); 
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		System.out.println(swapPairs(n1));

	}

	public static ListNode swapPairs(ListNode head) {
	    
		if(head == null)
			return head;
		
		ListNode dummy = new ListNode(0);
		ListNode n1 = head;
		ListNode n2 = head.next;
		ListNode prev = dummy;
		
		while(n1 != null && n2 != null){
		    // keep ref to next iteration n1
		    ListNode nextN1 = n2.next;
			
			// swap adjacent
			n2.next = n1;
			
			// unlink from forward list (unordered list)
			n1.next = null;
			
			// connect with reordered list so far
			prev.next = n2;
			
			// set end of ordered list so far as prev
			prev = n1;
			
			// set n1 & n2 for next iteration
			n1 = nextN1;
			n2 = n1 != null ? n1.next : null;
			
		}
		
		// if there was only 1 element left
		if(n1 != null)
		    prev.next = n1;
		
		return dummy.next == null ? head : dummy.next;
		
	
	}
}
