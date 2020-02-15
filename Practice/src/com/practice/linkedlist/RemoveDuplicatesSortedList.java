package com.practice.linkedlist;

public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }


}
