package com.practice.sort;

public class MergeSortRevisited {

	public static void main(String[] args) {

		int[] A = { 12, 16, 333, 50, 1000, 5, 897, 1, 3, 66, 13 };
		int[] tempArray = new int[A.length];

		mergeSort(A, 0, A.length - 1, tempArray);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

	static void mergeSort(int[] A, int p, int r, int[] tempArray) {

		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q, tempArray);
			mergeSort(A, q + 1, r, tempArray);
			merge(A, p, q, r, tempArray);
		}
	}
	
	static void merge(int[] A, int p, int q, int r, int[] tempArray) {

		int tempIndex = 0;

		int A1Start = p;
		int A1End = q;
		int A2Start = q + 1;
		int A2End = r;
		int totalItems = r - p + 1;

		while (A1Start <= A1End && A2Start <= A2End) {
			if (A[A1Start] <= A[A2Start]) {
				tempArray[tempIndex++] = A[A1Start++];
			} else {
				tempArray[tempIndex++] = A[A2Start++];
			}

		}
		
		while (A1Start <= A1End) {
			tempArray[tempIndex++] = A[A1Start++];
		}

		while (A2Start <= A2End) {
			tempArray[tempIndex++] = A[A2Start++];
		}
		
		for (int i = 0; i < totalItems; i++) {
			A[p + i] = tempArray[i];
		}

	}
}
