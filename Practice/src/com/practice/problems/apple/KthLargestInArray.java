package com.practice.problems.apple;

// Apple
public class KthLargestInArray {

	public static void main(String[] args) {
		int[] A = {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(A, 9));
	}

	public static int findKthLargest(int[] A, int k) {
		quickSort(A, 0, A.length-1, k);
		return A[A.length-k];
	}
	
	public static void quickSort(int[] A, int p, int r, int k) {
		if (p < r) {
			int q = partition(A, p, r);
			
			if(q == A.length-k)
				return;
			
			quickSort(A, p, q - 1, k);
			quickSort(A, q + 1, r, k);
		}		
	}

	public static int partition(int[] A, int p, int r) {
		int i = p - 1;

		// take last element i.e A[r] as pivot
		for (int j = p; j < r; j++) {
			if (A[j] <= A[r]) {
				i++;
				swap(A, i, j);
			}
		}

		i++;
		swap(A, i, r);
		return i;
	}

	public static void swap(int[] A, int i, int j) {
		if(i == j)
			return;
		
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
