package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class TwoSumBST {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(1, t2Sum(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 11, 15}), 18));
    }

    /**
     * 2 Pointer approach
     * Space complexity: O(height of tree)
     */
    public int t2Sum(TreeNode root, int k) {
        Stack<TreeNode> minStack = new Stack();
        Stack<TreeNode> maxStack = new Stack();

        TreeNode n = root;
        while (n != null) {
            minStack.push(n);
            n = n.left;
        }

        n = root;
        while (n != null) {
            maxStack.push(n);
            n = n.right;
        }

        while (minStack.peek().val < maxStack.peek().val) {
            int sum = minStack.peek().val + maxStack.peek().val;
            if (sum == k) {
                return 1;
            }

            if (sum > k) {
                TreeNode maxNode = maxStack.pop();
                // left edge of max nodes is unvisited, so add a left SegmentNode & its right edge
                if (maxNode.left != null) {
                    TreeNode node = maxNode.left;
                    while (node != null) {
                        maxStack.push(node);
                        node = node.right;
                    }
                }
            } else {
                TreeNode minNode = minStack.pop();
                // right edge of min nodes is unvisited, so add a right SegmentNode & its left edge
                if (minNode.right != null) {
                    TreeNode node = minNode.right;
                    while (node != null) {
                        minStack.push(node);
                        node = node.left;
                    }
                }
            }
        }

        return 0;
    }

    /**
     * Performs inorder traversal and uses a set to keep track of visited nodes
     * Space complexity: O(n)
     */
    public int t2Sum_ONSpaceComplexity(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return inorderAndCheck(root, set, k) ? 1 : 0;
    }

    private boolean inorderAndCheck(TreeNode root, Set<Integer> set, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (!stack.empty() || p != null) {

            // if it is not null, push to stack and go down the tree to left
            if (p != null) {
                stack.push(p);
                p = p.left;
                continue;
            }

            // if no left child pop stack, process the SegmentNode then let p point to the right
            TreeNode t = stack.pop();
            if (set.contains(k - t.val)) {
                return true;
            }
            set.add(t.val);
            p = t.right;
        }
        return false;
    }

}
