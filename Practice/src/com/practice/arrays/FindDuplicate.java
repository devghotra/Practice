package com.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicate {

	public static void main(String[] args) {
		Integer[] arr =  {1, 2, 3, 1, 3, 6, 6};
		List<Integer> a = Arrays.asList(arr);
		System.out.println(repeatedNumber(a));
	}

    public static int repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<a.size(); i++){
            int num = a.get(i);

            if(set.contains(num)){
                return num;
            } else{
                set.add(num);
            }
        }

        return 0;
    }
}
