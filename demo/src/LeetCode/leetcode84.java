package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 8:10 下午
 * @description
 */
public class leetcode84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int top = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = top * (i - start - 1);
                res = Math.max(area, res);
            }
            stack.push(i);
        }
        return res;
    }
}