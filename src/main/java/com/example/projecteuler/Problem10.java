package com.example.projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem10 {

    private static final int[] primes = getPrimes(1000000);

    private static int[] getPrimes(int n) {
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor * factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primeList.add(i);
        }
        return primeList.stream().mapToInt(i -> i).toArray();
    }

    private static long getWays(int n) {
        long sum = 0;
        for (int prime : primes) {
            if (prime > n) break;
            sum += prime;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(getWays(scanner.nextInt()));
        }
        scanner.close();
    }
}
