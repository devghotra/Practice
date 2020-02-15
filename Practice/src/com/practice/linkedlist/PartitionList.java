package com.practice.linkedlist;

public class PartitionList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n1;

        System.out.println(partition(n1, 0));

    }

    public static ListNode partition(ListNode head, int x) {

        ListNode l1Head = null;
        ListNode l2Head = null;

        ListNode l1LastNode = null;
        ListNode l2LastNode = null;

        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = null;

            if (current.val < x) {
                if (l1Head == null) {
                    l1Head = current;
                } else {
                    l1LastNode.next = current;
                }
                l1LastNode = current;
            } else {
                if (l2Head == null) {
                    l2Head = current;
                } else {
                    l2LastNode.next = current;
                }
                l2LastNode = current;
            }

            current = temp;
        }

        if (l1Head != null) {
            l1LastNode.next = l2Head;
            return l1Head;
        } else {
            return l2Head;
        }

    }

}
