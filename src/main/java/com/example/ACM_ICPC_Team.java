package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ACM_ICPC_Team {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        BitSet[] bsa = new BitSet[topic.length];
        for (int i = 0; i < topic.length; i++) {
            bsa[i] = new BitSet();
            char[] ca = topic[i].toCharArray();
            for (int j = 0; j < ca.length; j++) {
                if (ca[j] == '1') bsa[i].set(j);
            }
        }
        final ArrayList<BitSet> maxs = new ArrayList<>();
        int maxCnt = 0;
        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                BitSet cur = new BitSet();
                cur.or(bsa[i]);
                cur.or(bsa[j]);
                int cnt = cur.cardinality();
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxs.clear();
                    maxs.add(cur);
                } else if (cnt == maxCnt) {
                    maxs.add(cur);
                }
            }
        }
        return new int[]{maxCnt, maxs.size()};
    }

    public static void main(String[] args) throws IOException {
        // 5, 2
        Arrays.stream(acmTeam(new String[]{
                "10101",
                "11100",
                "11010",
                "00101",
        })).forEach(System.out::println);
        // 5, 6
        Arrays.stream(acmTeam(new String[]{
                "11101",
                "10101",
                "11001",
                "10111",
                "10000",
                "01110"
        })).forEach(System.out::println);


    }
}
