package com.practice.linkedlist;

public class PartitionList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); n1.next = n1;
		
		System.out.println(partition(n1, 0));

	}

	public static ListNode partition(ListNode head, int x) {
		
		ListNode l1Head = null;
		ListNode l2Head = null;
		
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		
		ListNode node = head;
		while(node != null){
			ListNode temp = node.next;
			node.next = null;
			
			if(node.val < x){
				if(l1Head == null)
					l1Head = node;
				
				l1.next = node;
				l1 = node;
			} else{
				if(l2Head == null)
					l2Head = node;
				
				l2.next = node;
				l2 = node;
			}
			
			node = temp;
		}
		
		if(l1Head != null){
			l1.next = l2Head;
			return l1Head;
		} else{
			return l2Head;
		}
		
	}

}
