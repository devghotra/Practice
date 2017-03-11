package com.practice.arrays;

import java.util.ArrayList;

public class RotateMatrix {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(5);
		a2.add(6);
		a2.add(7);
		a2.add(8);
		
		ArrayList<Integer> a3 = new ArrayList<>();
		a3.add(9);
		a3.add(10);
		a3.add(11);
		a3.add(12);
		
		ArrayList<Integer> a4 = new ArrayList<>();
		a4.add(13);
		a4.add(14);
		a4.add(15);
		a4.add(16);
		
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
				
		rotate(a);
		System.out.println(a);
	}
	
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		
		int n = a.size();
		
		for(int i=0; i<n/2; i++){
			for(int j=i; j<n-1-i; j++){
				int n1 = a.get(i).get(j);
				int n2 = a.get(j).get(n-1-i);
				int n3 = a.get(n-1-i).get(n-1-j);
				int n4 = a.get(n-1-j).get(i);
				
				a.get(i).set(j, n4);
				a.get(j).set(n-1-i, n1);
				a.get(n-1-i).set(n-1-j, n2);
				a.get(n-1-j).set(i, n3);
				
			}
		}
	
	}
	
	/*
	 * 1. Loop around recursively in layered manner - in every iteration 2 elements in row will be processed, total iterations needed - n/2
	 * 2. run inner loop to starting from first row and column not processed yet
	 * 3. In each inner loop iteration find 4 elements for each direction and rotate them
	 */
	
	public void rotate(int[][] a) {
		int n = a.length;
		
		for(int i=0; i<n/2; i++){
			for(int j=i; j<n-1-i; j++){
				int n1 = a[i][j];
				int n2 = a[i][n-1-i];
				int n3 = a[n-1-i][n-1-j];
				int n4 = a[n-1-j][i];
				
				a[i][j] = n4;
				a[j][n-1-i] = n1;
				a[n-1-i][n-1-j] = n2;
				a[n-1-j][i] = n3;
				
			}
		}
    }
	

}
