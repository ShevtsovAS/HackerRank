package com.hackerrank.problem.solving.queens_attack;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
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
                .filter(isBottomRightObstacle(qRow, qCol))
                .mapToInt(rowDiff(qRow)).min()
                .orElse(Math.min(diff(qCol, size), diff(qRow, 1)));
    }

    private static Predicate<List<Integer>> isBottomRightObstacle(int qRow, int qCol) {
        return o -> o.get(0) < qRow && o.get(1) > qCol && isSameDiagonal(qRow, qCol, o);
    }

    private static int rightAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isRightObstacle(qRow, qCol))
                .mapToInt(colDiff(qCol)).min()
                .orElse(diff(qCol, size));
    }

    private static Predicate<List<Integer>> isRightObstacle(int qRow, int qCol) {
        return o -> o.get(0) == qRow && o.get(1) > qCol;
    }

    private static int topRightAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isTopRightObstacle(qRow, qCol))
                .mapToInt(rowDiff(qRow)).min()
                .orElse(Math.min(diff(qRow, size), diff(qCol, size)));
    }

    private static Predicate<List<Integer>> isTopRightObstacle(int qRow, int qCol) {
        return o -> o.get(0) > qRow && o.get(1) > qCol && isSameDiagonal(qRow, qCol, o);
    }

    private static int topAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isTopObstacle(qRow, qCol))
                .mapToInt(rowDiff(qRow)).min()
                .orElse(diff(qRow, size));
    }

    private static Predicate<List<Integer>> isTopObstacle(int qRow, int qCol) {
        return o -> o.get(1) == qCol && o.get(0) > qRow;
    }

    private static int topLeftAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isTopLeftObstacle(qRow, qCol))
                .mapToInt(rowDiff(qRow)).min()
                .orElse(Math.min(diff(qCol, 1), diff(qRow, size)));
    }

    private static Predicate<List<Integer>> isTopLeftObstacle(int qRow, int qCol) {
        return o -> o.get(0) > qRow && o.get(1) < qCol && isSameDiagonal(qRow, qCol, o);
    }

    private static int leftAttack(int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isLeftObstacle(qRow, qCol))
                .mapToInt(colDiff(qCol)).min()
                .orElse(diff(qCol, 1));
    }

    private static Predicate<List<Integer>> isLeftObstacle(int qRow, int qCol) {
        return o -> o.get(0) == qRow && o.get(1) < qCol;
    }

    private static int bottomLeftAttack(int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isBottomLeftObstacle(qRow, qCol))
                .mapToInt(rowDiff(qRow)).min()
                .orElse(Math.min(diff(qRow, 1), diff(qCol, 1)));
    }

    private static Predicate<List<Integer>> isBottomLeftObstacle(int qRow, int qCol) {
        return o -> o.get(0) < qRow && o.get(1) < qCol && isSameDiagonal(qRow, qCol, o);
    }

    private static int bottomAttack(int qRow, int qCol, List<List<Integer>> obstacles) {
        return obstacles.stream()
                .filter(isBottomObstacle(qRow, qCol))
                .mapToInt(rowDiff(qRow)).min()
                .orElse(diff(qRow, 1));
    }

    private static Predicate<List<Integer>> isBottomObstacle(int qRow, int qCol) {
        return o -> o.get(1) == qCol && o.get(0) < qRow;
    }

    private static boolean isSameDiagonal(int qRow, int qCol, List<Integer> o) {
        return diff(qRow, o.get(0)) == diff(qCol, o.get(1));
    }

    private static int diff(int n1, int n2) {
        return Math.abs(n1 - n2);
    }

    private static ToIntFunction<List<Integer>> rowDiff(int row) {
        return o -> diff(row, o.get(0)) - 1;
    }

    private static ToIntFunction<List<Integer>> colDiff(int col) {
        return o -> diff(col, o.get(1)) - 1;
    }

}

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.queensAttack(5, 4, 3, List.of(List.of(5, 5), List.of(4, 2), List.of(2, 3))));
        System.out.println(Result.queensAttack(1, 1, 1, Collections.emptyList()));
    }
}
