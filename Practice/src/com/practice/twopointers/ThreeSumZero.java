package com.practice.twopointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumZero {

    @Test
    public void test() {
        System.out.println(threeSumClosest(Arrays.asList(-31013930, -31013930, 9784175, 21229755)));
    }

    public ArrayList<ArrayList<Integer>> threeSumClosest(List<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {

            if (i != 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }

            int j = i + 1;
            int k = nums.size() - 1;

            while (j < k) {
                if (j != i + 1 && nums.get(j).equals(nums.get(j - 1))) {
                    j++;
                    continue;
                }

                if (k + 1 < nums.size() && nums.get(k).equals(nums.get(k + 1))) {
                    k--;
                    continue;
                }

                int sum = nums.get(i) + nums.get(j) + nums.get(k);

                if (sum == 0) {
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(nums.get(i));
                    r.add(nums.get(j));
                    r.add(nums.get(k));
                    result.add(r);
                }

                if (sum <= 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
