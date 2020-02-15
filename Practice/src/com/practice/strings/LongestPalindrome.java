package com.practice.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindrome {

    @Test
    public void test() {
        assertEquals("", longestPalindrome("abacdfgdcaba"));
    }

    /**
     * Also, check DP solution - https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
     */
    public String longestPalindrome(String A) {
        int n = A.length();
        while (n > 0) {
            for (int i = 0; i <= A.length() - n; i++) {
                String s = A.substring(i, n + i);
                if (isPalindrome(s)) {
                    return s;
                }
            }
            n--;
        }

        return "";
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
