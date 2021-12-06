package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:49 下午
 * @description
 */
public class Jian66 {
    public int[] constructArr(int[] a) {
        int length = a.length;
        if (length == 0) {
            return a;
        }
        int[] b = new int[length];
        b[0] = 1;
        for (int i = 1; i < length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = a[length - 1];
        for (int j = length - 2; j >= 0; j--) {
            b[j] *= temp;
            temp *= a[j];
        }
        return b;
    }

    public int[] constructArr1(int[] a) {
        int len = a.length;
        if (len == 0) {
            return a;
        }
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = a[i - 1] * res[i - 1];
        }
        int temp = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            res[i] *= temp;
            temp *= a[i];
        }
        return res;
    }
}
