package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class MinDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        // n2.left = n4;
        // n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        MinDepthBinaryTree inst = new MinDepthBinaryTree();
        System.out.println(inst.minDepth(n1));

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        // if both children's returned min depth then pick the min of them and add 1 for current level
        if (leftMinDepth != 0 && rightMinDepth != 0) {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
            // else min depth would be the max of both children's + 1, both children can return 0 or one of them may return some min depth
        } else {
            return Math.max(leftMinDepth, rightMinDepth) + 1;
        }
    }

}
