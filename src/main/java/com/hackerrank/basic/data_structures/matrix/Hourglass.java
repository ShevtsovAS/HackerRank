package com.hackerrank.basic.data_structures.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Hourglass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int maxHourglass = Integer.MIN_VALUE;
        for (int i = 0; i + 2 < arr.size(); i++) {
            List<Integer> top = arr.get(i);
            List<Integer> neck = arr.get(i + 1);
            List<Integer> bottom = arr.get(i + 2);
            for (int j = 0; j + 2 < top.size(); j++) {
                int bottomSum = top.get(j) + top.get(j + 1) + top.get(j + 2);
                int neckSum = neck.get(j + 1);
                int topSum = bottom.get(j) + bottom.get(j + 1) + bottom.get(j + 2);
                int sum = topSum + neckSum + bottomSum;
                if (sum > maxHourglass) {
                    maxHourglass = sum;
                }
            }
        }
        System.out.println(maxHourglass);
    }
}
