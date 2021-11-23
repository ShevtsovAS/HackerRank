package com.examples.effective.singleton;

public enum EnumSingleton {
    INSTANCE;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}
