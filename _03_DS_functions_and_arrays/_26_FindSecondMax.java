public class _26_FindSecondMax {

    public static void main(String[] args) {
        int[] arr = {-1, -2, 8};

        System.out.println(findSecondMax (arr));
    }

    private static int findSecondMax(int[] arr) {
        int max = arr[0];
        int secMax = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                secMax = max;
                max = i;
            } else {
                if (secMax < i && i != max) {
                    secMax = i;
                }
            }
        }
        return secMax;
    }
}
