class PlusMinus {

    private static void plusMinus(int[] arr) {
        float positive = 0;
        float negative = 0;
        float zero = 0;
        for (int a : arr) {
            if (a > 0) {
                positive++;
            } else if (a < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println(String.format("%.6f", positive / arr.length));
        System.out.println(String.format("%.6f", negative / arr.length));
        System.out.println(String.format("%.6f", zero / arr.length));
    }

    public static void main(String[] args) {
        plusMinus(new int[]{1, 2, 3, 0, -1});
    }
}
