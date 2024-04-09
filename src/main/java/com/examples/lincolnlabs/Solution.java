package com.examples.lincolnlabs;


import java.util.regex.Pattern;

/**
 * Написать метод formattedNumber проверяющий корректность числа, которое передаётся в виде строки
 * Число может быть разделено на запятые и одной точкой
 * Число до первой запятой может быть 1-3 символа, числа после каждой следующей должны быть из 3 символов
 * Число после точки может быть 1 и более символов
 */
public class Solution {

    private final static Pattern NUMBER_PATTERN = Pattern.compile("^\\d{1,3}(,\\d{3})*(\\.\\d+)?$");

    public static void main(String[] args) {
        String testNumber = "1,000,232.12345";
        System.out.println(regexSolution(testNumber));
        System.out.println(formattedNumber(testNumber));
    }

    public static boolean regexSolution(String number) {
        return NUMBER_PATTERN.matcher(number).matches();

    }

    public static boolean formattedNumber(String number) {
        if (number == null || number.isBlank()) {
            return false;
        }
        var splitByPointNumber = number.split("\\.", 2);
        return numberBeforePointIsCorrect(splitByPointNumber) && numberAfterPointIsCorrect(splitByPointNumber);
    }

    private static boolean numberAfterPointIsCorrect(String[] splitByPointNumber) {
        if (splitByPointNumber.length == 2) {
            try {
                Long.parseLong(splitByPointNumber[1]);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean numberBeforePointIsCorrect(String[] splitByPointNumber) {
        var number = splitByPointNumber[0];
        if (number.endsWith(",")) {
            return false;
        }

        var splitByComma = number.split(",");
        for (var i = 0; i < splitByComma.length; i++) {
            try {
                Long.parseLong(splitByComma[i]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (i == 0) {
                if (splitByComma[i].length() > 3) {
                    return false;
                }
            } else  {
                if (splitByComma[i].length() != 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
