package com.geely.jvm;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/21 7:39 下午
 * //必然导致栈溢出
 */
public class StackOverFlowDemo {
    public static void main(String[] args) {
        stackOverFlowErr();
    }
    public static void stackOverFlowErr(){
        stackOverFlowErr();
    }
}
