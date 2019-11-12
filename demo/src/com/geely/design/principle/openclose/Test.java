package com.geely.design.principle.openclose;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(
                96,
                "Java从零到企业级电商开发",
                348d);
        //父类生命子类引用无法拿到父类中没有的方法
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID:" + javaCourse.getId() +
                " 课程名称:" + javaCourse.getName() +
                " 课程原价:" + javaCourse.getPrice() +
                " 课程折后价格:" + javaCourse.getDiscountPrice() +
                "元");


    }
}
