package com.practice.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinCharsToMakePalindrome {

    @Test
    public void test() {
        assertEquals(2, solve("viver"));
        assertEquals(1, solve("acecar"));
        assertEquals(4, solve("xyz12"));
        assertEquals(0, solve("aa"));
        assertEquals(0, solve("racecar"));
        assertEquals(10, solve("gdracecarwr"));
        assertEquals(2, solve("AACECAAAA"));
        assertEquals(8, solve("ABCECAABA"));
    }

    public int solve(String A) {
        int n = A.length();
        while(n > 1 && !isPalindrome(A, n)) {
            n--;
        }

        return A.length() - n;
    }

    private boolean isPalindrome(String s, int length) {
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
