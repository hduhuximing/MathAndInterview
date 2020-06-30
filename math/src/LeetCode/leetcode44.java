package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 11:42 上午
 * @description 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode44 {
    public boolean isMatch(String s, String p) {
        int ss = 0;
        int pp = 0;
        int star = -1;
        int match = 0;
        while (ss < s.length()) {
            //先匹配
            if (pp < p.length() && (s.charAt(ss) == p.charAt(pp) || p.charAt(pp) == '?')) {
                pp++;
                ss++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star = pp;
                match = ss;
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                ss = ++match;
            } else {
                return false;
            }
        }
        if (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }
}
