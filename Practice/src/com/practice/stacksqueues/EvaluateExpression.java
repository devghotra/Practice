package com.practice.stacksqueues;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class EvaluateExpression {

    @Test
    public void test() {
        assertEquals(1, 1);
        //assertEquals(9, evalRPN(Arrays.asList("2", "1", "+", "3", "*")));
        assertEquals(14, evalRPN(Arrays.asList("5", "1", "2", "+", "4", "*", "+", "3", "-")));
    }

    public static int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            Integer n2 = stack.pop();
            Integer n1 = stack.pop();

            switch (token) {
                case "+":
                    stack.push(n1 + n2);
                    break;
                case "-":
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(n1 * n2);
                    break;
                case "/":
                    stack.push(n1 / n2);
                    break;
            }

        }

        return stack.pop();
    }

}
