package com.leetcode.graph_general._200_number_of_islands;

public abstract class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    graphSearch(grid, i, j);
                }
            }
        }
        return count;
    }

    protected abstract void graphSearch(char[][] grid, int i, int j);
}
