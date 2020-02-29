
package com.practice.hashing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WindowString {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("BANCB", minWindow("ADOBECODEBANCB", "ABCB"));
    }

    public String minWindow(String S, String T) {
        String minWindow = S;
        Map<Character, Integer> needed = new HashMap<>();
        Map<Character, Integer> found = new HashMap<>();

        char[] tChars = T.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            int count = needed.get(tChars[i]) == null ? 1 : needed.get(tChars[i]) + 1;
            needed.put(tChars[i], count);
            found.put(tChars[i], 0);
        }

        int start = 0;
        int matchCount = 0;
        char[] sChars = S.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            if (!needed.containsKey(c)) {
                continue;
            }

            found.put(c, found.get(c) + 1);
            if (found.get(c) <= needed.get(c)) {
                matchCount++;
            }

            if (matchCount == T.length()) {
                // advance begin index as far right as possible, stop when advancing breaks window constraint.
                while (start <= i) {
                    if (needed.containsKey(sChars[start])) {
                        if (found.get(sChars[start]) > needed.get(sChars[start])) {
                            found.put(sChars[start], found.get(sChars[start]) - 1);
                        } else {
                            break;
                        }
                    }
                    start++;
                }

                if ((i - start) + 1 < minWindow.length()) {
                    minWindow = S.substring(start, i + 1);
                }
            }
        }

        return matchCount == T.length() ? minWindow : "";
    }

}
