package com.geely.design.pattern.creational.prototype.abstractprototype;

/**
 * Created by geely
 */
public class B extends A {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        B clone = (B) b.clone();
    }
}
