package com.hackerrank.problem.solving.counting_valleys;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int seaLevel = 0;
        int valleys = 0;
        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            if (step == 'D') {
                if (seaLevel == 0) {
                    valleys++;
                }
                seaLevel--;
            } else if (step == 'U') {
                seaLevel++;
            }
        }
        return valleys;
    }

}

public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.countingValleys(8, "UDDDUDUU"));
        System.out.println(Result.countingValleys(12, "DDUUDDUDUUUD"));
    }
}
