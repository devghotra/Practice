package com.practice.linkedlist;

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

		ListNode current = head;

		while (current != null) {
			if ((prevNode == null || current.val != prevNode.val) && (current.next == null || current.val != current.next.val)) {
				if (newHead == null) {
					newHead = current;
				} else {
					lastNonDupNode.next = current;
				}

				lastNonDupNode = current;
			}
			prevNode = current;
			current = current.next;
		}

		if (newHead != null)
			lastNonDupNode.next = null;

		return newHead;
	}

}
