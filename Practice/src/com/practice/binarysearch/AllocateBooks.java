package com.practice.binarysearch;

import java.util.Arrays;
import java.util.List;

public class AllocateBooks {

	public static void main(String[] args) {
		Integer[] arr = {73, 58, 30, 72, 44, 78, 23, 9};
		AllocateBooks ab = new AllocateBooks();
		System.out.println(ab.books(Arrays.asList(arr), 5));
	}
	
	public int books(List<Integer> books, int numStudents) {
		if(numStudents > books.size())
			return -1;
		
		int lowestPagesPerStudent = getMax(books);
		int highestPagesPerStudent = getSum(books);

		while (lowestPagesPerStudent < highestPagesPerStudent) {
			int mid = lowestPagesPerStudent + (highestPagesPerStudent-lowestPagesPerStudent) / 2;
			
			int studentsRequired = getStudentsRequired(books, mid);
			if(studentsRequired <= numStudents){
				highestPagesPerStudent = mid;
			} else{
				lowestPagesPerStudent = mid+1;
			}
		}
		
		return lowestPagesPerStudent;
	}
	
	public int getStudentsRequired(List<Integer> books, int pagesPerStudent) {
		int studentsRequired = 1;
		int sum = 0;
		for (Integer book : books) {
			sum += book;
			if (sum > pagesPerStudent) {
				studentsRequired++;
				sum = book;
			}
		}

		return studentsRequired;
	}
	
	public int getMax(List<Integer> books) {
		int max = Integer.MIN_VALUE;
		for (Integer book : books) {
			if (book > max) {
				max = book;
			}
		}

		return max;
	}

	public int getSum(List<Integer> books) {
		int sum = 0;
		for (Integer book : books) {
			sum += book;
		}

		return sum;
	}
}
