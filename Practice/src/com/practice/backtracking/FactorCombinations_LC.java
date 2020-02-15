package com.practice.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FactorCombinations_LC {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(getFactors(16));
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> combination, int n, int start) {
        if (n <= 1) {
            // to avoid combination that just contains the number itself
            if (combination.size() > 1) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                combination.add(i);                            // add the number i
                helper(result, combination, n / i, i);
                combination.remove(combination.size() - 1);    // remove number i
            }
        }
    }

}
