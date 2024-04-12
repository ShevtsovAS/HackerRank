package com.hackerrank.interview_prep.arrays.median_from_heap;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class Heap<T extends Comparable<T>> {

    protected final Comparator<T> comparator = Comparable::compareTo;
    protected final PriorityQueue<T> high;
    protected final PriorityQueue<T> low;

    public Heap() {
        this.high = new PriorityQueue<>();
        this.low = new PriorityQueue<>(comparator.reversed());
    }

    public Heap(Comparator<T> comparator) {
        this.high = new PriorityQueue<>(comparator);
        this.low = new PriorityQueue<>(comparator.reversed());
    }

    public Heap(Collection<T> list) {
        this.high = new PriorityQueue<>(comparator);
        this.low = new PriorityQueue<>(comparator.reversed());
        addAll(list);
    }

    public Heap(Collection<T> list, Comparator<T> comparator) {
        this.high = new PriorityQueue<>(comparator);
        this.low = new PriorityQueue<>(comparator.reversed());
        addAll(list);
    }

    public boolean add(T value) {
        if (value == null) {
            return false;
        }

        if (high.isEmpty() || value.compareTo(high.peek()) > 0) {
            high.add(value);
        } else {
            low.add(value);
        }

        if (high.size() > low.size()) {
            low.add(high.poll());
        } else if (low.size() > high.size()) {
            high.add(low.poll());
        }

        return true;
    }

    public void addAll(Collection<T> list) {
        list.forEach(this::add);
    }

    public boolean isEmpty() {
        return high.isEmpty() && low.isEmpty();
    }

    public T getMedian() {
        if (isEmpty()) {
            return null;
        }

        var lValue = low.peek();
        var hValue = high.peek();

        if (high.size() == low.size()) {
            return getAvg(hValue, lValue);
        }

        return low.size() > high.size() ? lValue : hValue;
    }

    public abstract T getAvg(T hValue, T lValue);
}

