/*
Given an array of positive and negative integers. Arrange such that negative elements towards left and positive elements towards right
The order doesn't matter

eg: {1, 2, -3, -8}
o/p: (-3, -8, 1, 2}
 */
public class _27_RearrangeValues {

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, -8};

        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != pos) {
                    int temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                }
                pos++;
            }
        }

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
