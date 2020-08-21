package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:52 下午
 * @description
 */
public class Jian67 {
    public int strToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int symbol = 1;
        //长度太长int不够
        long res = 0;
        if (str.charAt(0) == '-') {
            symbol = -1;
        }
        for (int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0; i < len; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            res = res * 10 + c - '0';
            if (res >= Integer.MAX_VALUE) {
                break;
            }
        }
        //最大值和最小值进行比较
        if (res * symbol >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res * symbol <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res * symbol;
        }
    }
}
