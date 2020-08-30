package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/28 7:41 下午
 * @description
 */
public class OneUpdate {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        if (len2 > len1) {
            return oneEditAway(second, first);
        }
        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(1).equals(second.substring((len1 == len2 ? i + 1 : i)));
            }
        }
        return true;
    }
}
