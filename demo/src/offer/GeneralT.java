package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/28 9:26 下午
 * @description
 */
public class GeneralT<T> {
    private T key;

    public GeneralT(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "GeneralT{" +
                "key=" + key +
                '}';
    }

    public static void main(String[] args) {
        GeneralT<String> gen = new GeneralT<>("hello");
    }
}
