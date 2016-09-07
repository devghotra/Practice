package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpriralOrderMatrix {
	// DO NOT MODIFY THE LIST
		public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
			 ArrayList<Integer> result = new ArrayList<Integer>();
			 
			 if(a == null || a.isEmpty() || a.get(0) == null || a.get(0).isEmpty())
			    return result;
			 
			 int m = a.size();
			 int n = a.get(0).size();
			 
			 float rows = m;
			 float cols = n;
			 
			 int i = 0;
			 while(i < rows/2 && i < cols/2){
			     
			     List<Integer> h1 = a.get(i);
			     for(int j = i; j < h1.size()-i; j++){
			         result.add(h1.get(j));
			     }
			     
			     for(int k = i+1; k < m-i; k++){
			         List<Integer> h2 = a.get(k);
			         result.add(h2.get(n-1-i));
			     }
			     
			     // 1+2*i rows are already processed 
			     if(m-1-2*i > 0){
			    	 List<Integer> h3 = a.get(m-1-i);
				     for(int l = h3.size()-1-i-1; l >= i; l--){
				         result.add(h3.get(l));
				     }
			     }
			     
			     
			     // 1+2*i columns are already processed 
			     if(n-1-2*i > 0){
			    	 for(int p = m-1-i-1; p > i; p--){
				         List<Integer> h4 = a.get(p);
				         result.add(h4.get(i));
				     }
			     }
			     
			     i++;
			 }
			 
			 
			 return result;
		}
}
