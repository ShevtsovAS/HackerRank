package com.leetcode.matrix._36_valid_sudoku;

/**
 * <h1>36. Valid Sudoku</h1>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:<br>
 *<br>
 * Each row must contain the digits 1-9 without repetition.<br>
 * Each column must contain the digits 1-9 without repetition.<br>
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.<br>
 * <br>
 * Note:<br>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.<br>
 * Only the filled cells need to be validated according to the mentioned rules.<br>
 *<br>
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
 *<br>
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
 *<br>
 * Constraints:<br>
 * board.length == 9<br>
 * board[i].length == 9<br>
 * board[i][j] is a digit 1-9 or '.'.<br>
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidSudokuLines(board) && isValidSudokuColumns(board) && isValidSudokuNines(board);
    }

    private boolean isValidSudokuNines(char[][] board) {
        for (int k = 0; k < board.length; k += 3) {
            for (int m = 0; m < board.length; m += 3) {
                int[] mem = new int[10];
                for (int i = k; i < k + 3; i++) {
                    for (int j = m; j < m + 3; j++) {
                        char c = board[i][j];
                        if (c != '.') {
                            if (mem[c - '0'] > 0) return false;
                            else mem[c - '0']++;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] mem = new int[board[i].length + 1];
            for (int j = 0; j < board[i].length; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (mem[c - '0'] > 0) return false;
                    else mem[c - '0']++;
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuLines(char[][] board) {
        for (char[] line : board) {
            int[] mem = new int[line.length + 1];
            for (char c : line) {
                if (c != '.') {
                    if (mem[c - '0'] > 0) return false;
                    else mem[c - '0']++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new Solution().isValidSudoku(board));
    }

}
