package com.hackerrank.problem.solving.disigner_pdf_viewer;

import java.util.List;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        return word.chars().map(ch -> ch - 'a').map(h::get).max().orElse(0) * word.length();
    }

}

//https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
public class Solution {
    public static void main(String[] args) {
        System.out.println(Result.designerPdfViewer(List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5), "abc"));
        System.out.println(Result.designerPdfViewer(List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7), "zaba"));
    }
}
