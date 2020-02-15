package com.practice.linkedlist;

import org.junit.Test;

public class ReverseLinkList2 {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2); n1.next = n2;
        ListNode n3 = new ListNode(3); n2.next = n3;
        ListNode n4 = new ListNode(4); n3.next = n4;
        ListNode n5 = new ListNode(5); n4.next = n5;

        System.out.println(n1);
        ListNode head = reverseBetween(n1, 2, 4);
        System.out.println(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode prev = null;
        ListNode current = head;
        ListNode mthNode = null;

        while (current != null) {
            m--;
            n--;

            if (m == 0) {
                mthNode = current;
            }

            if (m <= 0) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            } else {
                prev = current;
                current = current.next;
            }

            if (n == 0) {
                if (mthNode.next != null) {
                    mthNode.next.next = prev;
                } else {
                    head = prev;
                }

                mthNode.next = current;
                break;
            }
        }

        return head;
    }

}
