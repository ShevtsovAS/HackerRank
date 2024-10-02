package com.leetcode.graph_general._200_number_of_islands;

/**
 * <h1>200. Number of Islands</h1>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.<br>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.<br>
 * <br>
 * Example 1:<br>
 * Input: grid = [<br>
 * ["1","1","1","1","0"],<br>
 * ["1","1","0","1","0"],<br>
 * ["1","1","0","0","0"],<br>
 * ["0","0","0","0","0"]<br>
 * ]<br>
 * Output: 1<br>
 * <br>
 * Example 2:<br>
 * Input: grid = [<br>
 * ["1","1","0","0","0"],<br>
 * ["1","1","0","0","0"],<br>
 * ["0","0","1","0","0"],<br>
 * ["0","0","0","1","1"]<br>
 * ]<br>
 * Output: 3<br>
 * <br>
 * Constraints:<br>
 * m == grid.length<br>
 * n == grid[i].length<br>
 * 1 <= m, n <= 300<br>
 * grid[i][j] is '0' or '1'.<br>
 */
public class SolutionDFS extends Solution {

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

    @Override
    protected void graphSearch(char[][] grid, int i, int j) {
        dfs(grid, i, j);
    }
}
