package com.hackerrank.basic.regex;

import java.util.Scanner;

class UsernameValidator {
    //The username consists of 8 to 30 characters inclusive.
    //The username can only contain alphanumeric characters and underscores (_).
    //The first character of the username must be an alphabetic character, i.e., either lowercase character [a-z] or uppercase character [A-Z].
    public static final String regularExpression = "\\p{Alpha}\\w{7,29}";
}

public class ValidateUsername {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches("\\p{Alpha}\\w{7,29}")) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
