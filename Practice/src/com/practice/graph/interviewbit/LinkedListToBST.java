package com.practice.graph.interviewbit;

public class LinkedListToBST {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		LinkedListToBST inst = new LinkedListToBST();
		
		TreeNode root = inst.sortedListToBST(n1);
		
		System.out.println(root);

	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode slowPrev = null;
		
		// find mid of linked list using 2 pointer approach and make it a root
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slowPrev = slow;
			slow = slow.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		
		if(head != slow){
			slowPrev.next = null;
			root.left = sortedListToBST(head);
			root.right = sortedListToBST(slow.next);
		}
		
		
		return root;
	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "[" + val + "]";
		}
		
		
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
		
		@Override
		public String toString() {
			return "[" + val + "]";
		}
	}
}