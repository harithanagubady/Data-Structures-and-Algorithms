import java.util.Arrays;
import java.util.Stack;

public class _03_NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        int[] newArr;
        newArr = solution1(arr, new int[arr.length], new Stack<>());
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        newArr = solution2(arr, new int[arr.length], new Stack<>());
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] solution1(int[] arr, int[] newArr, Stack<Integer> stack) {
        for (int i = arr.length - 1; i >= 0; i--) {

            //POP SMALLEST
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }

            //PRINT ANS
            if (stack.isEmpty()) {
                newArr[i] = -1;
            } else {
                newArr[i] = stack.peek();
            }

            //PUSH CURRENT
            stack.push(arr[i]);
        }
        return newArr;
    }

    //2, 5, 9, 3, 1, 12, 6, 8, 7
    public static int[] solution2(int[] arr, int[] newArr, Stack<Integer> stack) {
        for (int i = 0; i < arr.length; i++) { //0

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                newArr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            newArr[stack.pop()] = -1;
        }
        return newArr;
    }
}
