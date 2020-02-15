package com.practice.backtracking;

import java.util.ArrayList;

public class Combinations {

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    public void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
