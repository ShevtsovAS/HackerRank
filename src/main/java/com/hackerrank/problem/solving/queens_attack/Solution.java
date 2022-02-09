package com.hackerrank.problem.solving.queens_attack;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

final class Point {
    private final int row;
    private final int col;

    private Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Point of(int row, int col) {
        return new Point(row, col);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}

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

    public static int queensAttack(Point queen, List<Point> obstacles, int size) {
        return IntStream.of(
                attack(bottomOf(queen), rowDiff(queen), obstacles, bottomSquares(queen)),
                attack(bottomLeftOf(queen), rowDiff(queen), obstacles, bottomLeftSquares(queen)),
                attack(leftOf(queen), colDiff(queen), obstacles, leftSquares(queen)),
                attack(topLeftOf(queen), rowDiff(queen), obstacles, topLeftSquares(queen, size)),
                attack(topOf(queen), rowDiff(queen), obstacles, topSquares(queen, size)),
                attack(topRightOf(queen), rowDiff(queen), obstacles, topRightSquares(queen, size)),
                attack(rightOf(queen), colDiff(queen), obstacles, rightSquares(queen, size)),
                attack(bottomRightOf(queen), rowDiff(queen), obstacles, bottomRightSquares(queen, size))
        ).sum();
    }

    private static int attack(Predicate<Point> filter, ToIntFunction<Point> action, List<Point> obstacles, IntSupplier otherAction) {
        return obstacles.stream()
                .filter(filter)
                .mapToInt(action).min()
                .orElseGet(otherAction);
    }

    private static IntSupplier bottomRightSquares(Point queen, int size) {
        return () -> Math.min(diff(queen.getCol(), size), diff(queen.getRow(), 1));
    }

    private static IntSupplier rightSquares(Point queen, int size) {
        return () -> diff(queen.getCol(), size);
    }

    private static IntSupplier topRightSquares(Point queen, int size) {
        return () -> Math.min(diff(queen.getRow(), size), diff(queen.getCol(), size));
    }

    private static IntSupplier topSquares(Point queen, int size) {
        return () -> diff(queen.getRow(), size);
    }

    private static IntSupplier topLeftSquares(Point queen, int size) {
        return () -> Math.min(diff(queen.getCol(), 1), diff(queen.getRow(), size));
    }

    private static IntSupplier leftSquares(Point queen) {
        return () -> diff(queen.getCol(), 1);
    }

    private static IntSupplier bottomLeftSquares(Point queen) {
        return () -> Math.min(diff(queen.getRow(), 1), diff(queen.getCol(), 1));
    }

    private static IntSupplier bottomSquares(Point queen) {
        return () -> diff(queen.getRow(), 1);
    }

    private static Predicate<Point> bottomRightOf(Point point) {
        return oPoint -> oPoint.getRow() < point.getRow() && oPoint.getCol() > point.getCol() && isSameDiagonal(point, oPoint);
    }

    private static Predicate<Point> rightOf(Point point) {
        return oPoint -> oPoint.getRow() == point.getRow() && oPoint.getCol() > point.getCol();
    }

    private static Predicate<Point> topRightOf(Point point) {
        return oPoint -> oPoint.getRow() > point.getRow() && oPoint.getCol() > point.getCol() && isSameDiagonal(point, oPoint);
    }

    private static Predicate<Point> topOf(Point point) {
        return oPoint -> oPoint.getCol() == point.getCol() && oPoint.getRow() > point.getRow();
    }

    private static Predicate<Point> topLeftOf(Point point) {
        return oPoint -> oPoint.getRow() > point.getRow() && oPoint.getCol() < point.getCol() && isSameDiagonal(point, oPoint);
    }

    private static Predicate<Point> leftOf(Point point) {
        return oPoint -> oPoint.getRow() == point.getRow() && oPoint.getCol() < point.getCol();
    }

    private static Predicate<Point> bottomLeftOf(Point point) {
        return oPoint -> oPoint.getRow() < point.getRow() && oPoint.getCol() < point.getCol() && isSameDiagonal(point, oPoint);
    }

    private static Predicate<Point> bottomOf(Point point) {
        return o -> o.getCol() == point.getCol() && o.getRow() < point.getRow();
    }

    private static boolean isSameDiagonal(Point p1, Point p2) {
        return diff(p1.getRow(), p2.getRow()) == diff(p1.getCol(), p2.getCol());
    }

    private static ToIntFunction<Point> rowDiff(Point point) {
        return oPoint -> diff(point.getRow(), oPoint.getRow()) - 1;
    }

    private static ToIntFunction<Point> colDiff(Point point) {
        return oPoint -> diff(point.getCol(), oPoint.getCol()) - 1;
    }

    private static int diff(int n1, int n2) {
        return Math.abs(n1 - n2);
    }

}

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.queensAttack(Point.of(4, 3), List.of(Point.of(5, 5), Point.of(4, 2), Point.of(2, 3)), 5));
        System.out.println(Result.queensAttack(Point.of(1, 1), Collections.emptyList(), 1));
    }
}
