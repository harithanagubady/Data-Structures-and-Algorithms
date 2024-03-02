//Java implementation of above approach

import java.util.Vector;

import java.math.*;

public class _03_MetaBinarySearch {

    // Function to show the working of Meta binary search
    static int bsearch(Vector<Integer> A, int key_to_search) {
        int n = A.size();
        int lg = (int)(Math.log(n - 1) / Math.log(2)) + 1;

        int pos = 0;
        for (int i = lg - 1; i >= 0; i--) {
            if (A.get(pos) == key_to_search) {
                return pos;
            }

            // Incrementally construct the
            // index of the target value
            int new_pos = pos | (1 << i);

            // find the element in one
            // direction and update position
            if ((A.get(new_pos) <= key_to_search)) {
                pos = new_pos;
            }
        }

        // if element found return pos otherwise -1
        return ((A.get(pos) == key_to_search) ? pos : -1);
    }

    public static <T extends Comparable<T>> int metaBinarySearch(T[] values, T valueToFind) {
        if (values == null) {
            throw new IllegalArgumentException("Cannot binary search null array!");
        }

        if (valueToFind == null) {
            throw new IllegalArgumentException("Cannot binary search for null element!");
        }

        int n = values.length;
        int numBitsNeededForMaxIndex = 0;

        while ((1 << numBitsNeededForMaxIndex) <= n) { //1, 2, 4, 8 //size of array
            ++numBitsNeededForMaxIndex; //1, 2, 3, 4 //no of bits required for the size
        }

        int index = 0;

        if (index < n && values[index].compareTo(valueToFind) == 0) {
            return index;
        }

        for (int shift = numBitsNeededForMaxIndex - 1; shift >= 0; --shift) {
            int newIndexCandidate = index + (1 << shift);

            if (newIndexCandidate >= n) {
                continue;
            }

            int comparison = values[newIndexCandidate].compareTo(valueToFind);

            if (comparison == 0) {
                return newIndexCandidate;
            }

            if (comparison < 0) {
                index = newIndexCandidate;
            }
        }

        return -1;
    }

    // Driver code
    static public void main(String[] args) {
        Vector<Integer> A = new Vector<>();
        int[] arr = {-2, 1, 2, 10, 100, 250, 1234, 32315};
        for (int j : arr) {
            A.add(j);
        }
        System.out.println(bsearch(A, 1));
    }
}
