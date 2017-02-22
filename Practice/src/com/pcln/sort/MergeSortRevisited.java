package com.pcln.sort;

public class MergeSortRevisited {

	public static void main(String[] args) {

		int[] A = {12, 16, 333, 50, 1000, 5, 897, 1, 3, 66, 13 };
		int[] tempArray = new int[A.length];

		mergeSort(A, 0, A.length-1,tempArray);
		for(int i:A){
			System.out.print(i+" ");
		}
	}

	static void merge(int[] A,int l,int m,int r,int[] tempArray){
		
		int tempIndex=0;
		
		int leftStart = l;
		int leftEnd = m;
		int rightStart = m+1;
		int rightEnd = r;
		int totalItems = r-l+1;
		
		while(leftStart<=leftEnd && rightStart<=rightEnd){
			if(A[leftStart]<=A[rightStart]){
				tempArray[tempIndex++] = A[leftStart++];
			}else{
				tempArray[tempIndex++] = A[rightStart++];
			}
		
		}
		while(leftStart <= leftEnd){
			tempArray[tempIndex++] = A[leftStart++];
		}
		
		while(rightStart <= rightEnd){
			tempArray[tempIndex++] = A[rightStart++];
		}
		for(int i=0;i<totalItems;i++){
			A[l+i] = tempArray[i];
		}

	}

	static void mergeSort(int[] A,int l,int r,int[] tempArray){

		if(l<r){
			int m = (l+r)/2;
			mergeSort(A, l, m,tempArray);
			mergeSort(A, m+1, r,tempArray);
			merge(A,l,m,r,tempArray);
		}
	}
}
