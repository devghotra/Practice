package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Two2Sum {

    public static void main(String[] args) {
        Two2Sum twoSum = new Two2Sum();
        Integer[] input = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        System.out.println(twoSum.twoSum(Arrays.asList(input), -3));

    }

    // returned answers (both index1 and index2 ) are not zero-based
    public ArrayList<Integer> twoSum(List<Integer> input, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int currentIndex = 0; currentIndex < input.size(); currentIndex++) {
            int n2 = input.get(currentIndex);
            int n1 = target - n2;

            if (map.containsKey(n1)) {
                result.add(map.get(n1));
                result.add(currentIndex + 1);
                break;
            } else if (!map.containsKey(n2)) {
                map.put(n2, currentIndex + 1);
            }
        }

        return result;
    }

}
