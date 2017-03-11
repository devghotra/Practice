package com.practice.linkedlist;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2); n1.next = n2;
		System.out.println(insertionSortList(n1));
	}

	public static ListNode insertionSortList(ListNode head) {
		
		ListNode dummy = new ListNode(0);

		ListNode node = head;
		while(node != null){
			ListNode temp = node.next;
			node.next = null; // break link to the rest of list to avoid circular reference
			
			if(dummy.next == null){
				dummy.next = node;
			} else{
				ListNode sortedNode = dummy.next;
				ListNode prev = dummy;
				while(sortedNode != null){
					if(node.val < sortedNode.val){
						prev.next = node;
						node.next = sortedNode;
						break;
					}
					prev = sortedNode;
					sortedNode = sortedNode.next;
				}
				
				// if sorted sub-list iteration doesn't break then this node is largest so far so append in the end
				if(sortedNode == null){
					prev.next = node;
				}
			}
			
			node = temp;
		}
		
		return dummy.next;
	}
}
