package com.practice.interviewbit.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinaryTrees {

	public static void main(String[] args) {
		UniqueBinaryTrees ubt = new UniqueBinaryTrees();
		List<TreeNode> result = ubt.generateTrees(5);
		Collections.sort(result);
		for(TreeNode node : result){
			System.out.println(node);
		}
		
		System.out.println(result.size());

	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> previousTreeList = null;
		List<TreeNode> currentTreeList = new ArrayList<>();

		if(n>0)
			currentTreeList.add(new TreeNode(1));

		for (int i = 2; i <= n; i++) {
			previousTreeList = currentTreeList;
			currentTreeList = new ArrayList<>();
			// iterate thru all trees created in last iteration (i-1)
			for (int j = 0; j < previousTreeList.size(); j++) {
				TreeNode previousTree = previousTreeList.get(j);

				// add new node at the top (root)
				TreeNode c1 = clone(previousTree);
				TreeNode t1 = new TreeNode(i);
				t1.left = c1;
				currentTreeList.add(t1);

				// add new node at rightmost bottom
				TreeNode c2 = clone(previousTree);
				TreeNode t2 = new TreeNode(i);
				TreeNode c22 = c2;
				while (c22.right != null) {
					c22 = c22.right;
				}
				c22.right = t2;
				currentTreeList.add(c2);

				// insert new node at each right edge
				int level = 0;
				TreeNode treeItr = previousTree;
				while (treeItr.right != null) {
					TreeNode t = new TreeNode(i);
					TreeNode c = clone(previousTree);
					TreeNode nodeAfterWhichNewNodeInserts = c;
					for (int k = 0; k < level; k++) {
						nodeAfterWhichNewNodeInserts = nodeAfterWhichNewNodeInserts.right;
					}

					t.left = nodeAfterWhichNewNodeInserts.right;
					nodeAfterWhichNewNodeInserts.right = t;
					level++;

					currentTreeList.add(c);
					treeItr = treeItr.right;
				}
			}
		}

		return currentTreeList;
	}

	public TreeNode clone(TreeNode from) {
		TreeNode to = new TreeNode(from.val);

		if (from.left != null)
			to.left = clone(from.left);

		if (from.right != null)
			to.right = clone(from.right);

		return to;
	}

}

class TreeNode implements Comparable<TreeNode>{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", {left=" + left + "}, right={" + right + "}]";
	}

	@Override
	public int compareTo(TreeNode o) {
		// TODO Auto-generated method stub
		if(this.val > o.val)
			return 1;
		else if(this.val < o.val)
			return -1;
		else
			return 0;
	}
	
	
}
