package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        System.out.println(fraction.fractionToDecimal(0, -5));
    }

    public String fractionToDecimal(int n, int d) {

        if (n == 0) return "0";
        if (d == 0) return "";

        long numerator = n;
        long denominator = d;

        StringBuilder result = new StringBuilder();

        // XOR - returns true if both operands are different else returns false
        if ((numerator < 0) ^ (denominator < 0)) {
            result.insert(0, "-");
        }

        Map<Long, Integer> remainderMap = new HashMap<>();
        long remainder = Math.abs(numerator);
        denominator = Math.abs(denominator);

        long quotient = remainder / denominator;
        remainder = (remainder % denominator) * 10;

        result.append(quotient);

        if (remainder == 0)
            return result.toString();

        result.append(".");
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                return result.substring(0, index) + "(" + result.substring(index) + ")";
            }

            remainderMap.put(remainder, result.length());
            quotient = remainder / denominator;
            remainder = (remainder % denominator) * 10;
            result.append(quotient);
        }

        return result.toString();
    }
}
