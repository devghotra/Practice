package com.practice.strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {

    @Test
    public void test() {
        LongestCommonPrefix scp = new LongestCommonPrefix();
        assertEquals("abc", longestCommonPrefix(Arrays.asList("abcdefgh", "abcefgh")));
        assertEquals("", longestCommonPrefix(Arrays.asList("uksks", "djksnkdsks")));

    }

    public String longestCommonPrefix(List<String> list) {
        if (list.size() == 0)
            return "";

        String commonPrefix = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            commonPrefix = findCommonPrefix(commonPrefix, list.get(i));
            if (commonPrefix.isEmpty()) {
                return "";
            }
        }

        return commonPrefix;
    }

    private String findCommonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());

        StringBuilder common = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                common.append(s1.charAt(i));
            }
        }

        return common.toString();
    }

}
