package com.practice.heapsmaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> Integer.valueOf(n1.val).compareTo(n2.val));

        lists.forEach(minHeap::add);

        ListNode head = null;
        ListNode prev = null;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            if (head == null) {
                head = node;
            } else {
                prev.next = node;
            }

            prev = node;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return head;
    }

}
