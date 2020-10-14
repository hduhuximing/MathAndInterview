package LeetCode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/27 10:40 下午
 * @description 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 */
public class leetcode394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        LinkedList<String> str = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        StringBuilder curr = new StringBuilder();
        int nu = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                nu = nu * 10 + c - '0';
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                curr.append(c);
            } else if (c == '[') {
                str.push(curr.toString());
                curr = new StringBuilder();
                num.push(nu);
                nu = 0;
            } else {
                StringBuilder pre = new StringBuilder(Objects.requireNonNull(str.poll()));
                int N = num.pop();
                for (int j = 0; j < N; j++) {
                    pre.append(curr);
                }
                curr = pre;
            }
        }
        return curr.toString();
    }
}
