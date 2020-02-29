package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class KthSmallestElement {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(kthsmallest(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15}), 6));
    }

    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nn = root;

        while (!stack.isEmpty() || nn != null) {
            if (nn != null) {
                stack.push(nn);
                nn = nn.left;
                continue;
            }

            TreeNode pn = stack.pop();
            if (--k == 0) {
                return pn.val;
            }

            nn = pn.right;
        }

        return -1;
    }

}
