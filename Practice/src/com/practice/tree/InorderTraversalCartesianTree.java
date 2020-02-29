package com.practice.tree;

import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InorderTraversalCartesianTree {

    @Test
    public void test() {
        assertEquals(1, 1);
        Integer[] nums = {5, 10, 40, 33, 30, 35, 50};
        System.out.println(buildTree(Arrays.asList(nums)));
        System.out.println(buildTreeON(Arrays.asList(nums)));
    }

    public TreeNode buildTreeON(List<Integer> nums) {
        TreeNode root = new TreeNode(nums.get(0));

        TreeNode prev = root;
        for (int i = 1; i < nums.size(); i++) {
            TreeNode node = new TreeNode(nums.get(i));
            if (nums.get(i) > root.val) {
                node.left = root;
                root = node;
            } else if (nums.get(i) > prev.val) {
                adjustRight(root, node);
            } else {
                prev.right = node;
            }

            prev = node;
        }

        return root;
    }

    private void adjustRight(TreeNode parent, TreeNode node) {
        while (parent.right != null && parent.right.val > node.val) {
            parent = parent.right;
        }

        node.left = parent.right;
        parent.right = node;
    }

    /***
     * Another approach to find max element and make it root and then recursively build left and right subtrees
     * Worst case time complexity is O(n2) when tree is just like linked list
     * Best case time complexity is O(NLogN) when tree is balanced
     */

    public TreeNode buildTree(List<Integer> nums) {
        return buildTree(nums, 0, nums.size() - 1);
    }

    private TreeNode buildTree(List<Integer> nums, int start, int end) {

        TreeNode node = null;

        int maxElementIndex = getIndexOfMax(nums, start, end);
        if (maxElementIndex != -1) {
            node = new TreeNode(nums.get(maxElementIndex));
            node.left = buildTree(nums, start, maxElementIndex - 1);
            node.right = buildTree(nums, maxElementIndex + 1, end);
        }

        return node;
    }

    private int getIndexOfMax(List<Integer> nums, int start, int end) {

        int max = 0;
        int maxElementIndex = -1;
        for (int i = start; i <= end; i++) {
            if (maxElementIndex == -1 || nums.get(i) > max) {
                max = nums.get(i);
                maxElementIndex = i;
            }
        }

        return maxElementIndex;
    }

}
