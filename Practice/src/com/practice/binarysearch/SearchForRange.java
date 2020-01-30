package com.practice.binarysearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchForRange {

    public ArrayList<Integer> searchRange(final List<Integer> nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(nums.size());
        result.add(-1);

        searchRange(nums, target, 0, nums.size() - 1, result);

        if (result.get(1) == -1) {
            result.set(0, -1);
        }

        return result;

    }

    private void searchRange(final List<Integer> nums, int target, int start, int end, List<Integer> result) {

        if (start <= end) {
            int mid = (start + end) / 2;
            if (nums.get(mid) == target) {
                result.set(0, Math.min(result.get(0), mid));
                result.set(1, Math.max(result.get(1), mid));
            }

            searchRange(nums, target, start, mid - 1, result);
            searchRange(nums, target, mid + 1, end, result);
        }
    }

    @Test
    public void test() {
        ArrayList<Integer> r = searchRange(Arrays.asList(5, 7, 7, 8, 8, 8, 10), 8);
        assertEquals(3, r.get(0).intValue());
        assertEquals(5, r.get(1).intValue());

        ArrayList<Integer> r1 = searchRange(Arrays.asList(5), 5);
        assertEquals(0, r1.get(0).intValue());
        assertEquals(0, r1.get(1).intValue());

        ArrayList<Integer> r2 = searchRange(Arrays.asList(5, 7, 7, 8, 8, 8, 10), 15);
        assertEquals(-1, r2.get(0).intValue());
        assertEquals(-1, r2.get(1).intValue());

        ArrayList<Integer> r3 = searchRange(Arrays.asList(), 15);
        assertEquals(-1, r3.get(0).intValue());
        assertEquals(-1, r3.get(1).intValue());
    }

}
