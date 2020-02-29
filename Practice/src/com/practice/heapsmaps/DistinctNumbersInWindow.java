package com.practice.heapsmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DistinctNumbersInWindow {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(Arrays.asList(2, 3, 3, 2), dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3));
    }

    public ArrayList<Integer> dNums(List<Integer> A, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            Integer freq = map.containsKey(A.get(i)) ? map.get(A.get(i)) + 1 : 1;
            map.put(A.get(i), freq);

            if (i >= k - 1) {
                result.add(map.keySet().size());

                Integer removedNumIndex = i - (k - 1);
                Integer removedNumFreq = map.get(A.get(removedNumIndex));
                if (removedNumFreq == 1) {
                    map.remove(A.get(removedNumIndex));
                } else {
                    map.put(A.get(removedNumIndex), removedNumFreq - 1);
                }
            }
        }

        return result;
    }
}
