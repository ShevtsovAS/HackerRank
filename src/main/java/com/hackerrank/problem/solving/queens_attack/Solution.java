package com.hackerrank.problem.solving.queens_attack;

import java.util.List;
import java.util.stream.IntStream;

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

    public static int queensAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        // Write your code here
        return IntStream.of(
                        bottomAttack(qRow, qCol, obstacles),
                        bottomLeftAttack(qRow, qCol, obstacles),
                        leftAttack(qRow, qCol, obstacles),
                        topLeftAttack(size, qRow, qCol, obstacles),
                        topAttack(size, qRow, qCol, obstacles),
                        topRightAttack(size, qRow, qCol, obstacles),
                        rightAttack(size, qRow, qCol, obstacles),
                        bottomRightAttack(size, qRow, qCol, obstacles))
                .sum();
    }

    private static int bottomRightAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> qRow - o.get(0) == o.get(1) - qCol && o.get(0) < qRow && o.get(1) > qCol)
                .mapToInt(o -> qRow - o.get(0) - 1).min()
                .orElse(Math.min(Math.abs(qCol - size), Math.abs(qRow - 1)));
    }

    private static int rightAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> o.get(0) == qRow && o.get(1) > qCol)
                .mapToInt(o -> Math.abs(o.get(1) - qCol - 1)).min()
                .orElse(Math.abs(qCol - size));
    }

    private static int topRightAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> o.get(0) - qRow == o.get(1) - qCol && o.get(0) > qRow && o.get(1) > qCol)
                .mapToInt(o -> o.get(0) - qRow - 1).min()
                .orElse(Math.min(Math.abs(qRow - size), Math.abs(qCol - size)));
    }

    private static int topAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> o.get(1) == qCol && o.get(0) > qRow)
                .mapToInt(o -> Math.abs(o.get(0) - qRow - 1)).min()
                .orElse(Math.abs(qRow - size));
    }

    private static int topLeftAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> o.get(0) - qRow == qCol - o.get(1) && o.get(0) > qRow && o.get(1) < qCol)
                .mapToInt(o -> o.get(0) - qRow - 1).min()
                .orElse(Math.min(Math.abs(qCol - 1), Math.abs(qRow - size)));
    }

    private static int leftAttack(int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> o.get(0) == qRow && o.get(1) < qCol)
                .mapToInt(o -> Math.abs(qCol - o.get(1) - 1)).min()
                .orElse(Math.abs(qCol - 1));
    }

    private static int bottomLeftAttack(int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> qRow - o.get(0) == qCol - o.get(1) && o.get(0) < qRow && o.get(1) < qCol)
                .mapToInt(o -> qRow - o.get(0) - 1).min()
                .orElse(Math.min(Math.abs(qRow - 1), Math.abs(qCol - 1)));
    }

    private static int bottomAttack(int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(o -> o.get(1) == qCol && o.get(0) < qRow)
                .mapToInt(o -> Math.abs(qRow - o.get(0) - 1)).min()
                .orElse(Math.abs(qRow - 1));
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.queensAttack(5, 4, 3, List.of(List.of(5, 5), List.of(4, 2), List.of(2, 3))));
    }
}
