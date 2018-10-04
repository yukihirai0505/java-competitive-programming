package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    // Complete the countTriplets function below.
    private static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long, Long> oneCounts = new HashMap<>();
        Map<Long, Long> pairCounts = new HashMap<>();
        for (Long num : arr) {
            if (num % r == 0) {
                long pre = num / r;
                Long pairCount = pairCounts.get(pre);
                if (pairCount != null) {
                    count += pairCount;
                }
                Long cnt1 = oneCounts.get(pre);
                if (cnt1 != null) {
                    pairCounts.put(num, pairCounts.getOrDefault(num, 0L) + cnt1);
                }
            }
            oneCounts.put(num, oneCounts.getOrDefault(num, 0L) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        //long arr[] = {1,2,2,4};
        Long[] arr = new Long[]{1L, 3L, 9L, 9L, 27L, 81L};
        List<Long> list = Arrays.asList(arr);
        int r = 3;
        CountTriplets.countTriplets(list, r);
    }
}
