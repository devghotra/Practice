package com.practice.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Permutations {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(permute(Arrays.asList(1, 2, 3, 4)));
    }

    public ArrayList<ArrayList<Integer>> permute(List<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>(), 0, new HashSet<>());
        return result;
    }

    public void permute(List<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, int start, Set<Integer> indexesUsed) {
        if (tempList.size() == nums.size()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (indexesUsed.contains(i)) {
                continue;
            }
            tempList.add(nums.get(i));
            indexesUsed.add(i);
            permute(nums, result, tempList, start + 1, indexesUsed);
            tempList.remove(tempList.size() - 1);
            indexesUsed.remove(i);
        }
    }

}
