package com.example.projecteuler;

import java.util.*;

public class Problem17 {
    private static final String ZERO = "Zero";
    private static final String HUNDRED = "Hundred";

    private static final Map<Long, String> NUMBER_WORDS = new HashMap<Long, String>() {{
        put(0L, ZERO);
        put(1L, "One");
        put(2L, "Two");
        put(3L, "Three");
        put(4L, "Four");
        put(5L, "Five");
        put(6L, "Six");
        put(7L, "Seven");
        put(8L, "Eight");
        put(9L, "Nine");
        put(10L, "Ten");
        put(11L, "Eleven");
        put(12L, "Twelve");
        put(13L, "Thirteen");
        put(14L, "Fourteen");
        put(15L, "Fifteen");
        put(16L, "Sixteen");
        put(17L, "Seventeen");
        put(18L, "Eighteen");
        put(19L, "Nineteen");
        put(20L, "Twenty");
        put(30L, "Thirty");
        put(40L, "Forty");
        put(50L, "Fifty");
        put(60L, "Sixty");
        put(70L, "Seventy");
        put(80L, "Eighty");
        put(90L, "Ninety");
        put(100L, HUNDRED);
        put(1_000L, "Thousand");
        put(1_000_000L, "Million");
        put(1_000_000_000L, "Billion");
        put(1_000_000_000_000L, "Trillion");
    }};

    private static int build(int index, List<Integer> numbers, StringBuilder result) {
        long power = (long) Math.pow(10, index);
        if (power == 1_000_000_000_000L) {
            long number = numbers.get(index++);
            if (number > 0) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(NUMBER_WORDS.get(number));
                tmp.append(" ");
                tmp.append(NUMBER_WORDS.get(power));
                tmp.append(" ");
                result.insert(0, tmp);
            }
            return index;
        }
        long n1 = 0, n2 = 0, n3 = 0;
        if (index < numbers.size()) {
            n3 = numbers.get(index++);
        }
        if (index < numbers.size()) {
            n2 = numbers.get(index++);
        }
        if (index < numbers.size()) {
            n1 = numbers.get(index++);
        }
        if (n1 > 0 || n2 > 0 || n3 > 0) {
            StringBuilder tmp = new StringBuilder();
            if (n1 > 0) {
                tmp.append(NUMBER_WORDS.get(n1));
                tmp.append(" ");
                tmp.append(HUNDRED);
                tmp.append(" ");
            }
            if (n2 > 1) {
                n2 *= 10;
                tmp.append(NUMBER_WORDS.get(n2));
                tmp.append(" ");
                if (n3 > 0) {
                    tmp.append(NUMBER_WORDS.get(n3));
                    tmp.append(" ");
                }
            } else {
                long n = Long.parseLong(String.valueOf(n2) + String.valueOf(n3));
                if (power >= 1_000) {
                    tmp.append(NUMBER_WORDS.get(n));
                    tmp.append(" ");
                } else if (n > 0) {
                    tmp.append(NUMBER_WORDS.get(n));
                    tmp.append(" ");
                }
            }
            if (power >= 1_000) {
                tmp.append(NUMBER_WORDS.get(power));
                tmp.append(" ");
            }
            result.insert(0, tmp);
        }
        return index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            long l = scanner.nextLong();
            List<Integer> numbers = new ArrayList<>();
            int divisor = 10;
            while (l > 0) {
                int remainder = (int) (l % divisor);
                numbers.add(remainder);
                l /= divisor;
            }
            StringBuilder result = new StringBuilder();
            if (numbers.size() == 0) {
                result.append(ZERO);
            }
            for (int index = 0; index < numbers.size(); ) {
                index = build(index, numbers, result);
            }
            System.out.println(result.toString().trim());
        }
        scanner.close();
    }
}
