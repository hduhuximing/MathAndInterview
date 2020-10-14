package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/13 7:16 下午
 * @description
 */
public class A<T> {
    public T get() {
        return null;
    }

    public <X> X getX() {
        return null;
    }

    public static void main(String[] args) {
        A<String> a = new A();
        Integer x = a.getX();
    }
}
