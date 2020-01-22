package com.practice.arrays;

import java.util.ArrayList;

public class AddOnetoNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> output = new ArrayList<>();
        if (a.size() == 0)
            return output;

        int carry = 1;
        for (int i = a.size() - 1; i >= 0; i--) {
            int num = a.get(i) + carry;

            if (a.get(i) == 10) {
                output.add(0, 0);
                carry = 1;
            } else {
                output.add(0, num);
                carry = 0;
            }
        }

        if (carry == 1) {
            output.add(0, 1);
        } else {
            while (output.get(0) == 0) {
                output.remove(0);
            }
        }

        return output;
    }

}
