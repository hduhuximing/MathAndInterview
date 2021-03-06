package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 6:38 下午
 * @description 高的不动，矮的动，设置左边最大和右边最大，只要比max- left or right大小，res+差值
 */
public class leetcode42 {
    public static int trap(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int leftMax = 0;
//        int rightMax = 0;
//        int res = 0;
//        while (left < right) {
//            if (height[left] < height[right]) {
//                leftMax = Math.max(leftMax, height[left]);
//                res += leftMax - height[left];
//                left++;
//            } else {
//                rightMax = Math.max(rightMax, height[right]);
//                res += rightMax - height[right];
//                right--;
//            }
//        }
//        return res;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int l = stack.peek();
                int r = i;
                int h = Math.min(height[r], height[l]) - height[cur];
                res += (r - l - 1) * h;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
}
