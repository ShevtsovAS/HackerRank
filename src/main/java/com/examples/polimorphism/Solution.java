package com.examples.polimorphism;

public class Solution {
    public static void main(String[] args) {
        Parent child = new Child();
        ChildReceiver childReceiver = new ChildReceiver();
        childReceiver.receive(child);
    }
}

class Parent {
    public int a = 3;

    public void outMe() {
        System.out.println("Parent");
    }

    public void printA() {
        System.out.println(a);
    }
}

class Child extends Parent {
    public int a = 2;

    public void outMe() {
        System.out.println("Child");
    }

    public void printA() {
        System.out.println(a);
    }
}

class ParentReceiver {
    public void receive(Parent p) {
        System.out.println("ParentReceiver");
        p.outMe();
        System.out.println(p.a);
        p.printA();
    }
}

class ChildReceiver extends ParentReceiver {
    public void receive(Child c) {
        System.out.println("ChildReceiver");
        c.outMe();
        System.out.println(c.a);
        c.printA();
    }
}