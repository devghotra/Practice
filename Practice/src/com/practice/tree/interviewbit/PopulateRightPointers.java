package com.practice.tree.interviewbit;

public class PopulateRightPointers {

	public static void main(String[] args) {
		TreeLinkNode one = new TreeLinkNode(1);
		TreeLinkNode two = new TreeLinkNode(2);
		TreeLinkNode three = new TreeLinkNode(3);
		TreeLinkNode four = new TreeLinkNode(4);
		TreeLinkNode five = new TreeLinkNode(5);
		TreeLinkNode six = new TreeLinkNode(6);
		TreeLinkNode seven = new TreeLinkNode(7);
		TreeLinkNode eight = new TreeLinkNode(8);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.right = six;
		four.left = seven;
		six.right = eight;

		PopulateRightPointers inst = new PopulateRightPointers();
		inst.connect(one);
		System.out.println(one);

	}

	public void connect(TreeLinkNode root) {
		connect(root, null);
	}

	public void connect(TreeLinkNode node, TreeLinkNode nextRightParent) {
		if (node == null)
			return;
		
		if(node.left != null){
			node.left.next = node.right;
		}

		if (node.next == null) {
			TreeLinkNode nextNode = getNextNode(nextRightParent);
			node.next = nextNode;
		}

		connect(node.right, node.next);
		connect(node.left, node.next);
		
	}

	private TreeLinkNode getNextNode(TreeLinkNode node) {
		while (node != null) {
			if (node.left != null)
				return node.left;

			if (node.right != null)
				return node.right;

			node = node.next;
		}

		return null;
	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "[" + val + "]";
	}
}