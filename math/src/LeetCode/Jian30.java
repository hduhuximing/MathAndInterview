package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:44 下午
 * @description
 */
public class Jian30 {


    class MinStack {

        private int[] stack;    // 数组栈
        private int capacity;  // 容量
        //指向当前的数据
        private int topIndex;  // 栈顶索引
        private int minIndex;   // 最小值索引

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.capacity = 10;
            this.topIndex = -1;
            this.minIndex = 0;
            stack = new int[capacity];
        }

        public void push(int x) {
            if ((topIndex + 1) == capacity) {
                grow();
            }
            stack[++topIndex] = x;
            refreshByPush();
        }

        public void pop() {
            if (topIndex == -1) {
                throw new IllegalStateException("空栈");
            }
            //出栈的如果是min位置，需要重新选取min
            stack[topIndex--] = 0;
            if (topIndex + 1 == minIndex) {
                minIndex = 0;
                refreshMin();
            }
        }

        public int top() {
            if (topIndex < 0) {
                throw new IllegalStateException("空栈");
            }
            return stack[topIndex];
        }

        public int min() {
            if (topIndex < 0) {
                throw new IllegalStateException("空栈");
            }
            return stack[minIndex];
        }

        private void grow() {
            capacity = capacity + (capacity >> 1);
            stack = Arrays.copyOf(stack, capacity);
            // 底层调用的是arraycopy
            // int[] newStack = new int[capacity];
            // System.arraycopy(stack, 0, newStack, 0, topIndex + 1);
            // stack = newStack;
        }


        private void refreshByPush() {
            if (stack[minIndex] > stack[topIndex]) {
                minIndex = topIndex;
            }
        }

        //遍历数组所有数据找到最小的
        private void refreshMin() {
            for (int i = minIndex; i < topIndex + 1; i++) {
                if (stack[minIndex] > stack[i]) {
                    minIndex = i;
                }
            }
        }

        public int size() {
            return topIndex + 1;
        }

        public int capacity() {
            return capacity;
        }
    }
}
