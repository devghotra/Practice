package com.practice.linkedlist.interviewbit;

public class ReorderList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); n1.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		ListNode n6 = new ListNode(6); n5.next = n6;

		reorderList(n1);
		System.out.println(n1);

	}

	public static void reorderList(ListNode head) {
		if (head == null)
			return;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode n1 = head;
		ListNode n2 = reverse(slow.next);
		slow.next = null; // break the link between 1st half and reversed 2nd half

		while (n1 != null && n2 != null) {
			ListNode tempN1 = n1.next;
			ListNode tempN2 = n2.next;

			n1.next = n2;
			n2.next = tempN1;
			
			n1 = tempN1;
			n2 = tempN2;
		}

	}

	private static ListNode reverse(ListNode head) {
		ListNode node = head;
		ListNode prev = null;

		while (node != null) {
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}

		return prev;

	}

}
