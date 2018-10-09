package com.example;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int aCount = countStr(s);
        if (aCount == 0) return 0;
        if (s.length() == 1) return n;
        long count = n / s.length();
        long remainder = n % s.length();
        long total = aCount * count;
        if (remainder > 0) {
            String substr = s.substring(0, (int) remainder);
            total += countStr(substr);
        }
        return total;
    }

    static int countStr(String str) {
        return str.length() - str.replaceAll("a", "").length();
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10)); // Expected Output => 7
        System.out.println(repeatedString("a", 1000000000000L)); // Expected Output => 1000000000000
        System.out.println(repeatedString("ceebbcb", 817723)); // Expected Output => 0
        System.out.println(repeatedString(
                "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm",
                736778906400L
        )); // Expected Output => 51574523448
        System.out.println(repeatedString(
                "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq",
                549382313570L
        ));  // Expected Output => 16481469408
    }
}
