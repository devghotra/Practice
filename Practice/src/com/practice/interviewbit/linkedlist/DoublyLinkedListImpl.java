package com.practice.interviewbit.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListImpl<T> {
	
	private Node<T> head;
	private Node<T> end;
	private int size;
	
	public void insertFirst(T t){
		Node<T> node = new Node<>(t);
		
		if(head == null){
			head = node;
			end = head;
		} else{
			head.previous = node;
			node.next = head;
			head = node;
		}
		
		size++;
	}
	
	public void insertLast(T t){
		Node<T> node = new Node<>(t);
		
		if(end == null){
			end = node;
			head = end;
		}else{
			node.previous = end;
			end.next = node;
			end = node;
		}
		
		size++;
	}
	
	public T getFirst(){
		return head != null ? head.val : null;
	}
	
	public T getLast(){
		return end != null ? end.val : null;
	}
	
	public Node<T> getFirstNode(){
		return head != null ? head : null;
	}
	
	public Node<T> getNextNode(Node<T> node){
		return node.next;
	}
	
	public void deleteFirst(){
		if(head != null){
			head = head.next;
			head.previous = null;
			size--;
		}
	}
	
	public void deleteLast(){
		if(end != null){
			end = end.previous;
			end.next = null;
			size--;
		}
	}
	
	public T delete(int index){
		if(index >= size){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node<T> n = head;
		for(int i=0; i<index; i++){
			n = n.next;
		}
		
		if(n.next == null){
			end = n.previous;
			end.next = null;
		} else{
			n.next.previous = n.previous;
		}
		
		if(n.previous == null){
			head = n.next;
			head.previous = null;
		} else{
			n.previous.next = n.next;
		}
		
		size--;
		
		return n.val;
	}
	
	public void clear(){
		head = end = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void printList(){
		List<String> list = new ArrayList<>();
		if(head != null){
			Node<T> n = head;
			while(n!= null && n.next != null){
				String prev = n.previous != null ? n.previous.val+"" : "null";
				list.add("["+prev+ "->"+n.val+"->"+n.next.val+"]");
				n = n.next;
			}
			
			if(n.next == null){
				list.add("["+n.previous.val + "->"+n.val+"->"+"null]");
			}
		}
		
		System.out.println(list);
	}
	
	public void reverseListWithRecursion(){
		if(head != null){
			Node<T> temp = head;
			reverseNodesRecursively(head, head.next);
			end = temp;
		}
	}
	
	private void reverseNodesRecursively(Node<T> firstNode, Node<T> secondNode){
		if(secondNode.next != null){
			reverseNodesRecursively(secondNode, secondNode.next);
		} else{
			head = secondNode;
			secondNode.previous = null;
		}
		
		secondNode.next = firstNode;
		firstNode.previous = secondNode;
		firstNode.next = null;
		
	}

}
