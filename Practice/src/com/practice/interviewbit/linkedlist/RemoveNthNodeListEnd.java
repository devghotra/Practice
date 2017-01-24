package com.practice.interviewbit.linkedlist;

public class RemoveNthNodeListEnd {

	public static void main(String[] args) {
		RemoveNthNodeListEnd inst = new RemoveNthNodeListEnd();

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		
		n1.next = n2;
		
		ListNode head = inst.removeNthFromEnd(n1, 1);
		System.out.println(head);

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {

			if (n < 0)
				slow = slow.next;
			
			fast = fast.next;
			n--;
		}

		if(n >= 0){
			return head.next;
		} else if (slow.next != null){
			slow.next = slow.next.next;
		}

		return head;
	}

}
