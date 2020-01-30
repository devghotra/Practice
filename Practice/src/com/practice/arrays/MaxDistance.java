package com.practice.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxDistance {

    @Test
    public void test() {
        assertEquals(2, maximumGap(Arrays.asList(100, 100, 100)));
    }

    public int maximumGap(final List<Integer> A) {

        int n = A.size();
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = A.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(A.get(i), LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = A.get(n - 1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(A.get(j), RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
                    6 4 2 1 9 7 8 5 2
            LMin    6 4 2 1 1 1 1 1 1
            RMax    9 9 9 9 9 8 8 5 2

            Move Rmax pointer as long as value there is >= Rmin pointer value as this gives max distance between those pointers
            If value at Rmax pointer becomes smaller then move Rmin pointer until Rmax value again becomes >= Rmin value
         */
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;
    }
}
