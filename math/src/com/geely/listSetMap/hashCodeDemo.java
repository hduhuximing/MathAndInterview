package com.geely.listSetMap;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/4 9:09 下午
 */
public class hashCodeDemo {
    /**
     * 最底层的hashcode是Object类的，native方法
     * 返回对象的内存地址
     */
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.hashCode());
    }

}
