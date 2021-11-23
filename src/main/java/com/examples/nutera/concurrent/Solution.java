package com.examples.nutera.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    private String global;
    private final AtomicBoolean done = new AtomicBoolean(false);
    private final Object lock = new Object();

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            new Thread(solution::doItOnce).start();
            new Thread(solution::getGlobal).start();
        }
    }

    public void doItOnce() {
        if (done.getAndSet(true)) {
            System.out.println(Thread.currentThread().getName() + " is exiting doItOnce...");
            return;
        }
        System.out.println(Thread.currentThread().getName() + " is going in doItOnce...");
        synchronized (lock) {
            global = "Instantiated!";
            System.out.println(Thread.currentThread().getName() + " instantiated global var");
            lock.notifyAll();
        }
    }

    public String getGlobal() {
        synchronized (lock) {
            while (global == null) {
                System.out.println(Thread.currentThread().getName() + " is waiting global var...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " is returning global var as " + global);
        return global;
    }
}
