package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class SumOfLeftLeaves_LC {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;

        System.out.println(sumOfLeftLeaves(one));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null && isLeft)
            return root.val;

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);

    }
}
