package com.example;

import java.util.HashMap;
import java.util.Map;

public class QqualizeArray {

    private static int equalizeArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : arr) {
            int value = map.getOrDefault(n, 0) + 1;
            max = Math.max(max, value);
            map.put(n, value);
        }
        return arr.length - max;
    }

    public static void main(String[] args) {
        System.out.println(equalizeArray(new int[]{3, 3, 2, 1, 3}));
        System.out.println(equalizeArray(new int[]{1, 2, 3, 1, 2, 3, 3, 3}));
    }
}
