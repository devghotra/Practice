package com.practice.linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		DoublyLinkedListImpl<Integer> list = new DoublyLinkedListImpl<>();
		list.insertFirst(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		
		list.printList();
		//list.deleteFirst();
		list.reverseListWithRecursion();
		//list.deleteLast();
		list.printList();
		
		System.out.println(list.getSize());

	}

}
