package com.practice.linkedlist;

public class ReverseLinkList2 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1); 
		ListNode n2 = new ListNode(2); n1.next = n2;
		ListNode n3 = new ListNode(3); n2.next = n3;
		ListNode n4 = new ListNode(4); //n3.next = n4;
		ListNode n5 = new ListNode(5); n4.next = n5;
		
		
		ListNode head = reverseBetween(n1, 2, 3);
		System.out.println(head);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode node = head;
		ListNode prevNode = null;
		int currentPos = 1;
		
		ListNode preStart = null;
		ListNode start = null;
		
		while(node != null){
			
			if(currentPos > n)
				break;
			
			if(currentPos >= m && currentPos <=n){
				
				if(currentPos == m){
					
					if(prevNode != null)
						prevNode.next = null;
				
					preStart = prevNode;
					start = node;
					prevNode = null;
				}
				
				ListNode temp = node.next;
				node.next = prevNode;
				prevNode = node;
				node = temp;
				
				if(currentPos == n){
					if(preStart != null)
						preStart.next = prevNode;
					else
						head = prevNode;
					
					if(node != null)
						start.next = node;
					
				}
				
			} else{
				prevNode = node;
				node = node.next;
			}
			
			currentPos++;
		}
		
		return head;
	}

}
