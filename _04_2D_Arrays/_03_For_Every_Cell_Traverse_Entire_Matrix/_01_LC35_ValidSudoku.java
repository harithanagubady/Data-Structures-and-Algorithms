package _03_For_Every_Cell_Traverse_Entire_Matrix;

/*
https://leetcode.com/problems/valid-sudoku/
 */
import java.util.HashSet;

public class _01_LC35_ValidSudoku {

    /*
    refer _05_Using_HashTable._01_LC2133_ContainsAllNumbers before this solution
     */
    public static boolean isValidSudoku(char[][] board) {

        /*

        1) i represents row for row condition whereas j is column
        2) i represents col for col condition whereas j is row
        3) i represents block for block condition whereas j is cell of the block,
            Hence i is used to calculate offset(or first cell) of the 3x3 block and
            j is used to calculate exact cell of the 3x3 block
            (means, if i = 8, then we are at 8th block, whose offset or first cell is (6, 6)
                    if j = 8, then j is 8th cell of the ith(8th) block, whose index is (8, 7)
        */
        for (int i = 0; i < 9; i++) {
            HashSet<String> set = new HashSet<>();
            int offsetRow = 3 * (i / 3), offsetCol = 3 * (i % 3);
            for (int j = 0; j < 9; j++) {

                //row condition
                if (board[i][j] != '.' && !set.add("r" + board[i][j])) {
                    return false;
                }

                //col condition
                if (board[j][i] != '.' && !set.add("c" + board[j][i])) {
                    return false;
                }

                //block condition
                int _i = offsetRow + j / 3;
                int _j = offsetCol + j % 3;
                if (board[_i][_j] != '.' && !set.add("b" + board[_i][_j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));

        char[][] board2 =
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board2));
    }
}
