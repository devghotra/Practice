package com.practice.arrays.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SpriralOrderMatrix {
		
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
			     
				 // top row
			     List<Integer> tr = a.get(i);
			     for(int j = i; j < tr.size()-i; j++){
			         result.add(tr.get(j));
			     }
			     
			     // right col
			     for(int k = i+1; k < m-i; k++){
			         List<Integer> rc = a.get(k);
			         result.add(rc.get(n-1-i));
			     }
			     
			     // bottom row
			     // 1+2*i rows are already processed 
			     if(m > 1+2*i){
			    	 List<Integer> br = a.get(m-1-i);
				     for(int l = br.size()-1-i-1; l >= i; l--){
				         result.add(br.get(l));
				     }
			     }
			     
			     
			     // left col
			     // 1+2*i columns are already processed 
			     if(n > 1+2*i){
			    	 for(int p = m-1-i-1; p > i; p--){
				         List<Integer> lc = a.get(p);
				         result.add(lc.get(i));
				     }
			     }
			     
			     i++;
			 }
			 
			 
			 return result;
		}
}
