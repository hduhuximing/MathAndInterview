package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/4 9:59 下午
 * @description
 */
public class leetcode309 {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int free = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, free - prices[i]);
            free = temp;
        }
        return sell;
    }
}
