package com.geely.design.pattern.structural.adapter;

/**
 * @author ming
 * @version 1.0
 * @date 2019/7/19 10:29
 */
public class Dc5Impl implements DC5 {
    @Override
    public int outputDC5V() {
        int Dc5 = 5;
        return Dc5;
    }
}
