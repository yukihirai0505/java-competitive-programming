package com.example.projecteuler;

import java.util.Scanner;

public class Problem27 {

    private static boolean[] prime = generatePrimes(10000000);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scanner.nextInt();
        int maxPrimesEncountered = 0;
        int maxA = 0;
        int maxB = 0;
        for (int a = num * -1; a <= num; a++) {
            for (int b = 2; b <= num; b++) {
                if (b > 0 && a * b < 0 && prime[b] && (1 + a + b) % 2 != 0) {
                    int primeCount = getPrimeCount(a, b, num);

                    if (primeCount > maxPrimesEncountered) {
                        maxPrimesEncountered = primeCount;
                        maxA = a;
                        maxB = b;
                    }
                }
            }
        }
        System.out.println(maxA + " " + maxB);
    }

    private static int getPrimeCount(int a, int b, int num) {
        int primeCount = 0;
        for (int n = 0; n < num; n++) {
            int nSquared = (int) Math.pow(n, 2);
            int res = nSquared + n * a + b;
            if (res > 0 && prime[res]) primeCount += 1;
            else break;
        }
        return primeCount;
    }

    private static boolean[] generatePrimes(int limit) {
        int root = (int) Math.ceil(Math.sqrt(limit));
        boolean[] prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;

        // Sieve of Atkin -> https://en.wikipedia.org/wiki/Sieve_of_Atkin
        for (int x = 1; x < root; x++) {
            for (int y = 1; y < root; y++) {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];

                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];

                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }

        for (int i = 5; i <= root; i++) {
            if (prime[i]) {
                for (int j = i * i; j < limit; j += i * i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

}
