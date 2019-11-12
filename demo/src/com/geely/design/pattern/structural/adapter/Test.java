package com.geely.design.pattern.structural.adapter;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        DC5 dc5        = new PowerAdapter();
        int outputDC5V = dc5.outputDC5V();
        System.out.println(outputDC5V);
        DC5 dc51 = new Dc5Impl();
        int dc5V = dc51.outputDC5V();
        System.out.println(dc5V);
    }
}
