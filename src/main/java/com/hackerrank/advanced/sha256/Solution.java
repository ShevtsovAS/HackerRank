package com.hackerrank.advanced.sha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha256.digest(s.getBytes(StandardCharsets.UTF_8));
        System.out.println(bytesToHex(hash));
    }

    private static String bytesToHex(byte[] hash) {
        return IntStream.range(0, hash.length)
                .map(i -> hash[i])
                .map(n -> 0xff & n)
                .mapToObj(Integer::toHexString)
                .map(s -> s.length() == 1 ? '0' + s : s)
                .collect(joining());
    }
}
