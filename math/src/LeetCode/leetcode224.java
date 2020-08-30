package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/6/1 9:25 下午
 * @description
 */
public class leetcode224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            //判断数字，将整体的数字全取出来
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int curr = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    curr = curr * 10 + s.charAt(++i) - '0';
                }
                res += curr * sign;
                //判断加减号的时候，
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
