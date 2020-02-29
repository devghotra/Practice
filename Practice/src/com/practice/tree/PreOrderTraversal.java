package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class PreOrderTraversal {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(preorderTraversal(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15})));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pn = stack.pop();
            result.add(pn.val);

            if (pn.right != null) {
                stack.push(pn.right);
            }

            if (pn.left != null) {
                stack.push(pn.left);
            }
        }

        return result;
    }
}
