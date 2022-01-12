package com.examples.effective.prime_numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) {
        long max;
        try (Scanner scanner = new Scanner(System.in)) {
            max = scanner.nextLong();
        }
        List<Long> primes = findPrimes(max);
        System.out.printf("Найленно %s простых числел из %s%n", primes.size(), max);
    }

    private static List<Long> findPrimes(long max) {
        List<Long> primes = new ArrayList<>(List.of(1L, 2L));
        if (max <= 0) {
            return Collections.emptyList();
        } else if (max == 1) {
            return Collections.singletonList(1L);
        } else if (max < 3) {
            return primes;
        }

        primes.forEach(System.out::println);

        long seed = 3;
        long limit = 1000;
        while (seed <= max) {
            List<Long> nums = getNums(seed, limit, max);
            findPrimes(primes, nums);
            seed += limit;
        }
        return primes;
    }

    private static List<Long> getNums(long seed, long limit, long max) {
        return Stream.iterate(seed, n -> n > 0 && n <= max, n -> n + 1)
                .limit(limit)
                .collect(toList());
    }

    private static void findPrimes(List<Long> primes, List<Long> nums) {
        for (int i = 1; i < primes.size() && !nums.isEmpty(); i++) {
            Long prime = primes.get(i);
            takePrimes(nums, primes, prime * prime);
            excludeNonPrimes(nums, prime);
        }
    }

    private static void excludeNonPrimes(List<Long> nums, Long prime) {
        if (nums.isEmpty()) {
            return;
        }
        for (int i = findFirstToExclude(nums, prime); i < nums.size(); i += prime) {
            if (nums.get(i) != 0) {
                nums.set(i, 0L);
            }
        }
    }

    private static int findFirstToExclude(List<Long> nums, Long prime) {
        for (int i = 0; i < nums.size(); i++) {
            long n = nums.get(i);
            if (n != 0 && n % prime == 0) {
                return i;
            }
        }
        return nums.size();
    }

    private static void takePrimes(List<Long> nums, List<Long> primes, long end) {
        while (end < 0 ? !nums.isEmpty() : !nums.isEmpty() && nums.get(0) < end) {
            Long n = nums.remove(0);
            if (n > 0) {
                primes.add(n);
                System.out.println(n);
            }
        }
    }
}
