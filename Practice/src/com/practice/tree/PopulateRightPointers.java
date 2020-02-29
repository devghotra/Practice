package com.practice.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PopulateRightPointers {

    @Test
    public void test() {
        assertEquals(1, 1);
        connect(TreeLinkNode.createTree(new int[]{9, 5, 12, 2, 7, 10, 15}));
    }

    public void connect(TreeLinkNode root) {
        connect(root, null);
    }

    public void connect(TreeLinkNode node, TreeLinkNode nextRightParent) {
        if (node == null)
            return;

        if (node.left != null) {
            node.left.next = node.right;
        }

        if (node.next == null) {
            TreeLinkNode nextNode = getNextNode(nextRightParent);
            node.next = nextNode;
        }

        connect(node.right, node.next);
        connect(node.left, node.next);

    }

    private TreeLinkNode getNextNode(TreeLinkNode node) {
        while (node != null) {
            if (node.left != null)
                return node.left;

            if (node.right != null)
                return node.right;

            node = node.next;
        }

        return null;
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }

        public static TreeLinkNode createTree(int[] A) {

            List<TreeLinkNode> nodes = new ArrayList<>();
            nodes.add(new TreeLinkNode(A[0]));

            for (int i = 1; i < A.length; i++) {
                if (A[i] == -1) {
                    continue;
                }

                TreeLinkNode node = new TreeLinkNode(A[i]);
                nodes.add(node);

                if (i % 2 == 0) {
                    TreeLinkNode parent = nodes.get(i / 2 - 1);
                    parent.right = node;
                } else {
                    TreeLinkNode parent = nodes.get(i / 2);
                    parent.left = node;
                }

            }

            return nodes.get(0);
        }
    }
}