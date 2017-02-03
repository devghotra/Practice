package com.practice.interviewbit.stacksqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMax {

	public static void main(String[] args) {
		//Integer[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] arr = {9,10,9,-7,-4,-8,2,-6};
		int[] res = maxSlidingWindow(arr, 5);
		
		for(int n : res){
			System.out.print(n + " ");
		}
	}

	
	public static int[] maxSlidingWindow(int[] arr, int w) {
		List<Integer> list = new ArrayList<>();
		
		for(int n : arr){
			list.add(n);
		}
		
		ArrayList<Integer> result =  slidingMaximum(list, w);
		
		int[] resArr = new int[result.size()];
		for (int i = 0; i < resArr.length; i++) {
			resArr[i] = result.get(i);
		}
		
		return resArr;
	}
	
	// Using DeQueue - time complexity is O(N)
	public static ArrayList<Integer> slidingMaximum(final List<Integer> arr, int w) {

		ArrayList<Integer> result = new ArrayList<>();
		LinkedList<Integer> deQueue = new LinkedList<>();
		
		for(int i = 0; i < arr.size(); i++){
			
			int num = arr.get(i);
			
			// if queue contain out of window range index - remove it
			while(!deQueue.isEmpty() && deQueue.peek() < i - w + 1){
				deQueue.poll();
			}
			
			// remove all nums smaller than current num
			while(!deQueue.isEmpty() && arr.get(deQueue.peekLast()) < num){
				deQueue.pollLast();
			}
			
			// q contains index
			deQueue.add(i);
			
			if(i >= w - 1){
				result.add(arr.get(deQueue.peek()));
			}
			
		}

		return result;
	}
	
	// Using Max Heap(priority Q) time complexity is O(NlogN) - less optimal
	public static ArrayList<Integer> slidingMaximum2(final List<Integer> arr, int w) {

		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((Integer n1, Integer n2) -> n1.compareTo(n2) * -1);
		
		for(int i = 0; i < arr.size(); i++){
			if(i < w-1){
				pQueue.add(arr.get(i));
				continue;
			}
			
			if(i >= w)
				pQueue.remove(arr.get(i-w));
			
			pQueue.add(arr.get(i));
			result.add(pQueue.peek());
		}

		return result;
	}

}
