package com.hackerrank.problem.solving.magic_squre_forming;

import java.util.List;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int[][] square = s.stream().map(integers -> integers.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        int[][] magicSquare = generateMagicSquare(s.size());
        int[][] rotated = getRotated(magicSquare);
        List<int[][]> magicSquares = List.of(
                magicSquare,
                getSideMirror(magicSquare),
                getTopBottomMirror(magicSquare),
                getDiagonalMirror(magicSquare),
                rotated,
                getSideMirror(rotated),
                getTopBottomMirror(rotated),
                getDiagonalMirror(rotated)
        );
        return magicSquares.stream()
                .mapToInt(ms -> getDifference(ms, square))
                .min()
                .orElse(0);
    }

    private static int getDifference(int[][] s1, int[][] s2) {
        int n = s1.length;
        int dif = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dif += Math.abs(s1[i][j] - s2[i][j]);
            }
        }

        return dif;
    }

    private static int[][] getDiagonalMirror(int[][] square) {
        int[][] result = new int[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                result[square.length - 1 - i][square.length - 1 - j] = square[i][j];
            }
        }
        return result;
    }

    private static int[][] getTopBottomMirror(int[][] square) {
        int[][] result = new int[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            System.arraycopy(square[i], 0, result[square.length - 1 - i], 0, square.length);
        }
        return result;
    }

    private static int[][] getSideMirror(int[][] square) {
        int[][] result = new int[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                result[i][j] = square[i][square.length - 1 - j];
            }
        }
        return result;
    }

    private static int[][] getRotated(int[][] square) {
        int[][] res = new int[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                res[res.length - 1 - j][i] = square[i][j];
            }
        }
        return res;
    }

    private static int[][] generateMagicSquare(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0, row = i + n / 2, col = i - n / 2; j < n; j++, row--, col++) {
                result[(n + row) % n][(n + col) % n] = num++;
            }
        }

        return result;
    }

}

//https://www.hackerrank.com/challenges/magic-square-forming/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.formingMagicSquare(List.of(
                List.of(5, 3, 4),
                List.of(1, 5, 8),
                List.of(6, 4, 2)
        )));
        System.out.println(Result.formingMagicSquare(List.of(
                List.of(4, 9, 2),
                List.of(3, 5, 7),
                List.of(8, 1, 5)
        )));
        System.out.println(Result.formingMagicSquare(List.of(
                List.of(4, 8, 2),
                List.of(4, 5, 7),
                List.of(6, 1, 6)
        )));
    }
}
