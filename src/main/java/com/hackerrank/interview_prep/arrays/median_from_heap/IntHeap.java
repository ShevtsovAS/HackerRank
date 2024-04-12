package com.hackerrank.interview_prep.arrays.median_from_heap;

import java.util.Collection;
import java.util.Comparator;

@SuppressWarnings("unused")
public class IntHeap extends Heap<Integer> {

    public IntHeap() {
    }

    public IntHeap(Comparator<Integer> comparator) {
        super(comparator);
    }

    public IntHeap(Collection<Integer> list) {
        super(list);
    }

    public IntHeap(Collection<Integer> list, Comparator<Integer> comparator) {
        super(list, comparator);
    }

    @Override
    public Integer getAvg(Integer hValue, Integer lValue) {
        return (hValue + lValue) >> 1;
    }
}
