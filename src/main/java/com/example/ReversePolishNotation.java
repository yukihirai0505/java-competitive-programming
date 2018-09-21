package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {
    public final int parseRPN(final String rpn) {
        final Deque<Integer> stack = new ArrayDeque<Integer>();

        // 連続した空白文字をスペース１つ分に置き換える
        String s = rpn.replaceAll("\\s+", " ");
        final String[] arr = s.trim().split(" ");

        // 数字
        for (String e : arr) {
            if ('0' <= e.charAt(0) && e.charAt(0) <= '9') {
                stack.push(Integer.parseInt(e));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (e) {
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        // div/0 に注意
                        stack.push(b / a);

                        break;
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
