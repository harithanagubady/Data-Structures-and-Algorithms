package _05_Using_HashTable;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 */
public class _01_LC2133_ContainsAllNumbers {

    /*
    Illustration of BitSet
     */
    public static void illustrateBitSet() {
        BitSet b = new BitSet(6);

        b.set(4);
        System.out.println(b.get(4));

        b.set(4);
        b.set(4);
        b.set(4);
        System.out.println(b.get(3));
        System.out.println(b);
    }

    public static void main(String[] args) {
        //illustrateBitSet();

        int[][] matrix = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        System.out.println(solutionUsingHashSet(matrix));
        System.out.println(solutionUsingBitSet(matrix));
    }

    public static boolean solutionUsingHashSet (int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j]) || !colSet.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solutionUsingBitSet (int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            BitSet rowSet = new BitSet(n + 1);
            BitSet colSet = new BitSet(n + 1);
            for (int j = 0; j < n; j++) {

                //if element already exists in either row or column, then return false
                if (rowSet.get(matrix[i][j]) || colSet.get(matrix[j][i])) {
                    return false;
                }
                rowSet.set(matrix[i][j]);
                colSet.set(matrix[j][i]);
            }
        }
        return true;
    }
}
