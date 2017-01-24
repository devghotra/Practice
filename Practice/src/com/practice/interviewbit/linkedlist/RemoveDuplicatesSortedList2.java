package com.practice.interviewbit.linkedlist;

public class RemoveDuplicatesSortedList2 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n21 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n21;
		// n21.next = n3;

		ListNode head = deleteDuplicates(n1);
		System.out.println(head);
	}

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode newHead = null;
		ListNode lastNonDupNode = null;
		ListNode prevNode = null;

		ListNode node = head;

		while (node != null) {
			if ((prevNode == null || node.val != prevNode.val) && (node.next == null || node.val != node.next.val)) {
				if (newHead == null) {
					newHead = node;
				} else {
					lastNonDupNode.next = node;
				}

				lastNonDupNode = node;
			}
			prevNode = node;
			node = node.next;
		}

		if (newHead != null)
			lastNonDupNode.next = null;

		return newHead;
	}

}
