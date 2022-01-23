package com.hackerrank.basic.singletone;

public class Singleton {

    public String str;
    private static final Singleton INSTANCE;

    static {
        INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        return INSTANCE;
    }

}
