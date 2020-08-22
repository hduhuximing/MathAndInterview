package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/11 7:49 下午
 * @description
 */
public class leetcode1019 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        Stack<Integer> input = new Stack<>();
        while (head != null) {
            input.push(head.val);
            head = head.next;
            size++;
        }
        int[] res = new int[size];
        Stack<Integer> stack = new Stack<>();
        while (!input.isEmpty()) {
            size--;
            while (!stack.isEmpty() && input.peek() > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[size] = 0;
            } else {
                res[size] = stack.pop();
            }
            stack.push(input.pop());
        }
        return res;
    }

}
