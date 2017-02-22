package com.practice.backtracking.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3).size());
	}
	
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(ArrayList<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    
    public ArrayList<String> generateParenthesisV2(int n) {
		ArrayList<String> parenthesisList = new ArrayList<>();
				
		String parenthesis = "()";
		if(n==1){
			parenthesisList.add(parenthesis);
			return parenthesisList;
		}
		
		List<String> partialList = generateParenthesis(n-1);
		for(int i=0; i<partialList.size(); i++){
			String partialCombination = partialList.get(i);
			for(int j=0; j<partialCombination.length(); j++){
				if(partialCombination.charAt(j) == '('){
					String combination = partialCombination.substring(0, j+1) + parenthesis + partialCombination.substring(j+1);
					if(!parenthesisList.contains(combination))
						parenthesisList.add(combination);
				}
			}
		}
		
		String combination = "";
		for(int k=0; k<n; k++){
			combination=combination+parenthesis;
		}
		parenthesisList.add(combination);
		
		Collections.sort(parenthesisList);
		return parenthesisList;
	}

}