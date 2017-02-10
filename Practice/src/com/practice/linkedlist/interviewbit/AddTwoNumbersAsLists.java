package com.practice.linkedlist.interviewbit;

public class AddTwoNumbersAsLists {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(4); //n1.next = n2;
		ListNode n3 = new ListNode(8); n2.next = n3;
		
		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(6); //m1.next = m2;
		ListNode m3 = new ListNode(4); m2.next = m3;
		ListNode m4 = new ListNode(2); m3.next = m4;
		
		System.out.println(addTwoNumbers(n1, m1));

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		int carry = 0;
		
		ListNode prev = dummy;
		
		while(l1 != null || l2 != null || carry != 0){
			int v1 = 0;
			int v2 = 0;
			
			if(l1 != null){
				v1 = l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null){
				v2 = l2.val;
				l2 = l2.next;
			}
			
			int sum = v1 + v2 + carry;
			
			ListNode node = new ListNode(sum % 10);
			prev.next = node;
			prev = node;
			
			carry = sum/10;
			
		}
		
		return dummy.next;
	}
}
