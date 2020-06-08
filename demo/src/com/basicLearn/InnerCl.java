package com.basicLearn;

import org.apache.ibatis.javassist.runtime.Inner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/6 12:06 下午
 * @descirption
 * 简单理解就是，拷贝引用，为了避免引用值发生改变，例如被外部类的方法修改等，
 * 而导致内部类得到的值不一致，于是用final来让该引用不可改变。
 * 故如果定义了一个匿名内部类，并且希望它使用一个其外部定义的参数，那么编译器会要求该参数引用是final的。
 */
    class father {
    public int strong() {
        return 10;
    }
}

class mother {
    public int kind() {
        return 10;
    }
}

public class InnerCl {
    private int age = 10;

    public class InnerClass {
        private int name;
        private int age;

        public void InnerMethod() {
            System.out.println(age);
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }
    //用内部类可以实现多重继承

    /**
     * 内部类继承Father类
     */
    class Father_1 extends father {
        public int strong() {
            return super.strong() + 1;
        }
    }

    class Mother_1 extends mother {
        public int kind() {
            return super.kind() - 2;
        }
    }

    public int getfatherStrong() {
        return new Father_1().strong();
    }

    public int getmotherKing() {
        return new Mother_1().kind();
    }

    public static void main(String[] args) {
        InnerCl innerCl=new InnerCl();
        InnerCl.Father_1 father_1=innerCl.new Father_1();
        System.out.println(father_1.strong());
        System.out.println(innerCl.getfatherStrong());


        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(1/2);
    }
}
