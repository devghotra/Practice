package com.pcln.sort;

public class QuickSortRevisitedFB {

	public static void main(String[] args) {
		QuickSortRevisitedFB o = new QuickSortRevisitedFB();
		int[] A = { 4, 5, 1, 2, 7, 8, 3, 6, 9 };
		o.quickSort(A, 0, A.length - 1);
		for (int a : A) {
			System.out.print(a + " ");
		}

	}

	private void quickSort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}

	private int partition(int[] A, int p, int r) {

		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				swap(A, i, j);
			}
		}
		i = i + 1;
		swap(A, i, r);
		return i;

	}

	private void swap(int[] A, int i, int j) {
		int a = A[i];
		A[i] = A[j];
		A[j] = a;
	}

}
