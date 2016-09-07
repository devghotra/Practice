package com.practice.questions;

import java.util.Arrays;

public class ArrangePersonHeightOrder_InterviewBit {
	public static void arrange(int[] heights, int[] frontCounts) {
		Person[] persons = new Person[heights.length];

		for (int i = 0; i < persons.length; i++)
			persons[i] = new Person(heights[i], frontCounts[i]);

		Arrays.sort(persons, (p1, p2) -> {
			return Integer.compare(p2.height, p1.height);
		});

		Node root = new Node(persons[0]);

		for (int i = 1; i < persons.length; i++) {
			insert(root, persons[i]);
		}

		inOrderPrint(root);
	}

	private static void insert(Node root, Person p) {
		insert(root, p, p.frontCount);
	}

	private static void insert(Node root, Person p, int frontCount) {
		if (frontCount < root.value) { // should insert to the left
			if (root.left == null) {
				root.left = new Node(p);
			} else {
				insert(root.left, p, frontCount);
			}
			root.value++; // Increase the current node value while descending
							// left!
		} else { // insert to the right
			if (root.right == null) {
				root.right = new Node(p);
			} else {
				insert(root.right, p, frontCount - root.value);
			}
		}
	}

	private static void inOrderPrint(Node root) {
		if (root == null)
			return;

		inOrderPrint(root.left);

		System.out.print(root.person.height);

		inOrderPrint(root.right);
	}

	private static class Node {
		Node left, right;
		int value;
		public final Person person;

		public Node(Person person) {
			this.value = 1;
			this.person = person;
		}

		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", value=" + value + ", person=" + person + "]";
		}
		
		
	}

	private static class Person {
		public final int height;
		public final int frontCount;

		Person(int height, int frontCount) {
			this.height = height;
			this.frontCount = frontCount;
		}

		@Override
		public String toString() {
			return "Person [height=" + height + ", frontCount=" + frontCount + "]";
		}
		
		
	}

	public static void main(String[] args) {
		int[] heights = { 5, 3, 2, 6, 1, 4 };
		int[] frontCounts = { 0, 1, 2, 0, 3, 1 };

		arrange(heights, frontCounts);
		System.out.println();
	}

}