package com.practice.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Subset2 {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(subsetsWithDup(Arrays.asList(1, 2, 2, 3)));
    }


    public ArrayList<ArrayList<Integer>> subsetsWithDup(List<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, List<Integer> nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.size(); i++) {
            if (i > start && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            list.add(nums.get(i));
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
