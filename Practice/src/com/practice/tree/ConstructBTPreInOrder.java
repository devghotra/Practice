package com.practice.tree;

import com.google.common.collect.Lists;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.List;

public class ConstructBTPreInOrder {

    @Test
    public void test() {
        List<Integer> preorder = Lists.newArrayList(1, 2, 0, 3);
        List<Integer> inorder = Lists.newArrayList(2, 0, 1, 3);
        System.out.println(buildTree(preorder, inorder));

    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.isEmpty() || preorder.isEmpty()) {
            return null;
        }

        int rootVal = preorder.get(0);
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorder.indexOf(rootVal);

        root.left = buildTree(preorder.subList(1, rootIndex + 1), inorder.subList(0, rootIndex));
        root.right = buildTree(preorder.subList(rootIndex + 1, preorder.size()), inorder.subList(rootIndex + 1, inorder.size()));

        return root;
    }

}
