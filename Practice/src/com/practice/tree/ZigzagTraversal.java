package com.practice.tree;

import com.practice.tree.util.TreeBuilder;
import com.practice.tree.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ZigzagTraversal {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(zigzagLevelOrderRec(TreeBuilder.toTree(new int[]{9, 5, 12, 2, 7, 10, 15, 1, 3, 7, 8, 11, 13, 14, 16})));
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrderRec(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        zigzagLevelOrder(root, map, 0);
        return (ArrayList<ArrayList<Integer>>) map.values().stream().collect(Collectors.toList());
    }

    public void zigzagLevelOrder(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map, int level) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> list = map.containsKey(level) ? map.get(level) : new ArrayList<>();
        if (level % 2 == 0) {
            list.add(root.val);
        } else {
            list.add(0, root.val);
        }

        map.put(level, list);

        zigzagLevelOrder(root.left, map, level + 1);
        zigzagLevelOrder(root.right, map, level + 1);
    }

    /**
     * Non-Recursive approach using queues
     * Just do level traversal (left -> right), while adding to result check the level
     * For odd levels - Add as is
     * For even levels - Reverse the order by inserting at beginning
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int level = 1;

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> resRow = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null)
                nextNodes.add(node.left);

            if (node.right != null)
                nextNodes.add(node.right);

            if (level % 2 == 1)
                resRow.add(node.val);
            else
                resRow.add(0, node.val);

            if (queue.isEmpty()) {
                result.add(resRow);
                queue.addAll(nextNodes);
                resRow = new ArrayList<>();
                nextNodes.clear();
                level++;
            }
        }

        return result;
    }
}
