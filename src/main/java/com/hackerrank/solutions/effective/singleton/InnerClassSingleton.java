package com.hackerrank.solutions.effective.singleton;

public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    public static class SingletonHolder {
        public static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
