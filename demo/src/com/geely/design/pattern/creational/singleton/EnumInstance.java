package com.geely.design.pattern.creational.singleton;

/**
 * Created by geely
 * 枚举类型直接创建，底层就是单利创建
 */
public enum EnumInstance {
    INSTANCE("实例化") {
        protected void printTest() {
            System.out.println("Geely Print Test");
        }
    };

    protected abstract void printTest();


    public static EnumInstance getInstance() {
        return INSTANCE;
    }

    private Object data;
    EnumInstance(Object obj) {
        this.data = obj;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
