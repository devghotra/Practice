package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderofPeopleHeights {

	HeightTreeNode treeRoot = null;

	Comparator<Person> heightComparator = (p1, p2) -> p2.height.compareTo(p1.height);

	public static void main(String[] args) {
		OrderofPeopleHeights inst = new OrderofPeopleHeights();
		Integer[] heights = { 6, 5, 4, 3, 2, 1 };
		Integer[] inFronts = { 0, 0, 2, 1, 2, 3 };

		System.out.println(inst.order(Arrays.asList(heights), Arrays.asList(inFronts)));

	}

	public ArrayList<Integer> order(List<Integer> heights, List<Integer> infronts) {
		ArrayList<Person> persons = new ArrayList<>();
		for (int i = 0; i < heights.size(); i++) {
			persons.add(new Person(heights.get(i), infronts.get(i)));
		}

		Collections.sort(persons, heightComparator);

		for (Person p : persons) {
			insert(new HeightTreeNode(p, 1));
		}

		ArrayList<Integer> order = new ArrayList<>();
		inOrder(treeRoot, order);
		return order;
	}

	private void inOrder(HeightTreeNode node, List<Integer> order){
		if(node == null){
			return;
		}
		
		inOrder(node.left, order);
		order.add(node.p.height);
		inOrder(node.right, order);
		
	}
	
	private void insert(HeightTreeNode node) {
		if (treeRoot == null) {
			treeRoot = node;
			return;
		}

		HeightTreeNode checkNode = treeRoot;
		int inFront = node.p.inFront;
		while (checkNode != null) {
			if (inFront < checkNode.pos) {
				if (checkNode.left == null) {
					checkNode.left = node;
					checkNode.updatePosition();
					return;
				} else {
					checkNode.updatePosition();
					checkNode = checkNode.left;
				}
			} else {
				if (checkNode.right == null) {
					checkNode.right = node;
					return;
				} else {
					inFront -= checkNode.pos;
					checkNode = checkNode.right;
				}
			}
		}
	}

}

class Person {
	Integer height;
	Integer inFront;

	public Person(int h, int f) {
		height = h;
		inFront = f;
	}

	@Override
	public String toString() {
		return "Person [height=" + height + ", inFront=" + inFront + "]";
	}

}

class HeightTreeNode {

	Person p;
	int pos;
	HeightTreeNode left;
	HeightTreeNode right;

	public HeightTreeNode(Person p, int pos) {
		this.p = p;
		this.pos = pos;
	}

	public void updatePosition() {
		pos++;
	}

	@Override
	public String toString() {
		return "HeightTreeNode [p=" + p + ", pos=" + pos + ", left=" + left + ", right=" + right + "]";
	}

}