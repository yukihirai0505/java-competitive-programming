package com.example;

import java.util.Stack;

/**
 * Created by Yuky on 2017/05/10.
 */
public class JavaStackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Item1");
        stack.push("Item2");
        stack.push("Item3");
        System.out.println(stack.pop()); // Item3
        stack.push("Item4");
        stack.push("Item5");
        System.out.println(stack.pop()); // Item5
        System.out.println(stack.pop()); // Item4
        System.out.println(stack.pop()); // Item2
        stack.push("Item6");
        System.out.println(stack.pop()); // Item6
        System.out.println(stack.pop()); // Item1
    }
}
