package com.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReversePolishNotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ex: 10 20 + 30 40 - * 50 2 / +
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(parseRPN(s));
        }
    }

    private static int parseRPN(final String rpn) {
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
