package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/3 12:44 下午
 * @description
 */
public class leetcode123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell1 = 0;
        int buy1 = -prices[0];
        int sell2 = 0;
        int buy2 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);

            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy2 = Math.max(buy2, -prices[i] + sell1);
        }
        return sell2;
    }
}
