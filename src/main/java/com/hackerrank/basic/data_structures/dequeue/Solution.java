package com.hackerrank.basic.data_structures.dequeue;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if (deque.size() == m) {
                if (set.size() > max) {
                    max = set.size();
                }
                int removed = deque.removeFirst();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }
        System.out.println(max);
    }
}
