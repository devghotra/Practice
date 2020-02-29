package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlattenBinaryTreeToLinkedList {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(flatten(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15})));
    }

    public TreeNode flatten(TreeNode root) {
        helper(root);
        return root;
    }

    private TreeNode helper(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        TreeNode leftLast = helper(node.left);
        TreeNode rightLast = helper(node.right);

        if (leftLast != null) {
            leftLast.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightLast != null ? rightLast : leftLast;

    }


}
