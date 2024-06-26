package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:32 下午
 * @description
 */
public class Jian9 {
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        //什么时候第二个为空了，才用第一个栈全出来加入第二个，最终结果从第二个栈中找
        public int deleteHead() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    class CQueue1 {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue1() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        //什么时候第二个为空了，才用第一个栈全出来加入第二个，最终结果从第二个栈中找
        public int deleteHead() {
            // 如果两个都是空的直接返回
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }
            //第二个非空，直接返回，查看第一个是否为空，第一个的都弹出来扔进第二个
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }


}
