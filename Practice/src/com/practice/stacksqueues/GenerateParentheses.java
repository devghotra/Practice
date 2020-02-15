package com.practice.stacksqueues;

import java.util.Stack;

public class GenerateParentheses {

    public int isValid(String A) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            Character c = A.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }

                Character lc = stack.pop();
                if (c == ')' && lc != '(') {
                    return 0;
                } else if (c == '}' && lc != '{') {
                    return 0;
                } else if (c == ']' && lc != '[') {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;

    }
}
