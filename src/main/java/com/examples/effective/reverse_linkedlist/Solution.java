package com.examples.effective.reverse_linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("1", "2", "3", "4", "5"));
//        Collections.reverse(list);
        ListIterator<String> fwd = list.listIterator();
        ListIterator<String> rev = list.listIterator(list.size());
        for (int i = 0, mid = list.size() >> 1; i < mid; i++) {
            String tmp = fwd.next();
            fwd.set(rev.previous());
            rev.set(tmp);
        }
        System.out.println(list);
    }
}
