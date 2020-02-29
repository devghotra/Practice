package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public static void main(String[] args) {
        BSTIterator iter = new BSTIterator(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15}));
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public BSTIterator(TreeNode root) {
        push(root);
    }

    private void push(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            push(node.right);
        }

        return node.val;
    }
}
