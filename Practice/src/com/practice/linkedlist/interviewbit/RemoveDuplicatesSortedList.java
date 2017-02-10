package com.practice.linkedlist.interviewbit;

public class RemoveDuplicatesSortedList {

	public static void main(String[] args) {
		
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode newHead = null;
		ListNode lastNonDupNode = null;
		ListNode prevNode = null;

		ListNode node = head;

		while (node != null) {
			if (prevNode == null || node.val != prevNode.val) {
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
