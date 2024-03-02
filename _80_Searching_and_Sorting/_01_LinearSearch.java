public class _01_LinearSearch {

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 0, 11, 34, 1};
        int k = 11;
        int i = linearSearch(arr, k);
        if(i == -1) {
            System.out.println("Not Found");
        }
        System.out.println("Found at index: " + i);
    }

    public static int linearSearch (int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
