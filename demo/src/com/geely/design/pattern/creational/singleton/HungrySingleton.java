package com.geely.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * Created by geely
 */
public class HungrySingleton implements Serializable, Cloneable {
      //1
//    private final static HungrySingleton hungrySingleton;
//
//        static {
//        hungrySingleton = new HungrySingleton();
//    }
    //2
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
