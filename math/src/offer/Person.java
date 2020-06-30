package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/27 3:17 下午
 * @description
 */
public class Person {
    private String name;
    private int age;
    private String sex;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "this name is " + name;
    }

}

class Husband extends Person {

    public String toString() {
        setName("chenssy");    //调用父类的setName();
        return super.toString();    //调用父类的toString()方法
    }

    public static void main(String[] args) {
        Husband husband = new Husband();

        System.out.println(husband.toString());
    }
}


