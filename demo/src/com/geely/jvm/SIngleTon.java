package com.geely.jvm;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/23 9:32 下午
 */
public class SIngleTon {
    private static SIngleTon singleTon = new SIngleTon();
    public static int count1;
    public static int count2 = 1;

    private SIngleTon() {
        count1++;
        count2++;
    }

    public static SIngleTon getInstance() {
        return singleTon;
    }

}

class Test {
    public static void main(String[] args) {
        SIngleTon singleTon = SIngleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
