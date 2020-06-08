package com.ExceptionDemo;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/20 12:04 下午
 * @description
 */
public class AgeOutOfBound extends RuntimeException {

    public AgeOutOfBound() {
        System.out.print("Sorry,age out of bound !");
    }
}
