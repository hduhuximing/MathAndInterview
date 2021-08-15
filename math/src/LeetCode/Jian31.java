package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:45 下午
 * @description
 */
public class Jian31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();


//        Stack<Integer> stack = new Stack<>();
//        int index = 0;
//        for (int i = 0; i < popped.length; i++) {
//            stack.push(pushed[i]);
//            while (!stack.isEmpty() && stack.peek() == popped[index]) {
//                index++;
//                stack.pop();
//            }
//        }
//        return stack.isEmpty();
    }
}
