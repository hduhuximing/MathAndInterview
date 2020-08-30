package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/24 8:55 下午
 * @description
 */
public class leetcode496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.peek(), -1);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.get(findNums[i]);
        }
        return findNums;
    }
}
