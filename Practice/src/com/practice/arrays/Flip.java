package com.practice.arrays;

import java.util.ArrayList;

public class Flip {

	public static void main(String[] args) {
		// flip("101100001");
		// flip("101111111");

		System.out.println(flip("1101010001"));
		System.out.println(flip("101010010110"));
	}

    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<>();

        int maxEffect = 0;
        int effect = 0;
        int start = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                effect++;
            } else {
                effect--;
            }

            if (effect > maxEffect) {
                maxEffect = effect;
                result.clear();
                result.add(start + 1);
                result.add(i + 1);
            }

            if (effect < 0) {
                effect = 0;
                start = i + 1;
            }
        }

        return result;
    }

}
