package com.example;

class HillsAndVollyes {
    public int solution(int[] A) {
        int count = 1;
        boolean isUp = false;
        for (int i = 0; i < A.length; i++) {
            if (i > 0) {
                int prev = A[i - 1];
                int current = A[i];
                int diff = current - prev;
                if (diff == 0) continue;
                boolean _isUp = diff > 0;
                if (isUp != _isUp) {
                    count++;
                    isUp = !isUp;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HillsAndVollyes h = new HillsAndVollyes();
        int[] data = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        System.out.println(h.solution(data));
        int[] data2 = {-3,-3};
        System.out.println(h.solution(data2));
    }
}