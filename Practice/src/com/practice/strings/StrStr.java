package com.practice.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrStr {

    @Test
    public void test() {
        assertEquals(2, strStr("samayakaur", "maya"));
        assertEquals(9, strStr("mississippi", "pi"));
        assertEquals(3, strStr("ississippi", "issip"));
        assertEquals(0, strStr("ississippi", "ississippi"));
    }

    /**
     * Below is O(n2) approach,
     * this can be solved by using KMP & Robin Carp Algos with better time complexity
     */
    public int strStr(String haystack, String needle) {

        if (needle.isEmpty())
            return 0;

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char h = haystack.charAt(i);
            char n = needle.charAt(j);

            if (h == n) {
                j++;
                if (j == needle.length()) {
                    return i - (j - 1);
                }
            } else {
                // take back i to one position ahead of last start position
                // this will take i to last start position, for loop increment will take it one position ahead of it
                i = i - j;
                j = 0;
            }
        }

        return -1;
    }
}
