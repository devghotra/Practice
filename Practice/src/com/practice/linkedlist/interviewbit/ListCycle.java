package com.practice.linkedlist.interviewbit;

public class ListCycle {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); n1.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n1;
		ListNode n4 = new ListNode(4); n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		ListNode n6 = new ListNode(6); n5.next = n2;
		
		detectCycle(n1);
		System.out.println("done");
		//System.out.println(detectCycle(n1));
	}

	public static ListNode detectCycle(ListNode head) {
		
		if(head == null)
			return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow){
				ListNode n1 = head;
				ListNode n2 = fast;
				
				while(n1 != n2){
					n1 = n1.next;
					n2 = n2.next;
				}
				
				return n1;
			}
			
		}
		
		return null;
	}
	
	public boolean hasCycle(ListNode head) {
		
		if(head == null)
			return false;
        
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow)
				return true;
			
		}
		
		return false;
    }
	
}
