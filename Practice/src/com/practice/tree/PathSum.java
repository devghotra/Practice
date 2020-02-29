package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class PathSum {

    public int hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return 1;
        }

        int leftResult = hasPathSum(root.left, sum - root.val);
        int rightResult = hasPathSum(root.right, sum - root.val);

        return leftResult | rightResult;
    }

}
