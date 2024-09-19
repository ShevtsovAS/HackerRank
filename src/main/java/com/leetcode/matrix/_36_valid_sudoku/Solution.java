package com.leetcode.matrix._36_valid_sudoku;

/**
 * <h1>36. Valid Sudoku</h1>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:<br>
 * <br>
 * Each row must contain the digits 1-9 without repetition.<br>
 * Each column must contain the digits 1-9 without repetition.<br>
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.<br>
 * <br>
 * Note:<br>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.<br>
 * Only the filled cells need to be validated according to the mentioned rules.<br>
 * <br>
 * Example 1:<br>
 * Input: board =<br>
 * [["5","3",".",".","7",".",".",".","."]<br>
 * ,["6",".",".","1","9","5",".",".","."]<br>
 * ,[".","9","8",".",".",".",".","6","."]<br>
 * ,["8",".",".",".","6",".",".",".","3"]<br>
 * ,["4",".",".","8",".","3",".",".","1"]<br>
 * ,["7",".",".",".","2",".",".",".","6"]<br>
 * ,[".","6",".",".",".",".","2","8","."]<br>
 * ,[".",".",".","4","1","9",".",".","5"]<br>
 * ,[".",".",".",".","8",".",".","7","9"]]<br>
 * Output: true<br>
 * <br>
 * Example 2:<br>
 * Input: board =<br>
 * [["8","3",".",".","7",".",".",".","."]<br>
 * ,["6",".",".","1","9","5",".",".","."]<br>
 * ,[".","9","8",".",".",".",".","6","."]<br>
 * ,["8",".",".",".","6",".",".",".","3"]<br>
 * ,["4",".",".","8",".","3",".",".","1"]<br>
 * ,["7",".",".",".","2",".",".",".","6"]<br>
 * ,[".","6",".",".",".",".","2","8","."]<br>
 * ,[".",".",".","4","1","9",".",".","5"]<br>
 * ,[".",".",".",".","8",".",".","7","9"]]<br>
 * Output: false<br>
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.<br>
 * <br>
 * Constraints:<br>
 * board.length == 9<br>
 * board[i].length == 9<br>
 * board[i][j] is a digit 1-9 or '.'.<br>
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9], cols = new int[9][9], square = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int pos = board[i][j] - '1';
                int idx = i / 3 * 3 + j / 3;
                if (rows[i][pos] > 0 || cols[j][pos] > 0 || square[idx][pos] > 0) return false;
                rows[i][pos]++;
                cols[j][pos]++;
                square[idx][pos]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new Solution().isValidSudoku(board));
    }

}
