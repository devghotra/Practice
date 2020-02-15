package com.practice.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenerateParentheses {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(generateParenthesis(3));
    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    public void generateParenthesis(int n, int open, int close, String currentStr, ArrayList<String> result) {
        if (currentStr.length() == 2 * n) {
            result.add(currentStr);
            return;
        }

        if (open < n) {
            generateParenthesis(n, open + 1, close, currentStr + "(", result);
        }

        if (close < open) {
            generateParenthesis(n, open, close + 1, currentStr + ")", result);
        }
    }

    /***********************************************************************
     * Recursive approach without backtracking - not a very good solution  *
     ***********************************************************************/
    public ArrayList<String> generateParenthesisV2(int n) {
        ArrayList<String> parenthesisList = new ArrayList<>();

        String parenthesis = "()";
        if (n == 1) {
            parenthesisList.add(parenthesis);
            return parenthesisList;
        }

        List<String> partialList = generateParenthesis(n - 1);
        for (int i = 0; i < partialList.size(); i++) {
            String partialCombination = partialList.get(i);
            for (int j = 0; j < partialCombination.length(); j++) {
                if (partialCombination.charAt(j) == '(') {
                    String combination = partialCombination.substring(0, j + 1) + parenthesis + partialCombination.substring(j + 1);
                    if (!parenthesisList.contains(combination))
                        parenthesisList.add(combination);
                }
            }
        }

        String combination = "";
        for (int k = 0; k < n; k++) {
            combination = combination + parenthesis;
        }
        parenthesisList.add(combination);

        Collections.sort(parenthesisList);
        return parenthesisList;
    }

}
