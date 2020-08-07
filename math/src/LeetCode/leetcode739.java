package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/7 12:03 下午
 * @description
 */
public class leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] temp = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                stack.pop();
            }
            temp[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return temp;
    }
}
