package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class SumRootToLeafs {

    int MOD = 1003;

    public int sumNumbers(TreeNode A) {
        return sum(A, 0);
    }

    public int sum(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        num = num * 10 + node.val;
        num %= MOD;

        if (node.left == null && node.right == null) {
            return num;
        }

        int leftSum = sum(node.left, num);
        int rightSum = sum(node.right, num);

        return (leftSum + rightSum) % MOD;

    }
}
