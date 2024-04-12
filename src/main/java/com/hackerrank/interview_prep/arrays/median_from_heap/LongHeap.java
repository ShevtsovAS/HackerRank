package com.hackerrank.interview_prep.arrays.median_from_heap;

import java.util.Collection;
import java.util.Comparator;

@SuppressWarnings("unused")
public class LongHeap extends Heap<Long> {

    public LongHeap() {
    }

    public LongHeap(Comparator<Long> comparator) {
        super(comparator);
    }

    public LongHeap(Collection<Long> list) {
        super(list);
    }

    public LongHeap(Collection<Long> list, Comparator<Long> comparator) {
        super(list, comparator);
    }

    @Override
    public Long getAvg(Long hValue, Long lValue) {
        return (hValue + lValue) >> 1;
    }
}
