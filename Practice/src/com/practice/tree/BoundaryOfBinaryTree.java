package com.practice.tree;

import com.practice.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

    public List<Integer> printBoundary(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(root.val);

        printLeftEdge(root.left, nodes);
        printLeaves(root, nodes);
        printRightEdge(root.right, nodes);

        return nodes;
    }

    private void printLeftEdge(TreeNode n, List<Integer> nodes) {
        while (!isLeaf(n)) {
            nodes.add(n.val);
            n = n.left != null ? n.left : n.right;
        }
    }

    private void printRightEdge(TreeNode n, List<Integer> nodes) {
        List<Integer> rightEdge = new ArrayList<>();
        while (!isLeaf(n)) {
            rightEdge.add(0, n.val);
            n = n.right != null ? n.right : n.left;
        }
        nodes.addAll(rightEdge);
    }

    private void printLeaves(TreeNode n, List<Integer> nodes) {
        if (n == null) {
            return;
        }

        if (isLeaf(n)) {
            nodes.add(n.val);
        } else {
            printLeaves(n.left, nodes);
            printLeaves(n.right, nodes);
        }
    }

    private boolean isLeaf(TreeNode n) {
        return n.left == null && n.right == null;
    }

}
