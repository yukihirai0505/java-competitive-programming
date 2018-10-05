package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FreqQuery {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        // 1 => add
        // 2 => delete
        // 3 => check presence
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> queries = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 5));
            add(Arrays.asList(1, 6));
            add(Arrays.asList(3, 2));
            add(Arrays.asList(1, 10));
            add(Arrays.asList(1, 10));
            add(Arrays.asList(1, 6));
            add(Arrays.asList(2, 5));
            add(Arrays.asList(3, 2));
        }};
        freqQuery(queries);
    }
}
