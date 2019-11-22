package com.geely.jvm;

import java.util.Random;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/21 7:45 下午
 */
public class HeapExceptionDemo {
    public static void main(String[] args) {
        String str="aaa";
        while(true){
            str+=str+(new Random(1111)+new Random(2222).toString());
            str.intern();
           // `java.lang.OutOfMemoryError:Java heap space`
        }
    }
}
