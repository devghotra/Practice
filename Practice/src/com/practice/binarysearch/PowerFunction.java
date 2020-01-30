package com.practice.binarysearch;

public class PowerFunction {

    public static void main(String[] args) {
        // System.out.println(pow(2132,0,12));
        System.out.println(pow(-1, 1, 20));
    }

    public static int pow(int x, int y, int z) {
        int sign = x < 0 ? -1 : 1;

        if (x == 0)
            return 0;

        if (y == 0)
            return 1 % z;

        if (y == 1)
            return x < 0 ? (z + x) % z : x % z;

        int result = x;
        for (int i = y; i > 1; ) {
            result *= result;
            i /= 2;
        }

        return result % 5;
    }

}
