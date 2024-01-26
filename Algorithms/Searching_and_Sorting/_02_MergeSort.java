public class _02_MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 0, 5, 95, 4, -100, 200, 0};
        int arrSize = arr.length;
        mergeSort(arr, 0, arrSize - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int left, int right) {
        System.out.println("MergeSort: " + left + " to " + right);

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
        System.out.println("=================");
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        System.out.println("Merge: " + left + " to " + right);
        int i, j, k;

        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        //create new arrays to store the elements from (left to mid) and (mid+1 to right)
        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        for (i = 0; i < sizeLeft; i++) {
            leftArray[i] = arr[left + i];
        }

        for (j = 0; j < sizeRight; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        System.out.print("leftArray: ");
        for (int x : leftArray){
            System.out.print(x + ", ");
        }
        System.out.println();

        System.out.print("rightArray: ");
        for (int x : rightArray){
            System.out.print(x + ", ");
        }
        System.out.println();

        i = 0;
        j = 0;
        k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < sizeLeft) {
            arr[k++] = leftArray[i++];
        }

        while (j < sizeRight) {
            arr[k++] = rightArray[j++];
        }

        System.out.print("Merged Array: ");
        for (int x = left; x <= right; x++) {
            System.out.print(arr[x] + ", ");
        }
        System.out.println();
    }
}
