package com.practice.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
public class Subset {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(subsetsRec(Arrays.asList(1, 2, 2, 3)));
    }

    // Backtracking Approach
    public ArrayList<ArrayList<Integer>> subsets(List<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, List<Integer> nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.size(); i++) {
            list.add(nums.get(i));
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /***********************************************************************
    // Recursive Approach but doesn't extend to subsets2 problem
    /***********************************************************************/
    public ArrayList<ArrayList<Integer>> subsetsRec(List<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = subsetsRec(nums, 0);
        result.add(0, new ArrayList<>()); // first element []
        return result;
    }

    private ArrayList<ArrayList<Integer>> subsetsRec(List<Integer> nums, int i) {
        if (i == nums.size()) {
            return new ArrayList<>();
        }

        int n = nums.get(i);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<ArrayList<Integer>> tempSet = subsetsRec(nums, i + 1);
        result.addAll(tempSet);

        for (int j = tempSet.size() - 1; j >= 0; j--) {
            ArrayList<Integer> setWithN = new ArrayList<>(tempSet.get(j));
            setWithN.add(0, n);
            result.add(0, setWithN);
        }

        ArrayList<Integer> l = new ArrayList<>();
        l.add(n);
        result.add(0, l);

        return result;
    }

}
