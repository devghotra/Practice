package com.practice.hashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Anagrams {

    @Test
    public void test() {
        assertEquals(1, 1);
        System.out.println(anagrams(Arrays.asList("cat", "dog", "god", "tca", "cas", "sac", "tca")));
    }

    public ArrayList<ArrayList<Integer>> anagrams(List<String> input) {

        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= input.size(); i++) {
            char[] chars = input.get(i - 1).toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (map.containsKey(sortedWord)) {
                ArrayList<Integer> l = map.get(sortedWord);
                l.add(i);
                map.put(sortedWord, l);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(sortedWord, l);
            }
        }

        return (ArrayList) map.values().stream().collect(Collectors.toList());
    }

}
