package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:22 下午
 * @description
 */
public class Jian5 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("%20");
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

    public String replaceSpace1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("%20");
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
