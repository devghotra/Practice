package com.practice.interviewbit.arrays;

import java.util.ArrayList;

public class SpiralOrderN2 {

	public static void main(String[] args) {
		System.out.println(generateMatrix(4));
	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(a);
		for(int i=0; i<a;i++){
			result.add(i, null);
		}
		
		float rows = a;
		 float cols = a;
		 
		 int i = 0;
		 int num = 0;
		 while(i < rows/2 && i < cols/2){
		     
			 ArrayList<Integer> h1 = result.get(i);
			 if(h1 == null) {
				 h1 = new ArrayList<>();
				 initializeList(a, h1);
			 } 
			 for(int j = i; j < a-i; j++){
				 num++;
		    	 h1.set(j, num);
		     }
			 result.set(i, h1);
		     
		     for(int k = i+1; k < a-i; k++){
		    	 ArrayList<Integer> h2 = result.get(k);
		    	 if(h2 == null) {
		    		 h2 = new ArrayList<>();
		    		 initializeList(a, h2);
		    	 }
		    	 num++;
		    	 h2.set(a-i-1, num);
		         result.set(k, h2);
		     }
		     
		     // 1+2*i rows are already processed 
		     if(a-1-2*i > 0){
		    	 ArrayList<Integer> h3 = result.get(a-1-i);
		    	 if(h3 == null){
		    		 h3 = new ArrayList<>();
		    		 initializeList(a, h3);
		    	 }
			     for(int l = a-1-i-1; l >= i; l--){
			    	 num++;
			    	 h3.set(l, num);
			     }
			     result.set(a-1-i, h3);
		     }
		     
		     
		     // 1+2*i columns are already processed 
		     if(a-1-2*i > 0){
		    	 for(int p = a-1-i-1; p > i; p--){
		    		 ArrayList<Integer> h4 = result.get(p);
		    		 if(h4 == null) {
		    			 h4 = new ArrayList<>();
		    			 initializeList(a, h4);
		    		 }
		    		 num++;
			    	 h4.set(i, num);
		    		 result.set(p, h4);
			     }
		     }
		     
		     i++;
		 }
		
		
		
		return result;
	}
	
	private static void initializeList(int a, ArrayList<Integer> list){
		for(int i=0; i<a;i++){
			list.add(i, null);
		}
	}
}
