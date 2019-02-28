package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CutTheSticks {

    static int[] cutTheSticks(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        while (list.size() > 0) {
            int min = Collections.min(list);
            List<Integer> _list = new ArrayList<>();
            for (int num : list) {
                int diff = num - min;
                if (diff > 0) {
                    _list.add(diff);
                }
            }
            result.add(list.size());
            list = _list;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(cutTheSticks(new int[]{5, 4, 4, 2, 2, 8})).forEach(System.out::println);
        Arrays.stream(cutTheSticks(new int[]{1, 2, 3, 4, 3, 3, 2, 1})).forEach(System.out::println);
    }
}
