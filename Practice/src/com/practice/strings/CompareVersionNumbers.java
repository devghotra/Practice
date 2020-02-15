package com.practice.strings;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CompareVersionNumbers {

    @Test
    public void test() {
        assertEquals(-1, compareVersion1("13.0", "13.0.8"));
        assertEquals(-1, compareVersion1("1.2", "1.3"));
        assertEquals(1, compareVersion1("1.3", "0.4"));
        assertEquals(1, compareVersion1("1.2.2.23.42", "1.2.2.23"));
        assertEquals(0, compareVersion1("13.0", "13.0"));
        assertEquals(0, compareVersion1("01", "1"));
        assertEquals(0, compareVersion1("1.0", "1"));
        assertEquals(1, compareVersion1("4444371174137455", "5.168"));
    }

    public int compareVersion1(String v1, String v2) {
        String[] v1Tokens = v1.split("\\.");
        String[] v2Tokens = v2.split("\\.");

        int maxLength = Math.max(v1Tokens.length, v2Tokens.length);

        for (int i = 0; i < maxLength; i++) {
            String v11 = i < v1Tokens.length ? removeLeadingZeros(v1Tokens[i]) : "0";
            String v22 = i < v2Tokens.length ? removeLeadingZeros(v2Tokens[i]) : "0";
            if (!v11.equals(v22)) {
                return compareNumbers(v11, v22);
            }
        }

        return 0;
    }

    private int compareNumbers(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String[] arr = {s1, s2};
            Arrays.sort(arr);
            return arr[1] == s1 ? 1 : -1;
        }
        return s1.length() > s2.length() ? 1 : -1;
    }

    private String removeLeadingZeros(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return s.substring(i);
            }
        }
        return "0";
    }

    public int compareVersion_old(String v1, String v2) {
        int i1 = 0;
        int i2 = 0;

        while (i1 < v1.length() || i2 < v2.length()) {
            String sv1 = "";
            String sv2 = "";

            for (int j1 = i1; j1 < v1.length(); j1++, i1++) {
                char c = v1.charAt(j1);
                if (c == '.') {
                    i1 = ++j1;
                    break;
                }
                sv1 += c;
            }

            for (int j2 = i2; j2 < v2.length(); j2++, i2++) {
                char c = v2.charAt(j2);
                if (c == '.') {
                    i2 = ++j2;
                    break;
                }
                sv2 += c;
            }

            int res = compare(sv1, sv2);
            if (res != 0)
                return res;
        }

        return 0;
    }

    private int compare(String sv1, String sv2) {
        if (sv1.equals(sv2))
            return 0;

        BigInteger n1 = sv1.isEmpty() ? BigInteger.ZERO : new BigInteger(sv1);
        BigInteger n2 = sv2.isEmpty() ? BigInteger.ZERO : new BigInteger(sv2);
        return n1.compareTo(n2);
    }

}
