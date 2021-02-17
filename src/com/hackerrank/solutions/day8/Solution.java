package com.hackerrank.solutions.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Solution {
    public static void main(String []argh){
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            Integer phone = phoneBook.get(s);
            if (phone != null) {
                System.out.printf("%s=%s%n", s, phone);
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
