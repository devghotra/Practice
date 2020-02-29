package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class InorderTraversal {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(inorderTraversal(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15})));
        System.out.println(inorderTraversalRec(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15})));
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode nn = root;

        while (!stack.isEmpty() || nn != null) {
            if (nn != null) {
                stack.push(nn);
                nn = nn.left;
                continue;
            }

            TreeNode pn = stack.pop();
            result.add(pn.val);
            nn = pn.right;
        }

        return result;
    }

    public ArrayList<Integer> inorderTraversalRec(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversalRec(root, result);
        return result;
    }

    private void inorderTraversalRec(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversalRec(root.left, result);
        result.add(root.val);
        inorderTraversalRec(root.right, result);
    }
}
