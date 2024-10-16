package com.leetcode.graph_bfs._909_snakes_and_ladders;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150">909. Snakes and Ladders</a>
 */
public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length * board.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int moves = current[1];
            if (position == n) return moves;
            for (int i = 1; i <= 6 && position + i <= n ; i++) {
                int nextPosition = getPosition(board, position + i);
                if (nextPosition == 0) continue;
                queue.offer(new int[]{nextPosition, moves + 1});
            }
        }
        return -1;
    }

    private int getPosition(int[][] board, int num) {
        int n = board.length;
        int i = (num - 1) / n;
        int j = (num - 1) % n;
        if (i % 2 == 1) {
            j = n - 1 - j;
        }
        i = n - 1 - i;
        int position = board[i][j];
        board[i][j] = 0;
        return position == -1 ? num : position;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        System.out.println(new Solution().snakesAndLadders(board));
    }
}
