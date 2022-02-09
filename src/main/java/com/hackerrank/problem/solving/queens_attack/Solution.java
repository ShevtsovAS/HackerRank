package com.hackerrank.problem.solving.queens_attack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class Point {
    private static final int START = 1;

    private final int row;
    private final int col;

    private Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Point of(int row, int col) {
        return new Point(row, col);
    }

    public boolean leftBottomFrom(Point point) {
        return row < point.row && col < point.col && isSameDiagonal(point);
    }

    public boolean leftFrom(Point point) {
        return row == point.row && col < point.col;
    }

    public boolean leftTopFrom(Point point) {
        return row > point.row && col < point.col && isSameDiagonal(point);
    }

    public boolean topFrom(Point point) {
        return col == point.col && row > point.row;
    }

    public boolean rightTopFrom(Point point) {
        return row > point.row && col > point.col && isSameDiagonal(point);
    }

    public boolean rightFrom(Point point) {
        return row == point.row && col > point.col;
    }

    public boolean rightBottomFrom(Point point) {
        return row < point.row && col > point.col && isSameDiagonal(point);
    }

    public boolean bottomFrom(Point point) {
        return col == point.col && row < point.row;
    }

    public int leftBottomSquares() {
        return Math.min(diff(row, START), diff(col, START));
    }

    public int leftSquares() {
        return diff(col, START);
    }

    public int leftTopSquares(int size) {
        return Math.min(diff(col, START), diff(row, size));
    }

    public int topSquares(int size) {
        return diff(row, size);
    }

    public int rightTopSquares(int size) {
        return Math.min(diff(row, size), diff(col, size));
    }

    public int rightSquares(int size) {
        return diff(col, size);
    }

    public int rightBottomSquares(int size) {
        return Math.min(diff(col, size), diff(row, START));
    }

    public int bottomSquares() {
        return diff(row, START);
    }

    public int rowDiff(Point point) {
        return diff(row, point.row) - START;
    }

    public int colDiff(Point point) {
        return diff(col, point.col) - START;
    }

    private boolean isSameDiagonal(Point point) {
        return rowDiff(point) == colDiff(point);
    }

    private int diff(int n1, int n2) {
        return Math.abs(n1 - n2);
    }
}

class Result {

    private static final int LEFT_BOTTOM = 0;
    private static final int LEFT = 1;
    private static final int LEFT_TOP = 2;
    private static final int TOP = 3;
    private static final int RIGHT_TOP = 4;
    private static final int RIGHT = 5;
    private static final int RIGHT_BOTTOM = 6;
    private static final int BOTTOM = 7;

    public static int queensAttack(Point queen, List<Point> obstacles, int size) {
        int[] squares = new int[8];
        squares[LEFT_BOTTOM] = queen.leftBottomSquares();
        squares[LEFT] = queen.leftSquares();
        squares[LEFT_TOP] = queen.leftTopSquares(size);
        squares[TOP] = queen.topSquares(size);
        squares[RIGHT_TOP] = queen.rightTopSquares(size);
        squares[RIGHT] = queen.rightSquares(size);
        squares[RIGHT_BOTTOM] = queen.rightBottomSquares(size);
        squares[BOTTOM] = queen.bottomSquares();
        for (Point obstacle : obstacles) {
            if (obstacle.leftBottomFrom(queen)) {
                squares[LEFT_BOTTOM] = Math.min(squares[LEFT_BOTTOM], obstacle.rowDiff(queen));
            } else if (obstacle.leftFrom(queen)) {
                squares[LEFT] = Math.min(squares[LEFT], obstacle.colDiff(queen));
            } else if (obstacle.leftTopFrom(queen)) {
                squares[LEFT_TOP] = Math.min(squares[LEFT_TOP], obstacle.rowDiff(queen));
            } else if (obstacle.topFrom(queen)) {
                squares[TOP] = Math.min(squares[TOP], obstacle.rowDiff(queen));
            } else if (obstacle.rightTopFrom(queen)) {
                squares[RIGHT_TOP] = Math.min(squares[RIGHT_TOP], obstacle.rowDiff(queen));
            } else if (obstacle.rightFrom(queen)) {
                squares[RIGHT] = Math.min(squares[RIGHT], obstacle.colDiff(queen));
            } else if (obstacle.rightBottomFrom(queen)) {
                squares[RIGHT_BOTTOM] = Math.min(squares[RIGHT_BOTTOM], obstacle.rowDiff(queen));
            } else if (obstacle.bottomFrom(queen)) {
                squares[BOTTOM] = Math.min(squares[BOTTOM], obstacle.rowDiff(queen));
            }
        }
        return Arrays.stream(squares).sum();
    }
}

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.queensAttack(Point.of(4, 3), List.of(Point.of(5, 5), Point.of(4, 2), Point.of(2, 3)), 5));
        System.out.println(Result.queensAttack(Point.of(1, 1), Collections.emptyList(), 1));
    }
}
