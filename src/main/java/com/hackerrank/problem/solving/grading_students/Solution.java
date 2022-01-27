package com.hackerrank.problem.solving.grading_students;

import java.util.List;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        return grades.stream().map(Result::roundGrade).collect(toList());
    }

    private static int roundGrade(int grade) {
        if (grade < 38) {
            return grade;
        }

        int nextRound = grade;
        while (nextRound % 5 != 0) {
            nextRound++;
        }

        if (nextRound - grade < 3) {
            return nextRound;
        }

        return grade;
    }

}

//https://www.hackerrank.com/challenges/grading/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.gradingStudents(List.of(73, 67, 38, 33)));
    }
}
