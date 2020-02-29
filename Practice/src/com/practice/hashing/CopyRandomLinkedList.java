package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode copyHead = null;

        RandomListNode current = head;
        while (current != null) {

            RandomListNode copyNode = map.get(current);
            if (copyNode == null) {
                copyNode = new RandomListNode(current.label);
                map.put(current, copyNode);
            }

            if (current.next != null) {
                if (!map.containsKey(current.next)) {
                    RandomListNode copyNext = new RandomListNode(current.next.label);
                    map.put(current.next, copyNext);
                }
                copyNode.next = map.get(current.next);
            }

            if (current.random != null) {
                if (!map.containsKey(current.random)) {
                    RandomListNode copyRandom = new RandomListNode(current.random.label);
                    map.put(current.random, copyRandom);
                }
                copyNode.random = map.get(current.random);
            }
            current = current.next;

            if (copyHead == null) {
                copyHead = copyNode;
            }
        }

        return copyHead;
    }

}
