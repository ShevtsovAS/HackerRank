package com.hackerrank.solutions.day12;

import java.util.Arrays;

public class Student extends Person {

    private final int[] testScores;

    Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }

    public char calculate() {
        int avg = (int) Arrays.stream(testScores).average().orElse(-1);
        return Grade.getFromAvg(avg);
    }


    private enum Grade {
        GRADE_O('O', 90, 100),
        GRADE_E('E', 80, 89),
        GRADE_A('A', 70, 79),
        GRADE_P('P', 55, 69),
        GRADE_D('D', 40, 55),
        GRADE_T('T', 0, 39);

        private final char avgGrade;
        private final int min;
        private final int max;

        Grade(char avgGrade, int min, int max) {
            this.avgGrade = avgGrade;
            this.min = min;
            this.max = max;
        }

        public char getAvgGrade() {
            return avgGrade;
        }

        public static char getFromAvg(int avg) {
            return Arrays.stream(values())
                    .filter(grade -> avg >= grade.min && avg <= grade.max)
                    .findFirst()
                    .map(Grade::getAvgGrade)
                    .orElseThrow(() -> new IllegalArgumentException("value must be between 0 and 100"));
        }

    }

}
