import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<Integer> pascalsTriangle(int row) {
        if (row == 1) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            return currentRow;
        }

        List<Integer> leftRow = pascalsTriangle(row - 1);
        List<Integer> rightRow = pascalsTriangle(row - 1);

        return mergeRows(leftRow, rightRow);
    }

    private static List<Integer> mergeRows(List<Integer> leftRow, List<Integer> rightRow) {
        List<Integer> mergedRow = new ArrayList<>();
        mergedRow.add(1); // first element of each row is always 1

        int minSize = Math.min(leftRow.size(), rightRow.size());
        for (int i = 1; i < minSize; i++) {
            mergedRow.add(leftRow.get(i) + rightRow.get(i));
        }

        // Add remaining elements from the longer row
        List<Integer> longerRow = leftRow.size() > rightRow.size() ? leftRow : rightRow;
        for (int i = minSize; i < longerRow.size(); i++) {
            mergedRow.add(longerRow.get(i));
        }

        return mergedRow;
    }

    public static void main(String[] args) {
        int rowNumber = 5;
        List<Integer> pascalRow = pascalsTriangle(rowNumber);
        System.out.println(pascalRow);
    }
}