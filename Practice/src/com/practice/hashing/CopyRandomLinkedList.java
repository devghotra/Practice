package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public RandomListNode copyRandomList(RandomListNode head) {

		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode originalNode = head;
		RandomListNode previousCopyNode = null;
		RandomListNode copyHead = null;
		
		while (originalNode != null) {
			RandomListNode copyNode = null;
			if(map.containsKey(originalNode)){
				copyNode = map.get(originalNode);
			} else{
				copyNode = new RandomListNode(originalNode.label);
				map.put(originalNode, copyNode);
			}

			if (previousCopyNode != null) {
				previousCopyNode.next = copyNode;
			} else{
				copyHead = copyNode;
			}
			
			if(originalNode.random != null){
				if(map.containsKey(originalNode.random)){
					copyNode.random = map.get(originalNode.random);
				} else{
					RandomListNode copyRandomNode = new RandomListNode(originalNode.random.label);
					map.put(originalNode.random, copyRandomNode);
					copyNode.random = copyRandomNode;
				}
			}

			previousCopyNode = copyNode;
			originalNode = originalNode.next;
		}

		return copyHead;
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
