package com.hackerrank.interview_prep.arrays.median_from_heap;

import java.util.Collection;
import java.util.Comparator;

@SuppressWarnings("unused")
public class DoubleHeap extends Heap<Double> {

    public DoubleHeap() {
    }

    public DoubleHeap(Comparator<Double> comparator) {
        super(comparator);
    }

    public DoubleHeap(Collection<Double> list) {
        super(list);
    }

    public DoubleHeap(Collection<Double> list, Comparator<Double> comparator) {
        super(list, comparator);
    }

    @Override
    public Double getAvg(Double hValue, Double lValue) {
        return (hValue + lValue) / 2;
    }
}
