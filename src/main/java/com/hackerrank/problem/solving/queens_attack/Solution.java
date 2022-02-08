package com.hackerrank.problem.solving.queens_attack;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int size, int row, int col, List<List<Integer>> obstacles) {
        // Write your code here
        Set<Long> obstaclePoints = obstacles.stream().map(Result::getObstaclePoint).collect(toSet());
        return Arrays.stream(getDirs()).mapToInt(dir -> tryAttack(dir, row, col, size, obstaclePoints)).sum();
    }

    private static long getObstaclePoint(List<Integer> obstacle) {
        return getPoint(obstacle.get(0), obstacle.get(1));
    }

    private static long getPoint(int row, int col) {
        return (long) row << 32 | col;
    }

    private static int tryAttack(int[] d, int row, int col, int size, Set<Long> obstacles) {
        int res = 0;
        while (canAttack(row += d[0], col += d[1], size, obstacles)) {
            res++;
        }
        return res;
    }

    private static int[][] getDirs() {
        return new int[][]{{-1, -1}, {-1, 0}, {-1, +1}, {0, -1}, {0, +1}, {+1, -1}, {+1, 0}, {+1, +1}};
    }

    private static boolean canAttack(int row, int col, int size, Set<Long> obstacles) {
        long point = getPoint(row, col);
        return fit(row, size) && fit(col, size) && canAttackPoint(obstacles, point);
    }

    private static boolean canAttackPoint(Set<Long> obstacles, long point) {
        return !obstacles.contains(point);
    }

    private static boolean fit(int n, int high) {
        return n >= 1 && n <= high;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.queensAttack(5, 4, 3, List.of(List.of(5, 5), List.of(4, 2), List.of(2, 3))));
    }
}
