package com.practice.bit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DifferentBitsSumPairwise {

    /*
     001
     011
     101

    We are doing column wise and calculating ones and then remaining would be zeroes.
    Multiplying both will give you answer of that col.

    if in given column there are 2 ones and 3 zeros then there will be 2x3 combinations of difference
    */

    @Test
    public void test() {
        assertEquals(8, cntBits(Arrays.asList(1, 3, 5)));
    }

    public int cntBits(List<Integer> nums) {
        int ans = 0; // Initialize result
        int n = nums.size();

        // traverse over all bits
        for (int i = 0; i < 32; i++) {

            // count number of elements with i'th bit not set
            int zeros = 0; // count of zero's
            for (int j = 0; j < n; j++) {
                if ((nums.get(j) & (1 << i)) == 0) {
                    zeros++;
                }
            }

            // muliply by 2 it will be same for f(A,B) & f(B,A)
            ans += (zeros * (n - zeros) * 2);
        }

        return ans;
    }

}
