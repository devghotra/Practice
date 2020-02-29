package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalancedBinaryTree {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(1, isBalanced(TreeBuilder.toTree(new int[]{1, 2, 3, 4})));
        assertEquals(1, isBalanced(TreeBuilder.toTree(new int[]{1, 2, 3, 4, 5, 6})));
    }

    public int isBalanced(TreeNode root) {
        return checkHeightBalance(root) == -1 ? 0 : 1;
    }

    private int checkHeightBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = checkHeightBalance(root.left);
        int rightH = checkHeightBalance(root.right);
        int diff = Math.abs(leftH - rightH);

        // return -1 if left or right trees are not balanced or height difference between both is > 1
        if (leftH == -1 || rightH == -1 || diff > 1) {
            return -1;
        } else {
            return Math.max(leftH, rightH) + 1;
        }
    }
}