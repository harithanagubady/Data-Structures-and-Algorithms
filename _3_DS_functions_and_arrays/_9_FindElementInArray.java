import java.util.*;

public class _9_FindElementInArray {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();

        System.out.println(findElement(arr, n, d));

    }

    public static int findElement(int[] arr, int n, int d) {
        for (int i = 0; i < n; i++) {
            if (d == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}