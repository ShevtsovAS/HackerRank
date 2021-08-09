package com.hackerrank.solutions.effective.move_zeros_2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0, 0, 12, 9};
        moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {0};
        moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void moveZeroes(int[] nums) {
        int counterWithoutNulls = 0;
        int counterWithNulls = 0;
        int length = nums.length;
        while (counterWithNulls < length) {
            if (nums[counterWithNulls] == 0) {// находим нулевые элементы и увеличиваем счётчик
                counterWithNulls++;
            } else { // сдвигаем элементы на количество найденных нулевых элементов слева
                nums[counterWithoutNulls++] = nums[counterWithNulls++];
            }
        }
        while (counterWithoutNulls < length) {
            nums[counterWithoutNulls++] = 0;// заполняем последние элементы массива нулями согласно счётчику нулей
        }
    }
}
