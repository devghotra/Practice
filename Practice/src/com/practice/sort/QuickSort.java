package com.practice.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ShuffleArray.shuffle((arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r) {
        int i = p - 1;

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
        if (i == j)
            return;

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
