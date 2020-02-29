package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class RecoverBST {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(recoverTree(TreeBuilder.toTree(new int[]{9, 10, 12, 2, 7, 5, 15})));
    }

    public ArrayList<Integer> recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
                continue;
            }

            curr = stack.pop();

            // record the reversed pair.
            if (prev != null && prev.val > curr.val) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }

            prev = curr;
            curr = curr.right;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(Math.min(first.val, second.val));
        result.add(Math.max(first.val, second.val));

        return result;

    }
}