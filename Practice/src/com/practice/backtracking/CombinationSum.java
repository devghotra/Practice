package com.practice.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationSum {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(combinationSum(Arrays.asList(1, 6, 8, 8, 10, 11, 16), 28));
    }

    public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> candidates, int target) {
        Collections.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinationSum(candidates, result, new ArrayList<>(), 0, 0, target);
        return result;
    }

    public void combinationSum(List<Integer> candidates, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, int start, int currentSum, int target) {
        if (currentSum > target) {
            return;
        }

        if (currentSum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            if (i > start && candidates.get(i) == candidates.get(i - 1)) {
                continue;
            }

            if (currentSum + candidates.get(i) <= target) {
                tempList.add(candidates.get(i));
                combinationSum(candidates, result, tempList, i, currentSum + candidates.get(i), target);
                tempList.remove(tempList.size() - 1);
            } else {
                break;
            }
        }
    }

}
