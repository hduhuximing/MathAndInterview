package com.basicLearn;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/6 12:24 下午
 */
abstract class InnerClasss1 {
    private int age1 = 100;
    private int name1 = 200;

    public abstract int tinit() ;

    public int getName() {
        return 0;
    }

    public int getAge1() {
        return 0;
    }
}

public class InnerInit {

    public InnerClasss1 getInnerClass(final int age, final int name) {
        return new InnerClasss1() {
            private int age1;
            private int name1;

            {
                age1 = age;
                name1 = name;
            }

            @Override
            public int tinit() {
                return 0;
            }

            public int getName() {
                return name1;
            }

            public int getAge1() {
                return age1;
            }
        };
    }

    public static void main(String[] args) {
        InnerInit innerInit = new InnerInit();
        InnerClasss1 innerClass = innerInit.getInnerClass(10, 11);
        System.out.println(innerClass.getAge1());
    }
}
