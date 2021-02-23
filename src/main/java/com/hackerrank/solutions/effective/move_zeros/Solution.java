package com.hackerrank.solutions.effective.move_zeros;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = getNumbers();
        int direction = getDirection();
        if (direction == 1) {
            moveZerosToStart(numbers);
        } else {
            moveZerosToEnd(numbers);
        }
        print(numbers);
        scanner.close();
    }

    private static void moveZerosToStart(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            if (current == 0) {
                shiftArrayFwd(numbers, i);
                numbers[0] = current;
            }
        }
    }

    private static void moveZerosToEnd(int[] numbers) {
        for (int endPosition = numbers.length - 1, i = endPosition; i >= 0; i--) {
            int current = numbers[i];
            if (current == 0) {
                shiftArrayBack(numbers, i + 1);
                numbers[endPosition] = current;
            }
        }
    }

    private static void shiftArrayFwd(int[] array, int length) {
//        for (int i = length; i > 0; i--) {
//            array[i] = array[i - 1];
//        }
        System.arraycopy(array, 0, array, 1, length);
    }

    private static void shiftArrayBack(int[] array, int position) {
//        for (int i = position; i < array.length; i++) {
//            array[i - 1] = array[i];
//        }
        System.arraycopy(array, position, array, position - 1, array.length - position);
    }

    private static int[] getNumbers() {
        System.out.print("Введите числа через пробел: ");
        String userInput = scanner.nextLine();
        return Arrays.stream(userInput.split("\\s"))
                .map(Integer::parseInt)
                .mapToInt(it -> it)
                .toArray();
    }

    private static int getDirection() {
        System.out.print("Выберите направление (1 - назад, 2 - вперёд): ");
        return scanner.nextInt();
    }

    private static void print(int[] numbers) {
        String resultString = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(resultString);
    }
}
