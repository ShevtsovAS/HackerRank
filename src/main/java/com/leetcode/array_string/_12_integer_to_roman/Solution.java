package com.leetcode.array_string._12_integer_to_roman;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>12. Integer to Roman</h1>
 * Seven different symbols represent Roman numerals with the following values:<br>
 * <br>
 * Symbol	Value<br>
 * I	1<br>
 * V	5<br>
 * X	10<br>
 * L	50<br>
 * C	100<br>
 * D	500<br>
 * M	1000<br>
 * Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:<br>
 * <br>
 * If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.<br>
 * If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).<br>
 * Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.<br>
 * Given an integer, convert it to a Roman numeral.<br>
 * <br>
 * Example 1:<br>
 * Input: num = 3749<br>
 * <br>
 * Output: "MMMDCCXLIX"<br>
 * <br>
 * Explanation:<br>
 * <br>
 * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)<br>
 * 700 = DCC as 500 (D) + 100 (C) + 100 (C)<br>
 * 40 = XL as 10 (X) less of 50 (L)<br>
 * 9 = IX as 1 (I) less of 10 (X)<br>
 * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places<br>
 * <br>
 * Example 2:<br>
 * Input: num = 58<br>
 * <br>
 * Output: "LVIII"<br>
 * <br>
 * Explanation:<br>
 * <br>
 * 50 = L<br>
 * 8 = VIII<br>
 * <br>
 * Example 3:<br>
 * Input: num = 1994<br>
 * <br>
 * Output: "MCMXCIV"<br>
 * <br>
 * Explanation:<br>
 * <br>
 * 1000 = M<br>
 * 900 = CM<br>
 * 90 = XC<br>
 * 4 = IV<br>
 * <br>
 * Constraints:<br>
 * 1 <= num <= 3999<br>
 */
public class Solution {

    private final Map<Integer, String> romans = new HashMap<>();
    {
        romans.put(1, "I");
        romans.put(2, "II");
        romans.put(3, "III");
        romans.put(4, "IV");
        romans.put(5, "V");
        romans.put(6, "VI");
        romans.put(7, "VII");
        romans.put(8, "VIII");
        romans.put(9, "IX");
        romans.put(10, "X");
        romans.put(20, "XX");
        romans.put(30, "XXX");
        romans.put(40, "XL");
        romans.put(50, "L");
        romans.put(60, "LX");
        romans.put(70, "LXX");
        romans.put(80, "LXXX");
        romans.put(90, "XC");
        romans.put(100, "C");
        romans.put(200, "CC");
        romans.put(300, "CCC");
        romans.put(400, "CD");
        romans.put(500, "D");
        romans.put(600, "DC");
        romans.put(700, "DCC");
        romans.put(800, "DCCC");
        romans.put(900, "CM");
        romans.put(1000, "M");
        romans.put(2000, "MM");
        romans.put(3000, "MMM");
    }

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int mul = 1;
        do  {
            int digit = num % 10;
            digit *= mul;
            mul *= 10;
            if (digit > 0) builder.insert(0, romans.get(digit));

        } while ((num /= 10) > 0);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1001));
    }

}
