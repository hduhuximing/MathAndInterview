package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 1:27 下午
 * @description
 */
public class leetcode38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder buf = new StringBuilder();
            char[] ch = str.toCharArray();
            int time = 1;
            for (int j = 1; j < ch.length; j++) {
                if (ch[j] == ch[j - 1]) {
                    time++;
                } else {
                    buf.append(time).append(ch[j - 1]);
                    time = 1;
                }
            }
            str = buf.append(time).append(ch[ch.length - 1]).toString();
        }
        return str;
    }
}
