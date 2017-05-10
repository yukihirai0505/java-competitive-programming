package com.example.stack;

/**
 * Created by Yuky on 2017/05/10.
 */
public class IntStack {
    private int[] data = new int[256];
    private int sp = 0;
    public int pop() { return data[--sp]; }
    public void push(int value) { data[sp++] = value; }
}
