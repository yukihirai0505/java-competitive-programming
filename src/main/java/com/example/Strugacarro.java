package com.example;

class Strugacarro {

    public String solution(int[] T) {
        int seasonDays = T.length / 4;
        int maxDiff = 0;
        int seasonIndex = 0;
        String[] seasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
        for (int i = 0; i < T.length; i += seasonDays) {
            int max = T[i];
            int min = T[i];
            for (int j = 0; j < seasonDays; j++) {
                int num = T[i + j];
                if (max < num) {
                    max = num;
                }
                if (min > num) {
                    min = num;
                }
            }
            int diff = max - min;
            if (diff > maxDiff) {
                maxDiff = diff;
                seasonIndex = i / seasonDays;
            }
        }
        return seasons[seasonIndex];
    }

    public static void main(String[] args) {
        Strugacarro strugacarro = new Strugacarro();
        int[] data = {-3, -14, -5, 7, 8, 42, 8, 3};
        System.out.println(strugacarro.solution(data));
        int[] data2 = {2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18};
        System.out.println(strugacarro.solution(data2));
        int[] data3 = {2, 1, 1, 10, 2, 13, 3, -18};
        System.out.println(strugacarro.solution(data3));
    }
}
