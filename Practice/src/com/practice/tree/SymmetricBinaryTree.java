package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private int isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return 1;
        }

        if (t1 == null || t2 == null || t1.val != t2.val) {
            return 0;
        }

        return isSymmetric(t1.left, t2.right) & isSymmetric(t1.right, t2.left);
    }

}
