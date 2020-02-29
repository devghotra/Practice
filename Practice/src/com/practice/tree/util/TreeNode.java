package com.practice.tree.util;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" +
                "\"v\":" + val +
                ", \"l\":" + left +
                ", \"r\":" + right +
                '}';
    }
}
