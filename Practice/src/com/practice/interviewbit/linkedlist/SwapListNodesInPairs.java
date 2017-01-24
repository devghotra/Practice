package com.practice.interviewbit.linkedlist;

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
			prev.next = n2;
			
			ListNode nextN1 = n2.next;
			
			n1.next = nextN1;
			n2.next = n1;
			
			prev = n1;
			n1 = nextN1;
			n2 = n1 != null ? n1.next : null;
			
		}
		
		return dummy.next == null ? head : dummy.next;
		
	}
}
