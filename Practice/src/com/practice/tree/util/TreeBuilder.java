package com.practice.tree.util;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    public static TreeNode toTree(int[] A) {

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(new TreeNode(A[0]));

        for (int i = 1; i < A.length; i++) {
            if (A[i] == -1) {
                continue;
            }

            TreeNode node = new TreeNode(A[i]);
            nodes.add(node);

            if (i % 2 == 0) {
                TreeNode parent = nodes.get(i / 2 - 1);
                parent.right = node;
            } else {
                TreeNode parent = nodes.get(i / 2);
                parent.left = node;
            }

        }

        return nodes.get(0);
    }

    public static void main(String[] args) {
        TreeNode head = toTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(head);
    }
}
