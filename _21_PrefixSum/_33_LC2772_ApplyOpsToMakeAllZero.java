public class _33_LC2772_ApplyOpsToMakeAllZero {

    public static void main(String[] args) {
        int[] A = {2, 2, 3, 1, 1, 0};
        int k = 3;
        System.out.println(checkArray(A, k));
        A = new int[]{2, 2, 3, 1, 1, 0};
        System.out.println(checkArray2(A, k));

        A = new int[]{5, 5, 5, 5, 5, 0};
        System.out.println(checkArray2(A, k));

        A = new int[]{2, 2, 3, 1, 1, 0};
        System.out.println(checkArray3(A, k));
    }

    public static boolean checkArray(int[] A, int k) {
        int cur = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (cur > A[i])
                return false;
            A[i] -= cur;
            cur += A[i];
            if (i >= k - 1)
                cur -= A[i - k + 1];
        }
        return cur == 0;
    }

    public static boolean checkArray2(int[] A, int k) {

        if (k == 1) return false;
        int cur = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            A[i] -= cur;
            if (A[i] < 0)
                return false;
            cur += A[i];
            if (i - k + 1 >= 0)
                cur -= A[i - k + 1];
        }
        return A[n - 1] == 0;
    }

    public static boolean checkArray3(int[] A, int k) {

        if (k == 1) return false;
        int cur = 0, n = A.length;
        int[] differences = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            cur += differences[i];
            A[i] -= cur;
            if (A[i] < 0)
                return false;
            if (A[i] == 0) continue;
            differences[i] += A[i];
        }
        return A[n - 1] == 0;
    }
}
