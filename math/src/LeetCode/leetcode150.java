package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/3 2:05 下午
 * @description
 */
public class leetcode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (curr.equals("+") ||
                    curr.equals("-") ||
                    curr.equals("*") ||
                    curr.equals("/")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                if (curr.equals("+")) {
                    stack.push(v2 + v1);
                }
                if (curr.equals("-")) {
                    stack.push(v2 - v1);
                }
                if (curr.equals("*")) {
                    stack.push(v2 * v1);
                }
                if (curr.equals("/")) {
                    stack.push(v2 / v1);
                }
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        return stack.peek();
    }
}
