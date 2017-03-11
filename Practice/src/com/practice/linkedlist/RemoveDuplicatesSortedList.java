package com.practice.linkedlist;

public class RemoveDuplicatesSortedList {

	public static void main(String[] args) {
		
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode lastNonDupNode = head;
		ListNode prevNode = head;

		ListNode node = head.next;

		while (node != null) {
			if (node.val != prevNode.val) {
				lastNonDupNode.next = node;
				lastNonDupNode = node;
			}
			prevNode = node;
			node = node.next;
		}

		lastNonDupNode.next = null;

		return head;
	
	}

}
