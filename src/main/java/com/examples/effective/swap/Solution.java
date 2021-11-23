package com.examples.effective.swap;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("1", "2"));
        new Solution().swap(list);
        System.out.println(list);
    }

    public <T> void swap(List<T> list) {
        list.set(0, list.get(1));
    }

    // Does not compile!
//    public void swap(List<?> list) {
//        list.set(0, list.get(1));
//    }
}
