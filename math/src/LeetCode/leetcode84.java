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
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        //升序排列
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            //出现降序直接移除栈顶并计算
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int stackTop = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = stackTop * (i - 1 - start);
                res = Math.max(area, res);
            }

            stack.push(i);
        }
        return res;
    }
}
