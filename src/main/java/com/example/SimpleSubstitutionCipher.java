package com.example;

public class SimpleSubstitutionCipher {


    private final static String key = "]kYV}(!7P$n5_0i R:?jOWtF/=-pe'AD&@r6%ZXs\"v*N"
            + "[#wSl9zq2^+g;LoB`aGh{3.HIu4fbK)mU8|dMET><,Qc\\C1yxJ";

    public static void main(String[] args) {
        String text = "I am Yuki Hirai";
        String enc = encode(text);
        System.out.println("Encoded: " + enc);
        System.out.println("\nDecoded: " + decode(enc));
    }

    private static String encode(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (char c : s.toCharArray())
            sb.append(key.charAt((int) c - 32));

        return sb.toString();
    }

    private static String decode(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (char c : s.toCharArray())
            sb.append((char) (key.indexOf((int) c) + 32));

        return sb.toString();
    }
}
