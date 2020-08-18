package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 9:35 下午
 * @description
 */
public class Jian20 {
    private int index = 0;

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean flag = scanSign(s);
        if (index < s.length() && s.charAt(index) == '.') {
            index++;
            flag = scanUnSignInteger(s) || flag;
        }
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            flag = flag && scanSign(s);
        }
        return flag && index == s.length();
    }

    private boolean scanSign(String s) {
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            index++;
        }
        return scanUnSignInteger(s);
    }

    private boolean scanUnSignInteger(String str) {
        int start = index;
        while (index < str.length() && (str.charAt(index) >= '0' && str.charAt(index) <= '9')) {
            index++;
        }
        return start < index;
    }
}
