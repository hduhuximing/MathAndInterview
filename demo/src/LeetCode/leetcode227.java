package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/6/1 9:12 下午
 * @description
 */
public class leetcode227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] ret;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            ch = s.charAt(i);
            ret = getNum(s, i);
            if (Character.isDigit(ch) || ch == '+') {
                stack.push(ret[0]);
            } else if (ch == '-') {
                stack.push(-ret[0]);
            } else if (ch == '*') {
                stack.push(stack.pop() * ret[0]);
            } else if (ch == '/') {
                stack.push((stack.pop() / ret[0]));
            }
            i = ret[1];
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private int[] getNum(String s, int i) {
        int num = 0;
        while (!Character.isDigit(s.charAt(i))) {
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i++) - 'a';
        }
        return new int[]{num, i - 1};
    }
}