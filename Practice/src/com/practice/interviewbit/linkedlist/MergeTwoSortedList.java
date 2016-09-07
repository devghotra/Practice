package com.practice.interviewbit.linkedlist;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		
		
	}
	
	
	public static ListNode mergeTwoLists(ListNode a, ListNode b) {
		
		ListNode head = null;
		ListNode list1Node = null;
		ListNode list2Node = null;
		
		if(a.val <= b.val){
			head = a;
			list1Node = a;
			list2Node = b;
		} else{
			head = b;
			list1Node = b;
			list2Node = a;
		}
		
		ListNode prev = null;
		while(list1Node != null){
			if(list1Node.val <= list2Node.val){
				prev = list1Node;
				list1Node = list1Node.next;
			} else{
				prev.next = list2Node;
				prev = list2Node;
				ListNode temp = list1Node;
				list1Node = list2Node.next;
				list2Node = temp;
			}
		}
		
		prev.next = list2Node;
		
		
		return head;
	}
	
	

}
