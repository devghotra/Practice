package com.practice.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Facebook
public class RemoveInvalidParentheses_LC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> removeInvalidParentheses(String s) {
		int extraOpenBrkt = 0, extraCloseBrkt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				extraOpenBrkt++;
			} else if (s.charAt(i) == ')') {
				if (extraOpenBrkt != 0) {
					extraOpenBrkt--;
				} else {
					extraCloseBrkt++;
				}
			}
		}
		
		Set<String> res = new HashSet<>();
		dfs(s, 0, res, new StringBuilder(), extraOpenBrkt, extraCloseBrkt, 0);
		return new ArrayList<String>(res);
	}

	public void dfs(String s, int i, Set<String> res, StringBuilder sb, int extraOpenBrkt, int extraCloseBrkt, int open) {
		// if less than zero it shouldn't be removed
		if (extraOpenBrkt < 0 || extraCloseBrkt < 0 || open < 0) {
			return;
		}
		if (i == s.length()) {
			if (extraOpenBrkt == 0 && extraCloseBrkt == 0 && open == 0) {
				res.add(sb.toString());
			}
			return;
		}

		char c = s.charAt(i);
		int len = sb.length();

		if (c == '(') {
			dfs(s, i + 1, res, sb, extraOpenBrkt - 1, extraCloseBrkt, open); // not use (
			dfs(s, i + 1, res, sb.append(c), extraOpenBrkt, extraCloseBrkt, open + 1); // use (

		} else if (c == ')') {
			dfs(s, i + 1, res, sb, extraOpenBrkt, extraCloseBrkt - 1, open); // not use )
			dfs(s, i + 1, res, sb.append(c), extraOpenBrkt, extraCloseBrkt, open - 1); // use )

		} else {
			dfs(s, i + 1, res, sb.append(c), extraOpenBrkt, extraCloseBrkt, open);
		}

		sb.setLength(len);
	}

}
