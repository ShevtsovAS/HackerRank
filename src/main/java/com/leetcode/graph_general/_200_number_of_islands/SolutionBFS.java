package com.leetcode.graph_general._200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

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
public class SolutionBFS extends Solution {
    Queue<int[]> queue = new LinkedList<>();
    int[] rowDirection = new int[]{-1, 0, 1, 0};
    int[] colDirection = new int[]{0, 1, 0, -1};

    private void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = position[0] + rowDirection[k];
                int y = position[1] + colDirection[k];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    @Override
    protected void graphSearch(char[][] grid, int i, int j) {
        bfs(grid, i, j);
    }
}
