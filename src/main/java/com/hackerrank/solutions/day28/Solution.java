package com.hackerrank.solutions.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Email {
    private final String name;
    private final String emailID;

    public Email(String name, String emailID) {
        this.name = name;
        this.emailID = emailID;
    }

    public String getName() {
        return name;
    }

    public String getEmailID() {
        return emailID;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Email> emails = new ArrayList<>();
        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];

                emails.add(new Email(firstName, emailID));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        emails.stream()
                .filter(email -> email.getEmailID().toLowerCase().endsWith("@gmail.com"))
                .map(Email::getName)
                .sorted()
                .forEach(System.out::println);
    }
}
