package com.practice.twopointers;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

public class MergeSortedList {

    @Test
    public void test() {
        ArrayList<Integer> a = Lists.newArrayList(-4, -3, 0);
        ArrayList<Integer> b = Lists.newArrayList(2);

        merge(a, b);

        System.out.println(a);
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int j = 0;
        for (int i = 0; j < b.size() && i < a.size(); ) {
            if (b.get(j) <= a.get(i)) {
                a.add(i, b.get(j));
                j++;
            } else {
                i++;
            }
        }

        for (; j < b.size(); j++) {
            a.add(b.get(j));
        }
    }
}
