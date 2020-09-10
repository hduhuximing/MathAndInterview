package LeetCode;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/1 10:04 下午
 * @description
 */
public class leetcode901 {
    class StockSpanner {
        //用栈实现。栈中从低到顶从大到小。
        Stack<Integer> prices, weights;

        public StockSpanner() {
            //价值以及跨度
            prices = new Stack();
            weights = new Stack();
        }

        public int next(int price) {
            int w = 1;
            //弹出所有比当前小的数据，并将跨度求和
            while (!prices.isEmpty() && prices.peek() < price) {
                prices.pop();
                w += weights.pop();
            }
            //保存到当前位置的weight
            prices.push(price);
            weights.push(w);
            return w;
        }
    }
}
