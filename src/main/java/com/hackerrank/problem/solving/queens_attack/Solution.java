package com.hackerrank.problem.solving.queens_attack;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public static int queensAttack(int size, int qRow, int qCol, List<List<Integer>> obstacles) {
        // Write your code here
        int b = obstacles.stream()
                .filter(o -> o.get(1) == qCol && o.get(0) < qRow)
                .mapToInt(o -> Math.abs(qRow - o.get(0) - 1)).min()
                .orElse(Math.abs(qRow - 1));
        int bl = obstacles.stream()
                .filter(o -> qRow - o.get(0) == qCol - o.get(1) && o.get(0) < qRow && o.get(1) < qCol)
                .mapToInt(o -> qRow - o.get(0) - 1).min()
                .orElse(Math.min(Math.abs(qRow - 1), Math.abs(qCol - 1)));
        int l = obstacles.stream()
                .filter(o -> o.get(0) == qRow && o.get(1) < qCol)
                .mapToInt(o -> Math.abs(qCol - o.get(1) - 1)).min()
                .orElse(Math.abs(qCol - 1));
        int tl = obstacles.stream()
                .filter(o -> o.get(0) - qRow == qCol - o.get(1) && o.get(0) > qRow && o.get(1) < qCol)
                .mapToInt(o -> o.get(0) - qRow - 1).min()
                .orElse(Math.min(Math.abs(qCol - 1), Math.abs(qRow - size)));
        int t = obstacles.stream()
                .filter(o -> o.get(1) == qCol && o.get(0) > qRow)
                .mapToInt(o -> Math.abs(o.get(0) - qRow - 1)).min()
                .orElse(Math.abs(qRow - size));
        int tr = obstacles.stream()
                .filter(o -> o.get(0) - qRow == o.get(1) - qCol && o.get(0) > qRow && o.get(1) > qCol)
                .mapToInt(o -> o.get(0) - qRow - 1).min()
                .orElse(Math.min(Math.abs(qRow - size), Math.abs(qCol - size)));
        int r = obstacles.stream()
                .filter(o -> o.get(0) == qRow && o.get(1) > qCol)
                .mapToInt(o -> Math.abs(o.get(1) - qCol - 1)).min()
                .orElse(Math.abs(qCol - size));
        int br = obstacles.stream()
                .filter(o -> qRow - o.get(0) == o.get(1) - qCol && o.get(0) < qRow && o.get(1) > qCol)
                .mapToInt(o -> qRow - o.get(0) - 1).min()
                .orElse(Math.min(Math.abs(qCol - size), Math.abs(qRow - 1)));
        return IntStream.of(b, bl, l, tl, t, tr, r, br).sum();
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.queensAttack(5, 4, 3, List.of(List.of(5, 5), List.of(4, 2), List.of(2, 3))));
    }
}
