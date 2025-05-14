public class _05_LC2485_FindPivotInteger {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        for (int x = 1; x <= n; x++) {
            if (x * x == sum) return x;
        }
        return -1;
    }
}
