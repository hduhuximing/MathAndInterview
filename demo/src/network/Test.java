package network;

import sun.plugin2.main.client.MessagePassingOneWayJSObject;

import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/18 7:02 下午
 * @description 优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 */

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {

}

class D extends B {

}


public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        //向上转化
        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        //当前方法
        System.out.println("3--" + a1.show(d));
        //
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        //A类有
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}
