package com.practice.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseString {

    @Test
    public void test() {
        assertEquals("blue is sky", reverseWords("   sky is    blue    "));
    }

    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();

        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (word.length() > 0) {
                    reverse.append(word + " ");
                    word = new StringBuilder();
                }
            } else {
                word.insert(0, s.charAt(i));
            }
        }

        return word.length() > 0 ?
                reverse.append(word).toString() :
                reverse.deleteCharAt(reverse.length() - 1).toString();
    }
}
