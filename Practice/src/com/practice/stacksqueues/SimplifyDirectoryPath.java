package com.practice.stacksqueues;

import java.util.Stack;

public class SimplifyDirectoryPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/.."));
	}

	public static String simplifyPath(String path) {
		
		Stack<String> stack = new Stack<>();
		
		String[] pathTokens = path.split("/");
		for(String token : pathTokens){
			
			if(token.equals(".") || token.isEmpty())
				continue;
			
			if(token.equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			} else{
				stack.push(token);
			}
			
		}
		
		StringBuilder simplifiedPath = new StringBuilder();
		while(!stack.isEmpty()){
			String p = stack.pop();
			simplifiedPath.insert(0, "/"+p);
		}
		
		return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
	}

}
