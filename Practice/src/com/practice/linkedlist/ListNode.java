package com.practice.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode reverseList(ListNode a) {
        ListNode node = a;
        ListNode prev = null;

        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return prev;
    }

    public String toString() {
        return val + " -> " + next;
    }

    public String toString2() {
        return "[val=" + val + ", next=" + next + "]";
    }

    public String toString1() {
        return "[val=" + val + "]";
    }


}
