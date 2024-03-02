public class _02_BinarySearch {

    public static void main(String[] args) {
        int[] arr = {7, 9, 18, 22, 58, 84, 85};

        int k = 18;
        //int i = binarySearchIterative(arr, k);

        int i = binarySearchRecursive(arr, k, 0, arr.length - 1);
        if (i == -1) System.out.println("Not Found");
        else {
            System.out.println("Found at " + i);
        }
    }

    private static int binarySearchIterative(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] > k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int k, int l, int r) {

        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] > k) {
                return binarySearchRecursive(arr, k, l, mid);
            } else {
                return binarySearchRecursive(arr, k, mid + 1, r);
            }
        }

        return -1;
    }
}
