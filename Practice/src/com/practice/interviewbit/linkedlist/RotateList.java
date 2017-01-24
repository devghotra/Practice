package com.practice.interviewbit.linkedlist;

public class RotateList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		RotateList inst = new RotateList();
		ListNode head = inst.rotateRight(n1, 8);
		System.out.println(head);

	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		
		int size = 1; // since we are already at head node
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null) {
			size++;
			fast = fast.next;
		}

		for (int i = size - k % size; i > 1; i--) {
			slow = slow.next;
		}
		
		fast.next = head;
		head = slow.next;
		slow.next = null;

		return head;
	}
}
