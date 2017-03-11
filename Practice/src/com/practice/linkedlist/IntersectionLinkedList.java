package com.practice.linkedlist;

public class IntersectionLinkedList {

	public static void main(String[] args) {
		
		
		DoublyLinkedListImpl<Integer> a = new DoublyLinkedListImpl<>();
		a.insertFirst(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(4);
		a.insertLast(5);
		
		a.printList();
		
		DoublyLinkedListImpl<Integer> b = new DoublyLinkedListImpl<>();
		b.insertFirst(10);
		b.insertLast(20);
		b.insertLast(30);
		b.insertLast(4);
		b.insertLast(5);
		
		b.printList();
		
		Node<Integer> n = getIntersectionNode(a, b);
		if(n != null){
			System.out.println(n.val);
		} else{
			System.out.println("NULL");
		}
	}
	
	public static Node<Integer> getIntersectionNode(DoublyLinkedListImpl<Integer> a, DoublyLinkedListImpl<Integer>  b) {
		Node<Integer> aNode = a.getFirstNode();
		Node<Integer> bNode = b.getFirstNode();
		
		if(a.getSize() > b.getSize()){
			for(int i=0; i<(a.getSize()-b.getSize()); i++){
				aNode = a.getNextNode(aNode);
			}
		} else if(b.getSize() > a.getSize()){
			for(int i=0; i<(b.getSize()-a.getSize()); i++){
				bNode = b.getNextNode(bNode);
			}
		}

		
		while(aNode != null && bNode != null){
			if(aNode.val.equals(bNode.val)){
				return aNode;
			}
				
			aNode = aNode.next;
			bNode = bNode.next;
			
		}
		
		return null;
	}

}
