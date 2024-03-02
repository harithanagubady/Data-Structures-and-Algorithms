import java.util.Stack;

public class _06_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6};
        int window = 4;
        int[] ans = solution2(arr, window);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution2(int[] arr, int window) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);//stack: 0, 1
        }
        while (stack.size() > 0) {
            nge[stack.pop()] = arr.length;
        }
        return calculateSlidingWindowMax(arr, nge, window);
    }

    private static int[] calculateSlidingWindowMax(int[] arr, int[] nge, int window) {

        //2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length - 3; i++) {
            int j = i;
            while (nge[j] < i + window) {
                if (nge[j] == arr.length) {
                    ans[i] = arr[i];
                }
                j = nge[j];
            }
            ans[i] = arr[j];
        }
        for (int i = arr.length - 1; i >= arr.length - window + 1; i--) {
            ans[i] = -1;
        }
        return ans;
    }

    private static int[] solution1(int[] arr, int window) {
        int[] nge = _03_NextGreaterElement.solution2(arr, new int[arr.length], new Stack<>());

        //     nge: {9, 12, 8, 12, 7, 12, 14, 14, 32, 32, -1, 7, 19, -1, 12,-1,-1}
        //     ans: {9, 9, 8, 12, 12, 14, 14, 32, 32, 32, 19, 19, 19, 12, 12, 12, 6}
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length - window + 1; i++) { //i=1
            int k = i;
            for (int j = k; j < i + window; j++) {
                while (nge[k] == arr[j]) { //j = 1 to 4   {12 == }
                    ans[i] = nge[k];
                    k = j;
                }
            }
            ans[i] = arr[k];
        }
        for (int i = arr.length - 1; i >= arr.length - window + 1; i--) {
            ans[i] = -1;
        }
        return ans;
    }
}
