package com.example.projecteuler;

import java.util.*;

public class Problem17 {
    private static final String ZERO = "Zero";
    private static final String HUNDRED = "Hundred";
    private static final String THOUSAND = "Thousand";
    private static final String MILLION = "Million";
    private static final String BILLION = "Billion";
    private static final String TRILLION = "Trillion";

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
        put(1_000L, THOUSAND);
        put(1_000_000L, MILLION);
        put(1_000_000_000L, BILLION);
        put(1_000_000_000_000L, TRILLION);
    }};

    private static int build(int index, List<Integer> numbers, String unit, StringBuilder result, boolean isLast) {
        long n1 = 0;
        long n2 = 0;
        long n3 = 0;
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
            StringBuilder temp = new StringBuilder();
            if (n1 > 0) {
                String wordNumber = NUMBER_WORDS.get(n1);
                temp.append(wordNumber);
                temp.append(" ");
                temp.append(HUNDRED);
                temp.append(" ");
            }
            if (n2 > 1) {
                n2 *= 10;
                String wordNumber = NUMBER_WORDS.get(n2);
                temp.append(wordNumber);
                temp.append(" ");

                if (n3 > 0) {
                    wordNumber = NUMBER_WORDS.get(n3);
                    temp.append(wordNumber);
                    temp.append(" ");
                }
            } else {
                String concat = String.valueOf(n2)
                        + String.valueOf(n3);
                long n = Long.parseLong(concat);
                if (!isLast) {
                    String wordNumber = NUMBER_WORDS.get(n);
                    temp.append(wordNumber);
                    temp.append(" ");
                }
                if (isLast && n > 0) {
                    String wordNumber = NUMBER_WORDS.get(n);
                    temp.append(wordNumber);
                    temp.append(" ");
                }
            }
            if (!unit.equals("")) {
                temp.append(unit);
                temp.append(" ");
            }
            result.insert(0, temp);
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
                long power = (long) Math.pow(10, index);
                if (power >= 1_000_000_000_000L) {
                    long number = numbers.get(index++);
                    if (number > 0) {
                        StringBuilder temp = new StringBuilder();
                        String wordNumber = NUMBER_WORDS.get(number);
                        temp.append(wordNumber);
                        temp.append(" ");
                        String wordPower = NUMBER_WORDS.get(power);
                        temp.append(wordPower);
                        temp.append(" ");
                        result.insert(0, temp);
                    }
                } else if (power >= 1_000_000_000) {
                    index = build(index, numbers, NUMBER_WORDS.get(1_000_000_000L), result, false);
                } else if (power >= 1_000_000) {
                    index = build(index, numbers, NUMBER_WORDS.get(1_000_000L), result, false);
                } else if (power >= 1_000) {
                    index = build(index, numbers, NUMBER_WORDS.get(1_000L), result, false);
                } else {
                    index = build(index, numbers, "", result, true);
                }
            }
            System.out.println(result.toString().trim());
        }
        scanner.close();
    }
}
