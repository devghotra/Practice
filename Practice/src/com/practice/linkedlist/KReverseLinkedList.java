package com.practice.linkedlist;

import org.junit.Test;

public class KReverseLinkedList {

    @Test
    public void test() {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n5.next = n6;
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;

        System.out.println(reverseList(n1, 2));

    }

    public ListNode reverseList(ListNode head, int k) {

        ListNode newHead = null;

        ListNode prevStartNode = null;
        ListNode current = head;
        while (current != null) {
            int i = k;
            ListNode startNode = current;
            ListNode prev = null;
            while (i > 0) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                i--;
            }

            if (prevStartNode != null) {
                prevStartNode.next = prev;
            } else {
                newHead = prev;
            }

            prevStartNode = startNode;
        }

        return newHead;
    }
}
