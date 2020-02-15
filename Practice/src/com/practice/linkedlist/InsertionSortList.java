package com.practice.linkedlist;

import org.junit.Test;

public class InsertionSortList {

    @Test
    public void test() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4); n1.next = n2;
        ListNode n3 = new ListNode(3); n2.next = n3;
        ListNode n4 = new ListNode(2); n3.next = n4;
        ListNode n5 = new ListNode(1); n4.next = n5;

        System.out.println(insertionSortList(n1));
    }

    public static ListNode insertionSortList(ListNode head) {

        ListNode sortedListHead = head;
        ListNode current = head.next;
        head.next = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = null; // break link to the rest of list to avoid circular reference

            ListNode prev = null;
            ListNode sortedNode = sortedListHead;
            while (sortedNode != null) {
                if (current.val < sortedNode.val) {
                    if (prev == null) {
                        sortedListHead = current;
                        current.next = sortedNode;
                    } else {
                        prev.next = current;
                        current.next = sortedNode;
                    }
                    break;
                }
                prev = sortedNode;
                sortedNode = sortedNode.next;
            }

            // if sorted sub-list iteration doesn't break then this current is largest so far so append in the end
            if (sortedNode == null) {
                prev.next = current;
            }

            current = temp;
        }

        return sortedListHead;
    }
}
