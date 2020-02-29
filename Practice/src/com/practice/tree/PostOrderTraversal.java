package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class PostOrderTraversal {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(postorderTraversal(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15})));
        System.out.println(postorderTraversalRec(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15})));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nn = root;

        while (!stack.isEmpty() || nn != null) {
            if (nn != null) {
                stack.push(nn);
                nn = nn.left;
                continue;
            }

            TreeNode pn = stack.peek();
            if (pn.right != null && !set.contains(pn.right)) {
                nn = pn.right;
            } else {
                pn = stack.pop();
                set.add(pn);
                result.add(pn.val);
            }

        }

        return result;
    }

    public ArrayList<Integer> postorderTraversalRec(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversalRec(root, result);
        return result;
    }

    private void postorderTraversalRec(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversalRec(root.left, result);
        postorderTraversalRec(root.right, result);
        result.add(root.val);
    }
}
