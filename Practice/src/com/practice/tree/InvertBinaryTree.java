package com.practice.tree;

import com.practice.tree.util.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode invertedRight = invertTree(root.right);
            TreeNode invertedLeft = invertTree(root.left);

            root.left = invertedRight;
            root.right = invertedLeft;
        }

        return root;
    }
}
