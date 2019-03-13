package com.example.projecteuler;

import java.util.*;

public class Problem22 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            String name = scanner.next();
            names.add(name);
        }
        Collections.sort(names);
        for (int i = 0; i < T; i++) {
            String name = names.get(i);
            char[] ch = name.toLowerCase().toCharArray();
            int score = 0;
            for (char c : ch) {
                score += (int) c - 96;
            }
            map.put(name, score * (i + 1));
        }
        int T2 = scanner.nextInt();
        for (int i = 0; i < T2; i++) {
            String name = scanner.next();
            System.out.println(map.get(name));
        }
    }

}
