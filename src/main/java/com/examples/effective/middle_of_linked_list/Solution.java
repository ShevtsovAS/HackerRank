package com.examples.effective.middle_of_linked_list;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");

        Iterator<String> iterator = list.iterator();
        Iterator<String> middleIterator = list.iterator();
        int length = 0;
        String middle = null;
        while (iterator.hasNext()) {
            length++;
            if (length % 2 == 0) {
                middle = middleIterator.next();
            }
            iterator.next();
        }
        if (length % 2 == 1) {
            middle = middleIterator.next();
        }

        System.out.println(middle);
    }
}
