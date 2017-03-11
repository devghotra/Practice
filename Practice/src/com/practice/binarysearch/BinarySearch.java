package com.practice.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,2,5,7,8,10,12};
		System.out.println(search(arr, 20));
		System.out.println(searchRecursively(arr, 20, 0, arr.length-1));

	}
	
	public static int search(int[] arr, int num){
		int low = 0;
		int high = arr.length-1;
		
		while(low <= high){
			int mid = (low+high)/2;
			if(arr[mid] == num)
				return mid;
			
			if(arr[mid] > num){
				high = mid-1;
			} else{
				low = mid+1;
			}
		}
		
		return -1;
	}

	public static int searchRecursively(int[] arr, int num, int low, int high){
		if(high < low)
			return -1;
		
		int mid = (low+high)/2;
		if(arr[mid] == num)
			return mid;
		
		if(arr[mid] > num){
			return searchRecursively(arr, num, low, mid-1);
		} else{
			return searchRecursively(arr, num, mid+1, high);
		}
	}
}
