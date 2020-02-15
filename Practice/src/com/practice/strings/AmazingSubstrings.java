package com.practice.strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AmazingSubstrings {

    @Test
    public void test() {
        assertEquals(6, solve("ABED"));
    }

    public int solve(String A) {

        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (vowels.contains(c)) {
                count += A.length() - i;
            }
        }

        return count % 10003;
    }
}
